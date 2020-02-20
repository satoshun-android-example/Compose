package com.github.satoshun.example

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.Row
import androidx.ui.layout.Spacer
import androidx.ui.unit.dp
import com.github.satoshun.example.constraintlayout.ConstraintChainExample
import com.github.satoshun.example.constraintlayout.ConstraintExample
import com.github.satoshun.example.flex.ExampleFlex
import com.github.satoshun.example.list.ExampleAdapter

@Composable
fun ExampleApp() {
  Column {
    Row(modifier = LayoutPadding(top = 16.dp)) {
      ExampleText()
      Spacer(modifier = LayoutPadding(left = 16.dp))
      Text("second")
    }

    Spacer(LayoutHeight(24.dp))

    ConstraintExample()
    ConstraintChainExample()
    ExampleFlex()
    ExampleAdapter()
  }
}
