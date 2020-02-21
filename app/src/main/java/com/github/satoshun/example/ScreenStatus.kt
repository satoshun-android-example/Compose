package com.github.satoshun.example

import androidx.compose.Model

@Model
data class ScreenStatus(
  var currentScreen: Screen = Screen.Home
)

sealed class Screen {
  abstract val name: String

  object Home : Screen() {
    override val name: String = "HOME"
  }

  object ConstraintLayout : Screen() {
    override val name: String = "ConstraintLayout"
  }

  object Flex : Screen() {
    override val name: String = "Flex"
  }

  companion object {
    val detailScreens = listOf(ConstraintLayout, Flex)
  }
}
