package com.github.satoshun.example

import androidx.compose.Composable
import androidx.compose.Model
import androidx.compose.Providers
import androidx.compose.ambientOf
import androidx.compose.remember
import androidx.lifecycle.ViewModel
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Spacer
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.unit.dp

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

val exampleViewModelAmbient = ambientOf<ExampleViewModel>()
val exampleUiModelAmbient = ambientOf<UiModel> { error("not ViewModel") }

@Composable
fun ExampleApp() {
  ContextAmbient
  val viewModel = remember { ExampleViewModel() }

  Providers(
    exampleViewModelAmbient provides viewModel,
    exampleUiModelAmbient provides viewModel.uiModel
  ) {
    Column(LayoutPadding(24.dp)) {
      ChildContainer1 {
        viewModel.onClicked()
      }
      Spacer(LayoutHeight(24.dp))
      ChildContainer1 {
        viewModel.onClicked()
      }
      Spacer(LayoutHeight(24.dp))
      ChildContainer2()

      Spacer(LayoutHeight(18.dp))
      Divider(color = Color.Blue)
      Spacer(LayoutHeight(18.dp))

      val viewModel2 = remember { ExampleViewModel() }
      Providers(
        exampleViewModelAmbient provides viewModel2,
        exampleUiModelAmbient provides viewModel2.uiModel
      ) {
        ChildContainer2()
      }

      Spacer(LayoutHeight(18.dp))
      Divider(color = Color.Blue)
      Spacer(LayoutHeight(18.dp))

      ChildContainer2()
    }
  }
}

@Composable
private fun ChildContainer1(addCount: () -> Unit) {
  val viewModel = exampleViewModelAmbient.current
  val uiModel = exampleUiModelAmbient.current

  Container {
    Button(onClick = addCount) {
      Text(text = uiModel.count.toString())
    }
  }
}

@Composable
private fun ChildContainer2() {
  val viewModel = exampleViewModelAmbient.current
  val uiModel = exampleUiModelAmbient.current

  Container {
    Button(onClick = viewModel::onClicked) {
      Text(text = uiModel.count.toString())
    }
  }
}
