package com.github.satoshun.example.droidkaigi

import androidx.compose.Composable
import androidx.compose.Providers
import androidx.ui.material.MaterialTheme
import com.github.satoshun.example.droidkaigi.home.DroidKaigiHomeLayout
import com.github.satoshun.example.droidkaigi.sessiondetail.DroidKaigiSessionDetailLayout

@Composable
fun DroidKaigiApp() {
  MaterialTheme(colors = lightThemeColors) {
    Providers(
      BackStackAmbient provides BackStack()
    ) {
      when (BackStackAmbient.current.currentScreen) {
        Screen.Home -> DroidKaigiHomeLayout()
        is Screen.SessionDetail -> DroidKaigiSessionDetailLayout()
      }
    }
  }
}
