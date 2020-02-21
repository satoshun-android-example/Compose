package com.github.satoshun.example.adapterlist

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Row
import androidx.ui.unit.dp

@Composable
fun ExampleAdapterList() {
  AdapterList((0..100).toList()) {
    Clickable(onClick = { }) {
      Row(modifier = LayoutPadding(16.dp)) {
        //      val image = imageResource(R.drawable.img)
//      Container(modifier = LayoutSize(40.dp, 40.dp)) { DrawImage(image) }
        Text("$it")
      }
    }
  }
}
