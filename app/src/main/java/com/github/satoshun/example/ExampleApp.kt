package com.github.satoshun.example

import androidx.compose.Composable
import com.github.satoshun.example.constraintlayout.ConstraintChainExample
import com.github.satoshun.example.constraintlayout.ConstraintExample

@Composable
fun ExampleApp() {
  when (ScreenStatus.currentScreen) {
    Screen.Home -> ExampleHomeApp()
    in Screen.detailScreens -> ExampleDetailApp()
    else -> throw IllegalStateException("unknown screen")
  }
}

@Composable
fun ExampleHomeApp() {
//  AdapterList(Screen.detailScreens) { screen ->
//    ListItem(text = screen.name, onClick = {
//      ScreenStatus.navigateTo(screen)
//    })
//  }
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
