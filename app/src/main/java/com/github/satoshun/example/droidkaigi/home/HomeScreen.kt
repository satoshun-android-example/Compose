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
import androidx.ui.layout.Container
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
  val category: String,
  val icon: Any?
)

private val data = listOf(
  HomeItem(
    startAt = "10:00",
    title = "ウェルカムトーク",
    speaker = null,
    duration = "20min",
    category = "App Bars",
    icon = null
  ),
  HomeItem(
    startAt = "10:20",
    title = "UnderStanding Kotlin coroutines: コルーチンで進化するアプリケーション開発",
    speaker = "mhidaka",
    duration = "40min",
    category = "App Bars",
    icon = null
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
          right constrainTo parent.right
          top constrainTo startTime.top
          horizontalBias = 0f
          left.margin = 16.dp
        }
        title.apply {
          left constrainTo durationAndCategory.left
          top constrainTo durationAndCategory.bottom
          right constrainTo durationAndCategory.right
          horizontalBias = 0f
          top.margin = 8.dp
        }
      }) {
        Text(
          modifier = LayoutTag("startTime"),
          text = model.startAt,
          style = TextStyle(
            fontSize = 16.sp,
            color = Color(0x95000000),
            fontWeight = FontWeight.W500
          )
        )

        Text(
          modifier = LayoutTag("durationAndCategory"),
          text = "${model.duration} / ${model.category}",
          style = TextStyle(fontSize = 12.sp, color = Color(0x95000000))
        )
        Container(modifier = LayoutTag("title")) {
          Text(
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
}
