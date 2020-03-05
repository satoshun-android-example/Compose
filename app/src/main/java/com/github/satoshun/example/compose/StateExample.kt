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
import androidx.ui.material.Checkbox
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

class RememberTest(
  var count: Int = 0
)

@Model
class Remember2Test(
  var count: Int = 0
)

@Model
class Remember3Test {
  var count: Int = 0
    private set

  fun addCount() {
    count += 1
  }
}

@Composable
fun MyCheckbox() {
  var checked by state { false }

  Checkbox(checked = checked, onCheckedChange = { checked = it })
}

@Composable
fun StateExample() {
  var count by state { 0 }
  val (count2, count2Callback) = state { 0 }

  Column {
    MyCheckbox()

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

    OnlyState()
    ModelAndState()
    OnlyModel()

    PassModelValue()

    Remember()
    PrivatePropertyModel()
  }
}

@Composable
private fun PassModelValue() {
  val count = Remember2Test()

  Container(LayoutPadding(start = 24.dp)) {
    Text(text = "Parent Model")
  }

  println("a")
  Ripple(bounded = false) {
    println("b")
    Clickable(onClick = {
      println("onClick")
      count.count += 1
    }) {
      println("c")
      Container(LayoutPadding(24.dp)) {
        println("d")
        Text(text = count.count.toString())
      }
    }
  }

  PassChildValue(count = count)
}

@Composable
private fun PassChildValue(count: Remember2Test) {
  Container(LayoutPadding(start = 24.dp)) {
    Text(text = "Child Model")
  }

  println("aa")
  Ripple(bounded = false) {
    println("bb")
    Clickable(onClick = {
      println("onClick")
      count.count += 1
    }) {
      println("cc")
      Container(LayoutPadding(24.dp)) {
        println("dd")
        Text(text = count.count.toString())
      }
    }
  }
}

// NG
@Composable
private fun ColumnScope.OnlyState() {
  val count by state { RememberTest() }

  Container(LayoutPadding(start = 24.dp)) {
    Text(text = "Only State")
  }

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

// OK
@Composable
private fun ColumnScope.ModelAndState() {
  val count by state { Remember2Test() }

  Container(LayoutPadding(start = 24.dp)) {
    Text(text = "Model and State")
  }

  println("11111")
  Ripple(bounded = false) {
    println("22222")
    Clickable(onClick = {
      println("onClick")
      count.count += 1
    }) {
      println("33333")
      Container(LayoutPadding(24.dp)) {
        println("44444")
        Text(text = count.count.toString())
      }
    }
  }
}

// OK
@Composable
private fun ColumnScope.OnlyModel() {
  val count = Remember2Test()

  Container(LayoutPadding(start = 24.dp)) {
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

// NG
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

@Composable
private fun ColumnScope.PrivatePropertyModel() {
  val count = Remember3Test()

  Container(LayoutPadding(start = 24.dp)) {
    Text(text = "PrivatePropertyModel")
  }

  println("111111")
  Ripple(bounded = false) {
    println("222222")
    Clickable(onClick = {
      println("onClick")
      count.addCount()
    }) {
      println("333333")
      Container(LayoutPadding(24.dp)) {
        println("444444")
        Text(text = count.count.toString())
      }
    }
  }
}
