package com.github.satoshun.example

import androidx.compose.Composable
import androidx.compose.ambientOf
import androidx.lifecycle.ViewModel

class ExampleViewModel : ViewModel() {
  var count: Int = 1
}

@Composable
fun ExampleApp() {
  ambientOf { ExampleViewModel() }

  ChildContainer1()
}

@Composable
private fun ChildContainer1() {
  val viewModel = ambientOf<ExampleViewModel>()
  viewModel.current
}
