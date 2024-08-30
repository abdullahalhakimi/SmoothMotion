package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
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
fun DroppingDotsProgress(
    backgroundColor: Color,
    activeColor: Color,
    modifier: Modifier = Modifier,
    pathWidth: Dp = 6.dp,
    duration: Int = 1500
) {
    val pathWidthInPx = with(LocalDensity.current) { pathWidth.toPx() }
    val canvasRotation = remember { Animatable(0f) }
    val bigArcStartAngle = remember { Animatable(0f) }
    val smallArcsStartAngleProgress = remember { Animatable(0.1f) }
    val isSmallArcsVisible = remember { mutableStateOf(false) }
    val smallArcsStartAngle = remember { listOf(45f, 74f, 102f, 130f) }
    val bigCircleSweepAngle = remember { 180f }
    val smallArcsSweepAngle = remember { 5f }

    LaunchedEffect(Unit) {
        while (isActive) {
            coroutineScope {
                isSmallArcsVisible.value = true
                launch {
                    bigArcStartAngle.animateTo(
                        targetValue = bigArcStartAngle.value + 180f,
                        animationSpec = tween(duration / 2, easing = LinearEasing)
                    )
                }
            }
            coroutineScope {
                launch {
                    smallArcsStartAngleProgress.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(duration, easing = LinearEasing)
                    )
                    isSmallArcsVisible.value = false
                    smallArcsStartAngleProgress.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(0)
                    )
                }
                launch {
                    canvasRotation.animateTo(
                        targetValue = canvasRotation.value + 360f,
                        animationSpec = tween(
                            durationMillis = duration,
                            easing = LinearEasing
                        )
                    )
                }
            }
            coroutineScope {
                launch {
                    bigArcStartAngle.animateTo(
                        targetValue = bigArcStartAngle.value + 180f,
                        animationSpec = tween(durationMillis = duration / 2, easing = LinearEasing)
                    )
                }
            }
        }
    }

    Canvas(modifier = modifier.rotate(canvasRotation.value)) {
        drawCircle(
            color = backgroundColor,
            style = Stroke(
                width = pathWidthInPx,
                cap = StrokeCap.Round,
            )
        )
        drawArc(
            color = activeColor,
            startAngle = bigArcStartAngle.value,
            sweepAngle = bigCircleSweepAngle,
            style = Stroke(
                width = pathWidthInPx,
                cap = StrokeCap.Round
            ),
            useCenter = false
        )
        if (isSmallArcsVisible.value) {
            smallArcsStartAngle.forEachIndexed { _, startAngel ->
                drawArc(
                    color = activeColor,
                    startAngle = (startAngel + smallArcsStartAngleProgress.value * (175f - startAngel)),
                    sweepAngle = smallArcsSweepAngle,
                    style = Stroke(
                        width = pathWidthInPx,
                        cap = StrokeCap.Round
                    ),
                    useCenter = false
                )
            }
        }
    }
}