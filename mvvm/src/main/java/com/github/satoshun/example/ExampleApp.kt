package com.github.satoshun.example

import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.Providers
import androidx.compose.ambientOf
import androidx.compose.remember
import androidx.lifecycle.ViewModel
import androidx.ui.core.Text
import androidx.ui.layout.Container
import androidx.ui.material.Button

class ExampleViewModel : ViewModel() {
  val uiModel = UiModel()

  fun onClicked() {
    uiModel.count += 1
  }
}

@Model
class UiModel {
  // TODO only update from ViewModel
  var count = 0
}

val exampleViewModelAmbient = ambientOf<ExampleViewModel> { error("not ViewModel") }

@Composable
fun ExampleApp() {
  val viewModel = remember { ExampleViewModel() }
  ChildContainer1(viewModel, viewModel.uiModel)
}

@Composable
private fun ChildContainer1(
  viewModel: ExampleViewModel,
  uiModel: UiModel
) {
  Container {
    Button(onClick = { viewModel.onClicked() }) {
      Text(text = uiModel.count.toString())
    }
  }
}

//@Composable
//fun ExampleApp() {
//  Providers(exampleViewModelAmbient provides ExampleViewModel()) {
//    ChildContainer1()
//  }
//}
//
//@Composable
//private fun ChildContainer1() {
//  exampleViewModelAmbient.current
//}
