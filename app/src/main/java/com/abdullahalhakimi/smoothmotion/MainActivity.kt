package com.abdullahalhakimi.smoothmotion

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.abdullahalhakimi.smoothmotion.animations.AnimatedButton
import com.abdullahalhakimi.smoothmotion.animations.AppLoadingAnimation
import com.abdullahalhakimi.smoothmotion.animations.DroppingDotsProgress
import com.abdullahalhakimi.smoothmotion.animations.ExpandingCard
import com.abdullahalhakimi.smoothmotion.animations.PulsatingLoadingIndicator
import com.abdullahalhakimi.smoothmotion.animations.RotatingIcon
import com.abdullahalhakimi.smoothmotion.animations.ScatteredArcsProgress
import com.abdullahalhakimi.smoothmotion.animations.AnimatingArcsProgress
import com.abdullahalhakimi.smoothmotion.animations.AnimatingCircleWithArcsProgress
import com.abdullahalhakimi.smoothmotion.animations.SlideTransition
import com.abdullahalhakimi.smoothmotion.utils.ProgressTitle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleMainActivityContent()
        }
    }
}

@Composable
fun ExampleMainActivityContent() {
    var isExpanded by remember { mutableStateOf(false) }
    var showSlide by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        // AnimatedButton Example
        AnimatedButton(
            onClick = {
                Log.d("A:","Ali")
            },
            modifier = Modifier,
        ) {
            Text("Animated Button")
        }

        // SlideTransition Example
        SlideTransition(targetState = showSlide) {
            Text("Slide In Content", modifier = Modifier.padding(16.dp))
        }
        Button(onClick = { showSlide = !showSlide }) {
            Text(if (showSlide) "Hide Slide" else "Show Slide")
        }

        // PulsatingLoadingIndicator Example
        PulsatingLoadingIndicator()

        // ExpandingCard Example
        ExpandingCard(
            headerContent = { Text("Expanding Card Header") },
            expandedContent = { Text("This is the expanded content of the card.") },
            isExpanded = isExpanded,
            onClick = { isExpanded = !isExpanded }
        )

        // RotatingIcon Example
        RotatingIcon(
            modifier = Modifier.size(60.dp),
            icon = { Icon(Icons.Default.Refresh, contentDescription = "Rotating Icon") },
            color = Color.Blue
        )

        AppLoadingAnimation()
    }
}

@Composable

fun AppLoadingExample() {
    var isExpanded by remember { mutableStateOf(false) }
    var showSlide by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        // AnimatedButton Example
        AnimatedButton(
            onClick = {
                Log.d("A:","Ali")
            },
            modifier = Modifier,
        ) {
            Text("Animated Button")
        }

        // SlideTransition Example
        SlideTransition(targetState = showSlide) {
            Text("Slide In Content", modifier = Modifier.padding(16.dp))
        }
        Button(onClick = { showSlide = !showSlide }) {
            Text(if (showSlide) "Hide Slide" else "Show Slide")
        }

        // PulsatingLoadingIndicator Example
        PulsatingLoadingIndicator()

        // ExpandingCard Example
        ExpandingCard(
            headerContent = { Text("Expanding Card Header") },
            expandedContent = { Text("This is the expanded content of the card.") },
            isExpanded = isExpanded,
            onClick = { isExpanded = !isExpanded }
        )

        // RotatingIcon Example
        RotatingIcon(
            modifier = Modifier.size(60.dp),
            icon = { Icon(Icons.Default.Refresh, contentDescription = "Rotating Icon") },
            color = Color.Blue
        )

        AppLoadingAnimation()
    }
}


@Composable
fun CircularProgressExample(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        ScatteredArcsProgress(
            modifier = Modifier.size(100.dp),
            backgroundColor = Color.Gray.copy(alpha = 0.2f),
            activeColor = Color(0xFF0097ff)
        )

        ProgressTitle(title = "ScatteredArcsProgress")
        Spacer(modifier = Modifier.height(32.dp))

        DroppingDotsProgress(
            modifier = Modifier.size(100.dp),
            backgroundColor = Color.Gray.copy(alpha = 0.2f),
            activeColor = Color(0xFF0097ff)
        )

        ProgressTitle(title = "DroppingDotsProgress")
        Spacer(modifier = Modifier.height(32.dp))

        AnimatingArcsProgress(
            modifier = Modifier.size(100.dp),
            activeColor = Color(0xFF0097ff)
        )

        ProgressTitle(title = "AnimatingArcsProgress")
        Spacer(modifier = Modifier.height(32.dp))

        AnimatingCircleWithArcsProgress(
            modifier = Modifier.size(100.dp),
            activeColor = Color(0xFF0097ff)
        )
        ProgressTitle(title = "AnimatingCircleWithArcsProgress.kt")
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleMainActivityPreview() {
    ExampleMainActivityContent()
}