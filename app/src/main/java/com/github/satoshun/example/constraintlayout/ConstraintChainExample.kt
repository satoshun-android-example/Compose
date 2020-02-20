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
import androidx.ui.layout.constraintlayout.ConstraintSetBuilderScope
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import androidx.ui.unit.toRect

@Composable
fun ConstraintChainExample() {
  Container(modifier = LayoutHeight(200.dp)) {
    ConstraintLayout(ConstraintSet {
      val text1 = tag("text1")
      val text2 = tag("text2")
      val text3 = tag("text3")

      val chain = createHorizontalChain(
        text1, text2, text3,
        chainStyle = ConstraintSetBuilderScope.ChainStyle.Spread
      )
      chain.left.margin = 16.dp
      chain.right.margin = 16.dp

      text1.apply {
        top.margin = 32.dp
        top constrainTo parent.top
      }

      text2.apply {
        top constrainTo text1.top
      }
      text3.apply {
        top constrainTo text1.top
      }
    }) {
      Draw { canvas, parentSize ->
        canvas.drawRect(parentSize.toRect(), Paint().apply { color = Color.Magenta })
      }

      Text(
        modifier = LayoutTag("text1"),
        text = "Text1",
        style = TextStyle(fontSize = 10.sp)
      )
      Text(modifier = LayoutTag("text2"), text = "Text2", style = TextStyle(fontSize = 12.sp))
      Text(modifier = LayoutTag("text3"), text = "Text3", style = TextStyle(fontSize = 14.sp))
    }
  }
}
