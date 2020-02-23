package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.LayoutTag
import androidx.ui.core.Text
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.Spacer
import androidx.ui.layout.constraintlayout.ConstraintLayout
import androidx.ui.layout.constraintlayout.ConstraintSet
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.github.satoshun.example.R

@Composable
fun HomeScreen(openDrawer: () -> Unit) {
  Column {
    TopAppBar(
      title = {
        Text(text = "")
        Container(modifier = LayoutSize(24.dp)) {
          val icon = imageResource(id = R.drawable.ic_droidkaigi_logo)
          DrawImage(image = icon)
        }
      },
      navigationIcon = {
        Ripple(bounded = false) {
          Clickable({ openDrawer() }) {
            Container(modifier = LayoutSize(44.dp)) {
              val icon = Icons.Default.Menu
              DrawVector(icon, tintColor = Color.White)
            }
          }
        }
      },
      actionData = listOf("Search"),
      action = {
        Ripple(bounded = false) {
          Clickable({ }) {
            Container(modifier = LayoutSize(44.dp)) {
              val icon = vectorResource(id = R.drawable.ic_baseline_search_24)
              DrawVector(icon, tintColor = Color.White)
            }
          }
        }
      }
    )

    HomeTab()

    VerticalScroller(modifier = LayoutFlexible(1f)) {
      Column {
        HomeItemList()
      }
    }
  }
}

@Composable
fun HomeTab() {
  val (state, setState) = state { 0 }
  val titles = listOf("DAY 1", "DAY 2", "EVENT", "MY PLAN")

  Container {
    TabRow(
      items = titles,
      selectedIndex = state
    ) { index, text ->
      Tab(
        text = text,
        selected = state == index,
        onSelected = { setState(index) }
      )
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
    icon = R.drawable.ic_droidkaigi_logo
  )
//  HomeItem(
//    startAt = "10:20",
//    title = "UnderStanding Kotlin coroutines: コルーチンで進化するアプリケーション開発",
//    speaker = "mhidaka",
//    duration = "40min",
//    category = "App Bars",
//    icon = null
//  )
)

@Composable
private fun HomeItemList() {
  AdapterList(data = data) { model ->
    Box(modifier = LayoutPadding(12.dp)) {
      ConstraintLayout(constraintSet = ConstraintSet {
        val startTime = tag("startTime")
        val durationAndCategory = tag("durationAndCategory")
        val title = tag("title")
        val icon = tag("icon")
        val label = tag("label")

        startTime.apply {
          left constrainTo parent.left
          top constrainTo parent.top
        }
        durationAndCategory.apply {
          left constrainTo startTime.right
//          right constrainTo label.left
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
        icon.apply {
          left constrainTo title.left
          top constrainTo title.bottom
          top.margin = 8.dp
        }
        label.apply {
          left constrainTo durationAndCategory.right
          right constrainTo parent.right
          horizontalBias = 1.0f
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

        Text(
          modifier = LayoutTag("title"),
          text = model.title,
          style = TextStyle(
            fontSize = 20.sp,
            color = Color(0xFF041E42),
            fontWeight = FontWeight.W500
          )
        )

        if (model.icon is Int) {
//          Container(modifier = LayoutSize(24.dp) + LayoutTag("icon")) {
//            val icon = imageResource(id = model.icon)
//            DrawImage(image = icon)
//          }
        }

        Container(modifier = LayoutTag("label"), width = 24.dp) {
        }
      }
    }
    Spacer(modifier = LayoutHeight(26.dp))
  }
}
