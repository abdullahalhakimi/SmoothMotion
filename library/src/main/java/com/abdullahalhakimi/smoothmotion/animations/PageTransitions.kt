package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.animation.core.LinearEasing
import androidx.compose.ui.Modifier
import androidx.compose.animation.*
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable

@Composable
fun SlideTransition(
    targetState: Boolean,
    modifier: Modifier = Modifier,
    enterDuration: Int = 300,
    exitDuration: Int = 300,
    enterEasing: Easing = LinearEasing,
    exitEasing: Easing = LinearEasing,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = targetState,
        enter = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(enterDuration, easing = enterEasing)
        ) + fadeIn(),
        exit = slideOutHorizontally(
            targetOffsetX = { -it },
            animationSpec = tween(exitDuration, easing = exitEasing)
        ) + fadeOut(),
    ) {
        content()
    }
}

@Composable
fun FadeTransition(
    targetState: Boolean,
    modifier: Modifier = Modifier,
    enterDuration: Int = 300,
    exitDuration: Int = 300,
    enterEasing: Easing = LinearEasing,
    exitEasing: Easing = LinearEasing,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = targetState,
        enter = fadeIn(animationSpec = tween(enterDuration, easing = enterEasing)),
        exit = fadeOut(animationSpec = tween(exitDuration, easing = exitEasing)),
    ) {
        content()
    }
}

@Composable
fun ZoomTransition(
    targetState: Boolean,
    modifier: Modifier = Modifier,
    enterDuration: Int = 300,
    exitDuration: Int = 300,
    enterEasing: Easing = LinearEasing,
    exitEasing: Easing = LinearEasing,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = targetState,
        enter = scaleIn(
            animationSpec = tween(enterDuration, easing = enterEasing)
        ) + fadeIn(),
        exit = scaleOut(
            animationSpec = tween(exitDuration, easing = exitEasing)
        ) + fadeOut(),
    ) {
        content()
    }
}
