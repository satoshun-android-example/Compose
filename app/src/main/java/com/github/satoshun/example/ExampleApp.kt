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
    in Screen.detailScreens -> ExampleDetailApp(screenStatus)
    else -> throw IllegalStateException("unknown screen")
  }
}

@Composable
fun ExampleHomeApp(status: ScreenStatus) {
  val screenStatus = remember { status }

  AdapterList(Screen.detailScreens) { screen ->
    ListItem(text = screen.name, onClick = {
      screenStatus.currentScreen = screen
    })
  }
}

@Composable
fun ExampleDetailApp(status: ScreenStatus) {
  when (status.currentScreen) {
    Screen.ConstraintLayout -> {
      ConstraintExample()
      ConstraintChainExample()
    }
    else -> throw IllegalStateException("unknown detail screen")
  }
}
