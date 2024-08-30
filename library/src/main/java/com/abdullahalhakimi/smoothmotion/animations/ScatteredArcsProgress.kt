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

@Composable
fun ScatteredArcsProgress(
    backgroundColor: Color,
    activeColor: Color,
    modifier: Modifier = Modifier,
    pathWidth: Dp = 6.dp,
    duration: Int = 1000
) {
    val scatteredArcSweep = remember { 22.5f }
    val sweepOffset = remember { 45f }
    val pathWidthInPx = with(LocalDensity.current) { pathWidth.toPx() }
    val topArcStartOffset = remember { mutableStateOf(45f) }
    val topArcSweepAngle = remember { mutableStateOf(90f) }
    val transferArcStart = remember { Animatable(0f) }
    val transferArcSweepAngle = remember { Animatable(0f) }
    val bottomArcStart = remember { mutableStateOf(0f) }
    val bottomArcSweepAngle = remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        while (isActive) {
            coroutineScope {
                transferArcStart.animateTo(
                    targetValue = sweepOffset,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = scatteredArcSweep,
                    animationSpec = tween(0)
                )
                topArcStartOffset.value += scatteredArcSweep
                topArcSweepAngle.value -= scatteredArcSweep
                transferArcStart.animateTo(
                    targetValue = -sweepOffset - scatteredArcSweep * 2,
                    animationSpec = tween(duration / 8, easing = LinearEasing)
                )
                bottomArcStart.value = -sweepOffset - scatteredArcSweep * 2
                bottomArcSweepAngle.value = scatteredArcSweep
                transferArcStart.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(0)
                )
            }

            coroutineScope {
                transferArcStart.animateTo(
                    targetValue = sweepOffset + scatteredArcSweep * 3,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = scatteredArcSweep,
                    animationSpec = tween(0)
                )
                topArcSweepAngle.value -= scatteredArcSweep
                transferArcStart.animateTo(
                    targetValue = sweepOffset + scatteredArcSweep * 9,
                    animationSpec = tween(duration / 8, easing = LinearEasing)
                )
                bottomArcStart.value = 270f - scatteredArcSweep
                bottomArcSweepAngle.value += scatteredArcSweep
                transferArcStart.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(0)
                )
            }

            coroutineScope {
                transferArcStart.animateTo(
                    targetValue = sweepOffset + scatteredArcSweep,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = scatteredArcSweep,
                    animationSpec = tween(0)
                )
                topArcStartOffset.value += scatteredArcSweep
                topArcSweepAngle.value -= scatteredArcSweep
                transferArcStart.animateTo(
                    targetValue = -sweepOffset - scatteredArcSweep,
                    animationSpec = tween(duration / 8, easing = LinearEasing)
                )
                bottomArcStart.value = 270f - scatteredArcSweep
                bottomArcSweepAngle.value += scatteredArcSweep
                transferArcStart.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(0)
                )
            }

            coroutineScope {
                transferArcStart.animateTo(
                    targetValue = sweepOffset + scatteredArcSweep * 3,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = scatteredArcSweep,
                    animationSpec = tween(0)
                )
                topArcSweepAngle.value -= scatteredArcSweep
                transferArcStart.animateTo(
                    targetValue = 180f + sweepOffset,
                    animationSpec = tween(duration / 8, easing = LinearEasing)
                )
                bottomArcStart.value = 180f + sweepOffset
                bottomArcSweepAngle.value += scatteredArcSweep
                transferArcStart.animateTo(
                    targetValue = 180f + sweepOffset,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = bottomArcSweepAngle.value,
                    animationSpec = tween(0)
                )
            }

            coroutineScope {
                bottomArcStart.value = 0f
                bottomArcSweepAngle.value = 0f
                transferArcStart.animateTo(
                    targetValue = 405f,
                    animationSpec = tween(
                        durationMillis = duration / 2,
                        easing = LinearEasing
                    )
                )
                topArcStartOffset.value = sweepOffset
                topArcSweepAngle.value = sweepOffset * 2
                transferArcStart.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(0)
                )
                transferArcSweepAngle.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(0)
                )
            }
        }
    }

    Canvas(modifier = modifier.rotate(-180f)) {
        drawCircle(
            color = backgroundColor,
            style = Stroke(
                width = pathWidthInPx,
                cap = StrokeCap.Round,
            )
        )

        drawArc(
            color = activeColor,
            startAngle = topArcStartOffset.value,
            sweepAngle = topArcSweepAngle.value,
            style = Stroke(
                width = pathWidthInPx,
                cap = StrokeCap.Round
            ),
            useCenter = false
        )

        drawArc(
            color = if (transferArcStart.value == 0f) Color.Transparent else activeColor,
            startAngle = transferArcStart.value,
            sweepAngle = transferArcSweepAngle.value,
            style = Stroke(
                width = pathWidthInPx,
                cap = StrokeCap.Round
            ),
            useCenter = false
        )

        drawArc(
            color = activeColor,
            startAngle = bottomArcStart.value,
            sweepAngle = bottomArcSweepAngle.value,
            style = Stroke(
                width = pathWidthInPx,
                cap = StrokeCap.Round
            ),
            useCenter = false
        )
    }
}