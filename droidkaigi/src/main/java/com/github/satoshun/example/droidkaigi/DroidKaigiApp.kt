package com.github.satoshun.example.droidkaigi

import androidx.compose.Composable
import androidx.compose.Providers
import androidx.ui.material.MaterialTheme
import com.github.satoshun.example.droidkaigi.home.DroidKaigiHomeScreen
import com.github.satoshun.example.droidkaigi.sessiondetail.DroidKaigiSessionDetailScreen

@Composable
fun DroidKaigiApp() {
  MaterialTheme(colors = lightThemeColors) {
    Providers(
      BackStackAmbient provides BackStack()
    ) {
      when (val currentScreen = BackStackAmbient.current.currentScreen) {
        Screen.Home -> DroidKaigiHomeScreen()
        is Screen.SessionDetail -> DroidKaigiSessionDetailScreen(currentScreen.from)
      }
    }
  }
}
