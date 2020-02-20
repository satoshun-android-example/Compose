package com.github.satoshun.example

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.unit.dp

@Composable
fun ExampleApp() {
  Row(modifier = LayoutPadding(top = 16.dp)) {
    Text("first")
    Spacer(modifier = LayoutPadding(left = 16.dp))
    Text("second")
  }
}
