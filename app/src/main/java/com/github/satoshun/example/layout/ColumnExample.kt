/*
* Copyright 2019 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.github.satoshun.example.layout

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Box
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutSize
import androidx.ui.layout.LayoutWidth
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Preview
@Composable
fun ColumnExample() {
  Column {
    Box(LayoutSize(40.dp, 80.dp), backgroundColor = Color.Magenta) {}
    Box(LayoutWidth(40.dp) + LayoutFlexible(1f), backgroundColor = Color.Yellow) {}
    Box(
      LayoutHeight(80.dp) + LayoutFlexible(1f, tight = false),
      backgroundColor = Color.Green
    ) {
      Text("hogeeee")
    }
  }
}
