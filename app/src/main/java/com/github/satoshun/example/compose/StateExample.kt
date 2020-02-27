package com.github.satoshun.example.compose

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.material.ripple.Ripple

@Composable
fun StateExample() {
  var count by state { 0 }

  Ripple(bounded = false) {
    Clickable(onClick = {
      count += 1
    }) {
      Text(text = count.toString())
    }
  }
}
