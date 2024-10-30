# Smooth Motion

SmoothMotion is a Kotlin library for simplifying animations and transitions in Jetpack Compose. It provides pre-built animations for common UI interactions and utility functions for implementing complex animations.

https://github.com/user-attachments/assets/68e449a0-e938-4598-a290-958ba33e150a

## Installation
Add the JitPack repository to your settings.gradle.kts

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```


###  Add the dependency to your build.gradle.kts
```gradle
dependencies {
    implementation ("com.github.abdullahalhakimi:SmoothMotion:1.0.1")
}
```

## Examples

### Drop Circle Progress
```kotlin
DropCircleProgress(
    modifier = Modifier.size(90.dp),
    backgroundColor = Color.Gray.copy(alpha = 0.2f),
    color = MaterialTheme.colorScheme.primary,
)
```

### Circled Dots Progress
```kotlin
CircledDotsProgress(
    modifier = Modifier.size(90.dp),
    backgroundColor = Color.Gray.copy(alpha = 0.2f),
    color = MaterialTheme.colorScheme.primary,
)
```

### Rotating Circle Progress 
```kotlin
RotatingCircleProgress(
    modifier = Modifier.size(90.dp),
    color = MaterialTheme.colorScheme.primary
)
```

### Rotating Filled Circle Progress
```kotlin
RotatingFilledCircleProgress(
    modifier = Modifier.size(90.dp),
    color = MaterialTheme.colorScheme.primary
)
```

### Loading DotsAnimation 
```kotlin
LoadingDotsAnimation(
    circleSize = 20.dp,
    spaceBetween = 10.dp,
    travelDistance = 15.dp,
    circleColor = MaterialTheme.colorScheme.primary
)
```

### Outlined Loading Dots Animation 
```kotlin
OutlinedLoadingDotsAnimation(
    color = MaterialTheme.colorScheme.primary
)
```

## ✨ Requirements
* Any IDE with SDK installed (ie.  Android Studio, VSCode, IntelliJ, etc)
* A little knowledge of Kotlin and Jetpack Compose.
* A brain to think 🤓🤓


