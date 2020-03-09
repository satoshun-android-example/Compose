package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.LayoutTag
import androidx.ui.core.Text
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.layout.constraintlayout.ConstraintLayout
import androidx.ui.layout.constraintlayout.ConstraintSet
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.ripple.Ripple
import androidx.ui.material.surface.Surface
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.github.satoshun.example.R
import com.github.satoshun.example.droidkaigi.SimpleImage
import com.github.satoshun.example.droidkaigi.VectorImage

@Composable
fun HomeScreen(openDrawer: () -> Unit) {
  val (currentTab, setTab) = state { HomeTab.DAY1 }

  Column {
    TopAppBar(
      title = {
        Text(text = "")
        Container(modifier = LayoutSize(24.dp)) {
          SimpleImage(id = R.drawable.ic_droidkaigi_logo)
        }
      },
      navigationIcon = {
        Ripple(bounded = false) {
          Clickable({ openDrawer() }) {
            VectorImage(vectorImage = Icons.Default.Menu, tintColor = Color.White)
          }
        }
      },
      actions = {
        Ripple(bounded = false) {
          Clickable({ }) {
            VectorImage(id = R.drawable.ic_baseline_search_24, tintColor = Color.White)
          }
        }
      }
    )

    HomeTabLayout(currentTab, setTab)

    Surface(color = Color(0xFF041E42)) {
      Spacer(modifier = LayoutWidth.Fill + LayoutHeight(24.dp))
    }

    VerticalScroller(modifier = LayoutFlexible(1f)) {
      when (currentTab) {
        HomeTab.DAY1 -> {
          Column {
            HomeFilterItem()
            HomeItemList2()
          }
        }
        HomeTab.DAY2 -> {
          Column {
            HomeFilterItem()
            HomeItemList()
          }
        }
      }
    }
  }
}

@Composable
fun HomeTabLayout(currentTab: HomeTab, setTab: (HomeTab) -> Unit) {
  val titles = listOf(HomeTab.DAY1, HomeTab.DAY2, HomeTab.EVENT, HomeTab.MYPLAN)

  Container {
    TabRow(
      items = titles,
      divider = {
      },
      selectedIndex = currentTab.index
    ) { index, tab ->
      Tab(
        text = {
          Text(text = tab.title)
        },
        selected = currentTab.index == index,
        onSelected = { setTab(tab) }
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
private fun HomeItemList2() {
  AdapterList(data = data) { model ->
    Row(modifier = LayoutPadding(12.dp)) {
      Column {
        Text(
          text = model.startAt,
          style = TextStyle(
            fontSize = 16.sp,
            color = Color(0x95000000),
            fontWeight = FontWeight.W500
          )
        )
      }

      Spacer(modifier = LayoutWidth(16.dp))

      Column(modifier = LayoutFlexible(flex = 1f)) {
        Text(
          modifier = LayoutTag("durationAndCategory"),
          text = "${model.duration} / ${model.category}",
          style = TextStyle(fontSize = 12.sp, color = Color(0x95000000))
        )

        Spacer(modifier = LayoutHeight(8.dp))

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
          SimpleImage(
            id = model.icon,
            modifier = LayoutSize(24.dp) + LayoutTag("icon")
          )
        }
      }

      Spacer(modifier = LayoutWidth(16.dp))

      Column {
        VectorImage(
          id = R.drawable.ic_baseline_turned_in_not_24,
          modifier = LayoutSize(width = 24.dp, height = 24.dp)
        )
      }
    }

    Spacer(modifier = LayoutHeight(26.dp))
  }
}

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
