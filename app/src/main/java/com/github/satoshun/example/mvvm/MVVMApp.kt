package com.github.satoshun.example.mvvm

import androidx.compose.Composable
import androidx.compose.ambientOf
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
  var model: Int = 1
}

@Composable
fun MVVMApp() {
  val viewModel = ambientOf { AppViewModel() }
//  viewModel.current.model = 10
//  ExampleView()
}

@Composable
private fun ExampleView() {
//  val viewModel = ambientOf<AppViewModel>().current }
}
