package com.github.satoshun.example

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.foundation.AdapterList
import androidx.ui.material.ListItem
import com.github.satoshun.example.constraintlayout.ConstraintChainExample
import com.github.satoshun.example.constraintlayout.ConstraintExample

@Composable
fun ExampleApp() {
  val screenStatus = remember { ScreenStatus() }
  when (screenStatus.currentScreen) {
    Screen.Home -> ExampleHomeApp(screenStatus)
    Screen.ConstraintLayout -> ExampleDetailApp(screenStatus)
  }
}

@Composable
fun ExampleHomeApp(screenStatus: ScreenStatus) {
  AdapterList(Screen.detailScreens) { screen ->
    ListItem(text = screen.name, onClick = {
      screenStatus.navigateTo(screen)
    })
  }
}


@Composable
fun ExampleDetailApp(screenStatus: ScreenStatus) {
  when (screenStatus.currentScreen) {
    Screen.ConstraintLayout -> {
      ConstraintExample()
      ConstraintChainExample()
    }
    else -> throw IllegalStateException("unknown detail screen")
  }
}
