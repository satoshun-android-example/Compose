package com.github.satoshun.example.compose

import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.remember
import androidx.compose.state
import androidx.compose.stateFor
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.layout.Column
import androidx.ui.layout.ColumnScope
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.Divider
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

data class RememberTest(
  var count: Int = 0
)

@Model
data class Remember2Test(
  var count: Int = 0
)

@Composable
fun StateExample() {
  var count by state { 0 }
  val (count2, count2Callback) = state { 0 }
  val count3 by state { RememberTest() }
  val count4 by state { Remember2Test() }

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

    println("11111")
    Ripple(bounded = false) {
      println("22222")
      Clickable(onClick = {
        println("onClick")
        count4.count += 1
      }) {
        println("33333")
        Container(LayoutPadding(24.dp)) {
          println("44444")
          Text(text = count4.count.toString())
        }
      }
    }



    OnlyModel()

    Remember()
  }
}

// OK
@Composable
private fun ColumnScope.OnlyModel() {
  val count = Remember2Test()

  Container(LayoutPadding(left = 24.dp)) {
    Text(text = "Only Model")
  }

  println("111111")
  Ripple(bounded = false) {
    println("222222")
    Clickable(onClick = {
      println("onClick")
      count.count += 1
    }) {
      println("333333")
      Container(LayoutPadding(24.dp)) {
        println("444444")
        Text(text = count.count.toString())
      }
    }
  }
}

@Composable
private fun ColumnScope.StateFor(id: Int): Int {
  var count = stateFor(id) { 0 }
  return count.value
}

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
