package com.abdullahalhakimi.smoothmotion.transitions

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically

val customSlideInHorizontally: EnterTransition by lazy {
    slideInHorizontally(
        initialOffsetX = { it },
        animationSpec = tween(durationMillis = 300)
    ) + fadeIn(animationSpec = tween(300))
}

val customSlideOutHorizontally: ExitTransition by lazy {
    slideOutHorizontally(
        targetOffsetX = { -300 },
        animationSpec = tween(300)
    )
}
val customPopSlideInHorizontally: EnterTransition by lazy {
    slideInHorizontally(
        initialOffsetX = { -300 },
        animationSpec = tween(300)
    ) + fadeIn(animationSpec = tween(300))
}

val customPopSlideOutHorizontally: ExitTransition by lazy {
    slideOutHorizontally(
        targetOffsetX = { it },
        animationSpec = tween(300)
    )
}
val customSlideInVertically: EnterTransition by lazy {
    slideInVertically(
        initialOffsetY = { it },
        animationSpec = tween(300)
    )
}

val customSlideOutVertically: ExitTransition by lazy {
    slideOutVertically(
        targetOffsetY = { it },
        animationSpec = tween(300)
    )
}