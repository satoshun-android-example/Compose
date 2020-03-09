package com.github.satoshun.example.droidkaigi.sessiondetail

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Row
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.github.satoshun.example.R
import com.github.satoshun.example.droidkaigi.VectorImage
import com.github.satoshun.example.droidkaigi.home.HomeItem

@Composable
fun DroidKaigiSessionDetailScreen(fromItem: HomeItem) {
  VerticalScroller {
    Column {
      Container(LayoutSize(56.dp)) {
        VectorImage(id = R.drawable.ic_baseline_arrow_back_24, tintColor = Color.Black)
      }

      Text(
        text = fromItem.title,
        modifier = LayoutPadding(start = 24.dp, end = 24.dp),
        style = TextStyle(
          fontSize = 24.sp,
          color = Color(0xFF041E42),
          fontWeight = FontWeight.W500
        )
      )
    }
  }
}
