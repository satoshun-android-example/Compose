package com.github.satoshun.example

import androidx.compose.Model

@Model
object ScreenStatus {
  var currentScreen: Screen = Screen.Home
}

fun ScreenStatus.navigateTo(screen: Screen) {
  currentScreen = screen
}

sealed class Screen {
  abstract val name: String

  object Home : Screen() {
    override val name: String = "HOME"
  }

  object ConstraintLayout : Screen() {
    override val name: String = "ConstraintLayout"
  }

  companion object {
    val detailScreens = listOf(ConstraintLayout)
  }
}
