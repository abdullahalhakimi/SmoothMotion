package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
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
fun RotatingFilledCircleProgress(
    color: Color,
    modifier: Modifier = Modifier,
    outerArcsWidth: Dp = 4.dp,
    innerCircleAnimationDuration: Int = 2000
) {
    val outerArcsWidthInPx = with(LocalDensity.current) { outerArcsWidth.toPx() }
    val sweepAngle = remember { 135f }
    val arcsStartAngles = remember { listOf(22.5f, 202.5f) }
    val outerArcsSweepProgress = remember { Animatable(0f) }
    val innerCircleRadiusProgress = remember { Animatable(0f) }
    val outerArcsStartAngle = remember { Animatable(0f) }
    val arcsCanvasRotation = remember { Animatable(-90f) }

    LaunchedEffect(Unit) {
        while (isActive) {
            outerArcsSweepProgress.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = innerCircleAnimationDuration / 2,
                    easing = LinearEasing
                )
            )
            coroutineScope {
                launch {
                    innerCircleRadiusProgress.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = innerCircleAnimationDuration / 2,
                            easing = LinearEasing
                        )
                    )
                }
                launch {
                    outerArcsStartAngle.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = innerCircleAnimationDuration / 2,
                            easing = LinearEasing
                        )
                    )
                }
                launch {
                    outerArcsSweepProgress.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = innerCircleAnimationDuration / 2,
                            easing = LinearEasing
                        )
                    )
                }
                launch {
                    arcsCanvasRotation.animateTo(
                        targetValue = arcsCanvasRotation.value + 360f,
                        animationSpec = tween(
                            durationMillis = innerCircleAnimationDuration / 2
                        )
                    )
                }
            }
            innerCircleRadiusProgress.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = innerCircleAnimationDuration / 2,
                    easing = LinearEasing
                )
            )
            outerArcsSweepProgress.animateTo(targetValue = 0f, animationSpec = tween(0))
            outerArcsStartAngle.animateTo(targetValue = 0f, animationSpec = tween(0))
        }
    }

    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            val radius = size.width / 2
            drawCircle(
                color = color,
                radius = radius * innerCircleRadiusProgress.value
            )
        }
        Canvas(modifier = Modifier.fillMaxSize().rotate(arcsCanvasRotation.value)) {
            drawArc(
                color = color,
                startAngle = arcsStartAngles.first() + outerArcsStartAngle.value * (sweepAngle - arcsStartAngles.first()),
                sweepAngle = sweepAngle * outerArcsSweepProgress.value,
                useCenter = false,
                style = Stroke(
                    width = outerArcsWidthInPx,
                    cap = StrokeCap.Round
                )
            )
            drawArc(
                color = color,
                startAngle = arcsStartAngles[1] + outerArcsStartAngle.value * (arcsStartAngles[1] - sweepAngle),
                sweepAngle = sweepAngle * outerArcsSweepProgress.value,
                useCenter = false,
                style = Stroke(
                    width = outerArcsWidthInPx,
                    cap = StrokeCap.Round
                )
            )
        }
    }
}