package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PulsatingLoadingIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.Blue,
    size: Int = 50,
    minScale: Float = 0.8f,
    maxScale: Float = 1.2f,
    pulsationDuration: Int = 1000,
    easing: Easing = LinearEasing
) {
    val infiniteTransition = rememberInfiniteTransition(label = "LoadingIndicator")
    val scale by infiniteTransition.animateFloat(
        initialValue = minScale,
        targetValue = maxScale,
        animationSpec = infiniteRepeatable(
            animation = tween(pulsationDuration, easing = easing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "LoadingIndicator",
    )

    Surface(
        modifier = modifier
            .size(size.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale),
        color = color,
        shape = CircleShape
    ) {}
}
