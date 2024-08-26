# Smooth Motion

SmoothMotion is a Kotlin library for simplifying animations and transitions in Jetpack Compose. It provides pre-built animations for common UI interactions and utility functions for implementing complex animations.

## Features
- Button press animations
- Page transitions (slide, fade, zoom)
- Loading indicators
- Expandable cards
- Rotation animations

## Installation
Add SmoothMotion to your project:

### Gradle
```gradle
dependencies {
    implementation "com.abdullahalhakimi:smoothmotion:1.0.0"
}
```

## Examples

### Animated Button
```kotlin
AnimatedButton(
    onClick = { /* Handle click */ },
    scaleDownValue = 0.9f, //Controls the scale of the button when pressed (default: 0.95f).
    animationDuration = 500, //Controls the duration of the press animation (default: 300ms).
) {
    Text(text = "Custom Button")
}
```

### Rotating Icon
```kotlin
RotatingIcon(
    modifier = Modifier.size(80.dp),
    icon = { Icon(Icons.Default.Refresh, contentDescription = "Refreshing", tint = Color.White) },
    color = Color.Blue,
    rotationDuration = 1500
)
```

### Expanding Card
```kotlin
ExpandingCard(
    headerContent = { Text("Expanding Card Header") },
    expandedContent = { Text("This is the expanded content of the card.") },
    isExpanded = isExpanded,
    onClick = { isExpanded = !isExpanded }
)
```

### Slide Transition
```kotlin
SlideTransition(targetState = showSlide) {
    Text("Slide In Content", modifier = Modifier.padding(16.dp))
}
Button(onClick = { showSlide = !showSlide }) {
    Text(if (showSlide) "Hide Slide" else "Show Slide")
}
```



### Copyright 2024 Abdullah Al-Hakimi.
