package com.github.satoshun.example.droidkaigi

import androidx.compose.Model
import androidx.compose.ambientOf
import androidx.ui.core.currentTextStyle
import com.github.satoshun.example.droidkaigi.home.HomeItem
import java.util.Stack

val BackStackAmbient = ambientOf<BackStack>()

@Model
class BackStack {
  private val stack = Stack<Screen?>().apply {
    push(null)
  }

  var currentScreen: Screen? = Screen.Home
    private set

  fun push(newScreen: Screen) {
    stack.push(currentScreen)
    currentScreen = newScreen
  }

  fun pop() {
    currentScreen = stack.pop()
  }
}

sealed class Screen {
  object Home : Screen()
  class SessionDetail(val from: HomeItem) : Screen()
}
