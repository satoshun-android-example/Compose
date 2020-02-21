package com.github.satoshun.example

import androidx.compose.Composable
import androidx.ui.foundation.AdapterList
import androidx.ui.material.ListItem
import com.github.satoshun.example.constraintlayout.ConstraintChainExample
import com.github.satoshun.example.constraintlayout.ConstraintExample

@Composable
fun ExampleApp() {
  when (ScreenStatus.currentScreen) {
    Screen.Home -> ExampleHomeApp()
    Screen.ConstraintLayout -> ExampleDetailApp()
  }
}

@Composable
fun ExampleHomeApp() {
  AdapterList(Screen.detailScreens) { screen ->
    ListItem(text = screen.name, onClick = {
      ScreenStatus.navigateTo(screen)
    })
  }
}


@Composable
fun ExampleDetailApp() {
  when (ScreenStatus.currentScreen) {
    Screen.ConstraintLayout -> {
      ConstraintExample()
      ConstraintChainExample()
    }
    else -> throw IllegalStateException("unknown detail screen")
  }
}
