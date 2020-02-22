package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.material.DrawerState
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ModalDrawerLayout
import androidx.ui.material.surface.Surface
import com.github.satoshun.example.droidkaigi.lightThemeColors

@Composable
fun DroidKaigiHomeLayout() {
  val (drawerState, onDrawerStateChange) = state { DrawerState.Closed }

  MaterialTheme(colors = lightThemeColors) {
    ModalDrawerLayout(
      drawerState = drawerState,
      onStateChange = onDrawerStateChange,
      gesturesEnabled = drawerState == DrawerState.Opened,
      drawerContent = {
        //        AppDrawer()
      },
      bodyContent = {
        AppContent { onDrawerStateChange(DrawerState.Opened) }
      }
    )
  }
}

@Composable
private fun AppContent(openDrawer: () -> Unit) {
//  Surface(color = (MaterialTheme.colors()).background) {
  Surface {
    HomeScreen { openDrawer() }
  }
}