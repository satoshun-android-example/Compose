package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Clickable
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.material.Divider
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.material.ripple.Ripple
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun DrawerContent(
  currentScreen: DrawerType,
  closeDrawer: (type: DrawerType) -> Unit
) {
  Column(
    modifier = LayoutHeight.Fill,
    arrangement = Arrangement.Begin
  ) {
    Row(modifier = LayoutHeight(168.dp)) {
      Container(modifier = LayoutSize(60.dp)) {
        //        val icon = imageResource(id = R.drawable.ic_droidkaigi_logo)
//        DrawImage(image = icon)
      }

      Text(text = "DroidKaigi")
    }

    Divider(color = Color(0x10202020))

    val data = listOf(
      listOf(DrawerType.TIMELINE),
      listOf(DrawerType.WHAT_IS_DROIDKAIGI, DrawerType.ANNOUNCEMENT, DrawerType.FLOOR_MAP),
      listOf(DrawerType.SPONSER, DrawerType.CONTRIBUTOR, DrawerType.SETTING)
    )

    AdapterList(data = data) {
      it.forEach { type ->
        Ripple(bounded = true) {
          Clickable(onClick = {
            closeDrawer(type)
          }) {
            Row(
              modifier = LayoutPadding(
                top = 18.dp,
                bottom = 18.dp,
                left = 26.dp,
                right = 26.dp
              ) + LayoutWidth.Fill
            ) {
              Container(width = 18.dp, height = 18.dp) {
                DrawVector(
                  vectorImage = Icons.Default.Menu,
                  tintColor = if (type == currentScreen) Color(0xFF041E42) else Color(0x26000000)
                )
              }

              Spacer(modifier = LayoutWidth(36.dp))

              Text(
                text = type.title,
                style = TextStyle(
                  color = if (type == currentScreen) Color(0xFF041E42) else Color(0x26000000),
                  fontSize = 14.sp,
                  fontWeight = FontWeight.W500
                )
              )
            }
          }
        }
      }

      Divider(color = Color(0x10202020))
    }
  }
}
