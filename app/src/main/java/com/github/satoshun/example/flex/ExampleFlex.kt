package com.github.satoshun.example.flex

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Container
import androidx.ui.layout.Row

@Composable
fun ExampleFlex() {
  Row {
    Container(modifier = LayoutFlexible(flex = 1.0f)) {
      (0..100).forEach {
        Text(text = "$it")
      }
    }
  }
}
