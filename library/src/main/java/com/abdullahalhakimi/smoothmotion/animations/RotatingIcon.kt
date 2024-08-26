package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.*

@Composable
fun RotatingIcon(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit = { Icon(Icons.Default.Refresh, contentDescription = null) },
    color: Color = Color.Red,
    size: Int = 50,
    rotationDuration: Int = 2000,
    easing: Easing = LinearEasing
) {
    val infiniteTransition = rememberInfiniteTransition(label = "RotatingIcon")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(rotationDuration, easing = easing),
            repeatMode = RepeatMode.Restart
        ),
        label = "RotatingIcon",
    )

    Surface(
        modifier = modifier
            .size(size.dp)
            .graphicsLayer(rotationZ = rotation),
        color = color,
        shape = CircleShape
    ) {
        icon()  // This is where the icon content is displayed
    }
}