# SmoothMotion 🚀

SmoothMotion is a **Kotlin library for Jetpack Compose** that makes animations and transitions effortless.  
It provides **pre-built animations for common UI interactions** and **utility functions for complex effects** — so you can focus on building beautiful UIs faster.  

[![GitHub stars](https://img.shields.io/github/stars/abdullahalhakimi/SmoothMotion?style=social)](https://github.com/abdullahalhakimi/SmoothMotion/stargazers)
[![JitPack](https://jitpack.io/v/abdullahalhakimi/SmoothMotion.svg)](https://jitpack.io/#abdullahalhakimi/SmoothMotion)
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/abdullahalhakimi/SmoothMotion/pulls)

---

## ✨ Features
- 🎬 Ready-to-use loading & progress animations  
- ⚡ Built for **Jetpack Compose** — clean & modern API  
- 🎨 Customizable colors, sizes, and speeds  
- 🪶 Lightweight, no unnecessary dependencies  
- 🔧 Utility functions for advanced motion  

---

## 📸 Demo

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


## 📄 License
This project is licensed under the [Apache License 2.0](LICENSE).  
