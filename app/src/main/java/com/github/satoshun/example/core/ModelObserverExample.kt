package com.github.satoshun.example.core

import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.core.ModelObserver
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutSize
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

@Composable
fun ModelObserverExample() {
  Column {
    ModelObserverExample1()
    ModelObserverExample2()
  }
}

@Composable
private fun ModelObserverExample2() {
  var model by state { 0 }
  val observer = remember {
    ModelObserver {
      println("ModelObserver")
      it()
    }.apply {
      enableModelUpdatesObserving(true)
    }
  }
  observer
    .observeReads(model, onCommit = {
      println("onCommit $it")
    }) {
      println("block")
    }
  Ripple(bounded = false) {
    Clickable(onClick = { model += 1 }) {
      Container(LayoutSize(44.dp)) {
        Text(text = "COUNT $model")
      }
    }
  }
}

@Composable
private fun ModelObserverExample1() {
  val model = Modellll()
  val observer = remember { ModelObserver { it() } }
  observer
    .observeReads(model, onCommit = {
      println("onCommit $it")
    }) {
      println("block")
    }
  observer.enableModelUpdatesObserving(true)

  Ripple(bounded = false) {
    Clickable(onClick = { model.count += 1 }) {
      Container(LayoutSize(44.dp)) {
        Text(text = "COUNT ${model.count}")
      }
    }
  }
}

@Model
data class Modellll(
  var count: Int = 0
)
