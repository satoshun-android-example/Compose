package com.github.satoshun.example.compose

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

@Composable
fun StateExample() {
  val (count2, count2Callback) = state { 0 }
  var count by state { 0 }

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
  }
}
