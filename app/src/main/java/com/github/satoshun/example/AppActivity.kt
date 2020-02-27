package com.github.satoshun.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.state
import androidx.ui.core.setContent

class AppActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      ExampleApp(ScreenStatus(currentScreen = Screen.State))
    }
  }
}
