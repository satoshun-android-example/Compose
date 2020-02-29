package com.github.satoshun.example.droidkaigi.home

import androidx.compose.Model

@Model
data class DroidkaigiStatus(
  var currentScreen: DrawerType = DrawerType.TIMELINE
)
