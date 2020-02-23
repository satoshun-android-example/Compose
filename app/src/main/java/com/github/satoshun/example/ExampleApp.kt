package com.github.satoshun.example

import androidx.compose.Composable
import androidx.ui.foundation.AdapterList
import androidx.ui.material.ListItem
import com.github.satoshun.example.adapterlist.ExampleAdapterList
import com.github.satoshun.example.constraintlayout.ConstraintChainExample
import com.github.satoshun.example.constraintlayout.ConstraintExample
import com.github.satoshun.example.core.TextExample
import com.github.satoshun.example.droidkaigi.home.DroidKaigiHomeLayout
import com.github.satoshun.example.flex.ExampleFlex
import com.github.satoshun.example.layout.ColumnExample
import com.github.satoshun.example.layout.RowExample
import com.github.satoshun.example.layout.SpacerExample

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
    Screen.AdapterList -> {
      ExampleAdapterList()
    }
    Screen.Spacer -> SpacerExample()
    Screen.Row -> RowExample()
    Screen.Column -> ColumnExample()
    Screen.Text -> TextExample()
    Screen.DroidKaigiHome -> DroidKaigiHomeLayout()
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
