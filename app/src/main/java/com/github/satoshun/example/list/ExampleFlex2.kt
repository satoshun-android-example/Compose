package com.github.satoshun.example.list

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.DrawImage
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Row
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.github.satoshun.example.R

@Composable
fun ExampleAdapter() {
  AdapterList(listOf(1, 2, 3)) {
    Row {
      val image = imageResource(R.drawable.screenshot_1582184849)
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
      Text("$it")
    }
  }
}
