package com.alyxe.exp.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

private fun DrawScope.drawMaskBackground() {
    val fullscreenPath = Path().apply {
        moveTo(0f, 0f)
        lineTo(size.width, 0f)
        lineTo(size.width, size.height)
        lineTo(0f, size.height)
    }

    val windowPath = Path().apply {
        addRoundRect(
            roundRect = RoundRect(
                rect = Rect(
                    offset = Offset(
                        x = 16.dp.toPx(),
                        y = 144.dp.toPx(),
                    ),
                    size = Size(
                        width = size.width - 32.dp.toPx(),
                        height = 226.dp.toPx(),
                    )
                ),
                cornerRadius = CornerRadius(16.dp.toPx())
            )
        )
    }

    val combinedPath = Path().apply {
        op(
            path1 = fullscreenPath,
            path2 = windowPath,
            operation = PathOperation.Difference,
        )
    }

    drawPath(
        path = combinedPath,
        color = Color.Black.copy(alpha = 0.7f),
    )
}
