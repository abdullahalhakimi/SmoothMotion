package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun AnimatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    scaleDownValue: Float = 0.95f,
    animationDuration: Int = 300,
    cornerRadius: Int = 8,
    padding: Int = 16,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    var isPressed by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed) scaleDownValue else 1f,
        animationSpec = tween(durationMillis = animationDuration),
        label = "AnimatedButton",
    )

    Surface(
        modifier = modifier
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .clickable(
                onClick = {
                    isPressed = true
                    onClick()
                    scope.launch {
                        delay(1000)
                    }
                    isPressed = false
                }
            ),
        shape = RoundedCornerShape(cornerRadius.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Box(modifier = Modifier.padding(padding.dp)) {
            content()
        }
    }
}
