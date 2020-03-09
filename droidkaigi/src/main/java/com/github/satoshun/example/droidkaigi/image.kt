package com.github.satoshun.example.droidkaigi

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.compose.onCommit
import androidx.compose.stateFor
import androidx.core.graphics.drawable.toBitmap
import androidx.ui.core.CoroutineContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.graphics.Color
import androidx.ui.graphics.Image
import androidx.ui.graphics.vector.DrawVector
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutSize
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp
import coil.Coil
import coil.api.get
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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

@Composable
fun LoadImage(uri: Uri): Image? {
  var image by stateFor<Image?>(uri) { null }
  val context = CoroutineContextAmbient.current

  onCommit(uri) {
    val job = CoroutineScope(context).launch {
//      val drawable = Coil.get(uri)
    }
    onDispose { job.cancel() }
  }

  return image
}
