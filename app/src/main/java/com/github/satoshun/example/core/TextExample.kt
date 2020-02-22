package com.github.satoshun.example.core

import androidx.compose.Composable
import androidx.ui.core.LayoutTag
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.layout.constraintlayout.ConstraintLayout
import androidx.ui.layout.constraintlayout.ConstraintSet
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
        text = (0..50).joinToString("") { "い" },
        style = TextStyle(fontSize = 20.sp)
      )
    }

    Spacer(modifier = LayoutHeight(24.dp))

    ConstraintLayout(constraintSet = ConstraintSet {
      val title = tag("title")
      title.apply {
        top constrainTo parent.top
        left constrainTo parent.left
        right constrainTo parent.right
      }
    }) {
      Text(
        modifier = LayoutTag("title"),
        text = (0..50).joinToString("") { "う" },
        style = TextStyle(fontSize = 20.sp)
      )
    }
  }
}
