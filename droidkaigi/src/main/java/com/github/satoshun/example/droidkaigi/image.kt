package com.github.satoshun.example.droidkaigi

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.graphics.Color
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutSize
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp

@Composable
fun VectorImage(
  vectorImage: VectorAsset,
  modifier: Modifier = Modifier.None,
  tintColor: Color = Color.Transparent
) {
  Container(modifier = modifier + LayoutSize(vectorImage.defaultWidth, vectorImage.defaultHeight)) {
    DrawVector(vectorImage, tintColor = tintColor)
  }
}

@Composable
fun VectorImage(
  @DrawableRes id: Int,
  modifier: Modifier = Modifier.None,
  tintColor: Color = Color.Transparent
) {
  val vectorImage = vectorResource(id = id)
  DrawVector(vectorImage, tintColor = tintColor)
}

@Composable
fun SimpleImage(
  @DrawableRes id: Int,
  modifier: Modifier = Modifier.None
) {
  val image = imageResource(id = id)
  Container(modifier = modifier + LayoutSize(image.width.dp, image.height.dp)) {
    androidx.ui.foundation.SimpleImage(image = image)
  }
}
