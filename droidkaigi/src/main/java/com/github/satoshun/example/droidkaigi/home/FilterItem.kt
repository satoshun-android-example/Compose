package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.material.Divider
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.github.satoshun.example.R

@Composable
fun HomeFilterItem() {
  Surface(color = Color(0xFF041E42)) {
    Surface(
      color = Color.White,
      shape = RoundedCornerShape(topLeft = 24.dp)
    ) {
      Column {
        Row(
          modifier = LayoutPadding(top = 18.dp, bottom = 18.dp, right = 24.dp) + LayoutWidth.Fill,
          arrangement = Arrangement.End
        ) {
          Container(modifier = LayoutSize(22.dp)) {
            DrawVector(
              vectorImage = vectorResource(id = R.drawable.ic_baseline_filter_list_24),
              tintColor = Color.Black
            )
          }

          Spacer(modifier = LayoutWidth(8.dp))

          Ripple(bounded = false) {
            Text(
              text = "絞り込む",
              style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF041E42)
              )
            )
          }
        }

        Divider(
          modifier = LayoutPadding(left = 16.dp, right = 16.dp),
          color = Color(0x10202020)
        )
      }
    }
  }
}
