package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Composable
import androidx.ui.core.LayoutTag
import androidx.ui.core.Text
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.SimpleImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.constraintlayout.ConstraintLayout
import androidx.ui.layout.constraintlayout.ConstraintSet
import androidx.ui.material.TopAppBar
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp

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
        HomeItemList()
      }
    }
  }
}

data class HomeItem(
  val startAt: String,
  val title: String,
  val speaker: String?,
  val duration: String,
  val category: String
)

private val data = listOf(
  HomeItem(
    startAt = "10:00",
    title = "ウェルカムトーク",
    speaker = null,
    duration = "20min",
    category = "App Bars"
  )
)

@Composable
private fun HomeItemList() {
  AdapterList(data = data) { model ->
    Box(modifier = LayoutPadding(12.dp)) {
      ConstraintLayout(constraintSet = ConstraintSet {
        val startTime = tag("startTime")
        val durationAndCategory = tag("durationAndCategory")
        val title = tag("title")

        startTime.apply {
          left constrainTo parent.left
          top constrainTo parent.top
        }
        durationAndCategory.apply {
          left constrainTo startTime.right
          top constrainTo startTime.top
          left.margin = 16.dp
        }
        title.apply {
          left constrainTo durationAndCategory.left
          top constrainTo durationAndCategory.bottom
          top.margin = 8.dp
        }
      }) {
        val startTime = Text(
          modifier = LayoutTag("startTime"),
          text = model.startAt,
          style = TextStyle(
            fontSize = 16.sp,
            color = Color(0x95000000),
            fontWeight = FontWeight.W500
          )
        )
        val durationAndCategory = Text(
          modifier = LayoutTag("durationAndCategory"),
          text = "${model.duration} / ${model.category}",
          style = TextStyle(fontSize = 12.sp, color = Color(0x95000000))
        )
        val title = Text(
          modifier = LayoutTag("title"),
          text = model.title,
          style = TextStyle(
            fontSize = 20.sp,
            color = Color(0xFF041E42),
            fontWeight = FontWeight.W500
          )
        )
      }
    }
  }
}