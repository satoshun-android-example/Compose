package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.SimpleImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.layout.Column
import androidx.ui.material.TopAppBar

@Composable
fun HomeScreen(openDrawer: () -> Unit) {
  Column {
    TopAppBar(
      title = {
        Text(text = "DroidKaigi")
      },
      navigationIcon = {
        //        val context = ContextAmbient.current
//        val image = imageFromResource(context.resources, R.mipmap.ic_launcher)

        Clickable({ openDrawer() }) {
          val image = Image(80, 80)
          SimpleImage(image = image, tint = Color.Black)
        }
      }
    )
    VerticalScroller(modifier = LayoutFlexible(1f)) {
      Column {
      }
    }
  }
}
