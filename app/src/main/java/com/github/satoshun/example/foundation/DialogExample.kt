package com.github.satoshun.example.foundation

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Dialog
import androidx.ui.graphics.Color
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutSize
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

@Composable
fun DialogExample() {
  var openDialog by state { false }
  if (openDialog) {
    Dialog(onCloseRequest = { openDialog = false }) {
      Box(LayoutSize(200.dp, 200.dp), backgroundColor = Color.Blue) {}
    }
  } else {
    Ripple(bounded = false) {
      Clickable(onClick = { openDialog = true }) {
        Container(LayoutSize(100.dp)) {
          Text(text = "dialog")
        }
      }
    }
  }
}
