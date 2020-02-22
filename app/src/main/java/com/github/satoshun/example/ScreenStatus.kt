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

  object AdapterList : Screen() {
    override val name: String = "AdapterList"
  }

  object Spacer : Screen() {
    override val name: String = "Spacer"
  }

  object Row : Screen() {
    override val name: String = "Row"
  }

  object Text : Screen() {
    override val name: String = "Text"
  }

  object DroidKaigiHome : Screen() {
    override val name: String = "DroidKaigiHome"
  }

  companion object {
    val detailScreens = listOf(
      ConstraintLayout,
      Flex,
      AdapterList,
      Spacer,
      Row
    )
  }
}
