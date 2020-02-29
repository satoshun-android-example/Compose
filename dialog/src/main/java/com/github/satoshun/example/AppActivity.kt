package com.github.satoshun.example

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.LayoutWidth
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button

class AppActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.app_main)

    findViewById<View>(R.id.button).setOnClickListener {
      findViewById<ViewGroup>(R.id.root).setContent {
        var openDialog by state { true }
        if (openDialog) {
          AlertDialog(
            onCloseRequest = { openDialog = false },
            title = {
              Text(text = "TITLE!")
            },
            text = {
              Text(text = "open open!!")
            },
            buttons = {
              Button(
                modifier = LayoutWidth.Fill,
                onClick = { openDialog = false }
              ) {
                Text(text = "CLOSE")
              }
            }
          )
        }
      }
    }
  }
}
