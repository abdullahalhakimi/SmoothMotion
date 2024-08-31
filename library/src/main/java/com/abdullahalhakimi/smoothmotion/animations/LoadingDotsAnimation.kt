package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LoadingDotsAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 20.dp,
    spaceBetween: Dp = 10.dp,
    travelDistance: Dp = 15.dp,
    circleColor: Color = MaterialTheme.colorScheme.primary
) {
    val circles = listOf(
        remember { Animatable(initialValue = 0F) },
        remember { Animatable(initialValue = 0F) },
        remember { Animatable(initialValue = 0F) }
    )

    circles.forEachIndexed { index, animation ->
        LaunchedEffect(key1 = animation) {
            delay(timeMillis = index * 100L)

            animation.animateTo(
                targetValue = 1F,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        0.0F at 0 using LinearOutSlowInEasing
                        1.0F at 300 using LinearOutSlowInEasing
                        0.0F at 600 using LinearOutSlowInEasing
                        0.0F at 1200 using LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    val circlesValue = circles.map { it.value }

    val distance = LocalDensity.current.run { travelDistance.toPx() }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        circlesValue.forEach { value ->
            Box(modifier = Modifier
                .size(size = circleSize)
                .graphicsLayer {
                    translationY = -value * distance
                }
                .background(
                    color = circleColor,
                    shape = CircleShape
                )
            )
        }
    }
}