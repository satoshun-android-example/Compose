package com.github.satoshun.example

import androidx.compose.Composable
import androidx.ui.foundation.AdapterList
import androidx.ui.material.ListItem
import com.github.satoshun.example.constraintlayout.ConstraintChainExample
import com.github.satoshun.example.constraintlayout.ConstraintExample
import com.github.satoshun.example.flex.ExampleFlex

@Composable
fun ExampleApp(screenStatus: ScreenStatus) {
  when (screenStatus.currentScreen) {
    Screen.Home -> ExampleHomeApp(screenStatus)
    Screen.ConstraintLayout -> {
      ConstraintExample()
      ConstraintChainExample()
    }
    Screen.Flex -> {
      ExampleFlex()
    }
  }
}

@Composable
fun ExampleHomeApp(screenStatus: ScreenStatus) {
  AdapterList(Screen.detailScreens) { screen ->
    ListItem(text = screen.name, onClick = {
      screenStatus.currentScreen = screen
    })
  }
}
