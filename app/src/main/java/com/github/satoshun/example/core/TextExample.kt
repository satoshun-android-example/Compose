package com.github.satoshun.example.core

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun TextExample() {
  Column {
    Text(
      text = "あああああああああああああああああああああああああああああああああああ",
      style = TextStyle(fontSize = 20.sp)
    )
    Spacer(modifier = LayoutHeight(24.dp))
    Row {
      Text(
        text = (0..50).map { "い" }.joinToString(""),
        style = TextStyle(fontSize = 20.sp)
      )
    }
  }
}
