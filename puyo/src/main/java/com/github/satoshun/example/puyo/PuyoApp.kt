package com.github.satoshun.example.puyo

import androidx.compose.Composable
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.EdgeInsets
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.material.Button
import androidx.ui.unit.dp
import com.github.satoshun.example.puyo.PuyoElement.Green
import com.github.satoshun.example.puyo.PuyoElement.Magenta
import com.github.satoshun.example.puyo.PuyoElement.RED
import com.github.satoshun.example.puyo.PuyoElement.YELLOW

@Composable
fun PuyoApp() {
  val puyos = listOf(YELLOW, RED, RED, Magenta, Green, Green)
  val columns = (0..13).toList()

  AdapterList(data = columns) {
    Row(modifier = LayoutWidth.Fill) {
      puyos.forEach { Puyo(it) }
    }
  }
}

@Composable
private fun Puyo(puyo: PuyoElement) {
  Button(
    shape = CircleShape,
    paddings = EdgeInsets(),
    backgroundColor = puyo.color,
    modifier = LayoutSize(44.dp)
  ) {
  }
}

enum class PuyoElement(
  val color: Color
) {
  RED(Color.Red),
  YELLOW(Color.Yellow),
  Magenta(Color.Magenta),
  Green(Color.Green),
}
