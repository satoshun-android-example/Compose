package com.github.satoshun.example.compose

import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.compose.stateFor
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.layout.Column
import androidx.ui.layout.ColumnScope
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

@Composable
fun StateExample() {
  var count by state { 0 }
  val (count2, count2Callback) = state { 0 }
  var count3 by state { RememberTest() }

  Column {
    println("1")
    Ripple(bounded = false) {
      println("2")
      Clickable(onClick = {
        println("onClick")
        count += 1
      }) {
        println("3")
        Container(LayoutPadding(24.dp)) {
          println("4")
          Text(text = count.toString())
        }
      }
    }

    println("11")
    Ripple(bounded = false) {
      println("22")
      Clickable(onClick = {
        println("onClick")
        count2Callback(count2 + 1)
      }) {
        println("33")
        Container(LayoutPadding(24.dp)) {
          println("44")
          Text(text = count2.toString())
        }
      }
    }

    println("1111")
    Ripple(bounded = false) {
      println("2222")
      Clickable(onClick = {
        println("onClick")
        count3.count += 1
      }) {
        println("3333")
        Container(LayoutPadding(24.dp)) {
          println("4444")
          Text(text = count3.count.toString())
        }
      }
    }

    Remember()
  }
}

@Composable
private fun ColumnScope.StateFor(id: Int): Int {
  var count = stateFor(id) { 0 }
  return count.value
}

data class RememberTest(
  var count: Int = 0
)

@Composable
private fun ColumnScope.Remember() {
  val count = remember { RememberTest() }

  println("111")
  Ripple(bounded = false) {
    println("222")
    Clickable(onClick = {
      println("onClick")
      count.count += 1
    }) {
      println("333")
      Container(LayoutPadding(24.dp)) {
        println("444")
        Text(text = count.count.toString())
      }
    }
  }
}
