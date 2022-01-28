package com.compose.hydration.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.hydration.R

@Preview
@Composable
fun Glass(modifier: Modifier = Modifier) {
    val vector = ImageVector.vectorResource(id = R.drawable.ic_glass_empty)
    val painter = rememberVectorPainter(image = vector)
    val progress = -0.5f
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier.wrapContentSize()
    ) {
        Image(painter = painter, stringResource(R.string.glass), modifier = modifier.drawBehind {
            val glassPainter = painter.intrinsicSize
            val path = Path().apply {
                relativeLineTo(glassPainter.width, 0f)
                relativeLineTo(-glassPainter.width / 5, glassPainter.height)
                relativeLineTo(-glassPainter.width / 3, size.height)
                close()
            }
            inset(horizontal = 0f, vertical = 4f) {
                clipPath(
                    path = path,
                    clipOp = ClipOp.Intersect
                ) {
                    drawRect(
                        SolidColor(Color.White),
                        size = Size(
                            size.width,
                            progress * size.height
                        ), topLeft = Offset(0f, size.height),
                        alpha = 0.4f
                    )
                }
            }
        })
        Text(text = "200 ml", modifier = Modifier.padding(16.dp))
    }
}