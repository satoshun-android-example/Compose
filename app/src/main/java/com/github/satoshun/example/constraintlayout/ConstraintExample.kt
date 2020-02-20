package com.github.satoshun.example.constraintlayout

import androidx.compose.Composable
import androidx.ui.core.Draw
import androidx.ui.core.LayoutTag
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.graphics.Paint
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.constraintlayout.ConstraintLayout
import androidx.ui.layout.constraintlayout.ConstraintSet
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import androidx.ui.unit.toRect

@Composable
fun ConstraintExample() {
  Container(modifier = LayoutHeight(200.dp)) {
    ConstraintLayout(ConstraintSet {
      val text1 = tag("text1")
      val text2 = tag("text2")
      val text3 = tag("text3")

      text2.center()

      text3 constrainVerticallyTo parent
      text3.verticalBias = 1.0f
    }) {
      Draw { canvas, parentSize ->
        canvas.drawRect(parentSize.toRect(), Paint().apply { color = Color.Blue })
      }

      Text(modifier = LayoutTag("text1"), text = "Text1", style = TextStyle(fontSize = 10.sp))
      Text(modifier = LayoutTag("text2"), text = "Text2", style = TextStyle(fontSize = 12.sp))
      Text(modifier = LayoutTag("text3"), text = "Text3", style = TextStyle(fontSize = 14.sp))
    }
  }
}
