package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.material.DrawerState
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ModalDrawerLayout
import androidx.ui.tooling.preview.Preview
import com.github.satoshun.example.droidkaigi.lightThemeColors

@Composable
fun DroidKaigiApp() {
  MaterialTheme(colors = lightThemeColors) {
    DroidKaigiHomeLayout()
  }
}

@Composable
private fun DroidKaigiHomeLayout(status: DroidkaigiStatus = DroidkaigiStatus()) {
  val (drawerState, onDrawerStateChange) = state { DrawerState.Closed }
  ModalDrawerLayout(
    drawerState = drawerState,
    onStateChange = onDrawerStateChange,
    gesturesEnabled = drawerState == DrawerState.Opened,
    drawerContent = {
      DrawerContent(
        currentScreen = status.currentScreen,
        closeDrawer = {
          status.currentScreen = it
          onDrawerStateChange(DrawerState.Closed)
        }
      )
    },
    bodyContent = {
      AppContent { onDrawerStateChange(DrawerState.Opened) }
    }
  )
}

@Composable
private fun AppContent(openDrawer: () -> Unit) {
  HomeScreen { openDrawer() }
}

@Preview
@Composable
private fun AppContentPreview() {
  HomeScreen { }
}
