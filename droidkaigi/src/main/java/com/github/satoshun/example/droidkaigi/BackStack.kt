package com.github.satoshun.example.droidkaigi

import androidx.compose.Model
import androidx.compose.ambientOf
import com.github.satoshun.example.droidkaigi.home.HomeItem

val BackStackAmbient = ambientOf<BackStack>()

@Model
class BackStack(
  var currentScreen: Screen = Screen.Home
)

sealed class Screen {
  object Home : Screen()
  class SessionDetail(val from: HomeItem) : Screen()
}
