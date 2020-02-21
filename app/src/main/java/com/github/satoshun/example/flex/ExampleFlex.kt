package com.github.satoshun.example.flex

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Row
import androidx.ui.unit.dp

@Composable
fun ExampleFlex() {
  Row {
    (0..100).forEach {
      Text(modifier = LayoutPadding(8.dp), text = "$it")
    }
  }
}
