package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Composable
fun RotatingCircleProgress(
    color: Color,
    modifier: Modifier = Modifier,
    arcsWidth: Dp = 4.dp,
    arcsLayerPadding: Dp = 16.dp,
) {
    val arcsWidthInPx = with(LocalDensity.current) { arcsWidth.toPx() }
    val baseDurationMillis = remember { 1000 }
    val arcSweepOffset = remember { 90f }
    val canvasRotation = remember { Animatable(0f) }
    val outerArcsSweepProgress = remember { Animatable(0f) }
    val outerArcsStartAngleProgress = remember { Animatable(0f) }
    val innerCircleRadiusProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (isActive) {
            coroutineScope {
                launch {
                    outerArcsSweepProgress.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(baseDurationMillis)
                    )
                }
                launch {
                    canvasRotation.animateTo(
                        targetValue = canvasRotation.value + 360f,
                        animationSpec = tween(baseDurationMillis)
                    )
                }
            }
            coroutineScope {
                launch {
                    outerArcsSweepProgress.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(baseDurationMillis / 2)
                    )
                }
                launch {
                    outerArcsStartAngleProgress.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(baseDurationMillis / 2)
                    )
                }
                launch {
                    innerCircleRadiusProgress.animateTo(
                        targetValue = 1f,
                        animationSpec = tween((baseDurationMillis * 1.5).toInt())
                    )
                    outerArcsStartAngleProgress.animateTo(targetValue = 0f, animationSpec = tween(0))
                    outerArcsSweepProgress.animateTo(targetValue = 0f, animationSpec = tween(0))
                    innerCircleRadiusProgress.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(baseDurationMillis / 2)
                    )
                }
            }
        }
    }

    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize().rotate(canvasRotation.value)) {
            drawArc(
                color = color,
                startAngle = outerArcsStartAngleProgress.value * arcSweepOffset,
                sweepAngle = outerArcsSweepProgress.value * arcSweepOffset,
                useCenter = false,
                style = Stroke(
                    width = arcsWidthInPx,
                    cap = StrokeCap.Round
                )
            )

            drawArc(
                color = color,
                startAngle = 180f + outerArcsStartAngleProgress.value * arcSweepOffset,
                sweepAngle = outerArcsSweepProgress.value * arcSweepOffset,
                useCenter = false,
                style = Stroke(
                    width = arcsWidthInPx,
                    cap = StrokeCap.Round
                )
            )
        }

        Canvas(
            modifier = Modifier.fillMaxSize().padding(arcsLayerPadding).rotate(canvasRotation.value)
        ) {
            drawArc(
                color = color,
                startAngle = arcSweepOffset + outerArcsStartAngleProgress.value * arcSweepOffset,
                sweepAngle = outerArcsSweepProgress.value * arcSweepOffset,
                useCenter = false,
                style = Stroke(
                    width = arcsWidthInPx,
                    cap = StrokeCap.Round
                )
            )
            drawArc(
                color = color,
                startAngle = 270f + outerArcsStartAngleProgress.value * arcSweepOffset,
                sweepAngle = outerArcsSweepProgress.value * arcSweepOffset,
                useCenter = false,
                style = Stroke(
                    width = arcsWidthInPx,
                    cap = StrokeCap.Round
                )
            )
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            val radius = size.width / 2
            drawCircle(
                alpha = innerCircleRadiusProgress.value,
                color = color,
                radius = radius * innerCircleRadiusProgress.value,
                style = Stroke(
                    width = arcsWidthInPx,
                )
            )
        }
    }
}