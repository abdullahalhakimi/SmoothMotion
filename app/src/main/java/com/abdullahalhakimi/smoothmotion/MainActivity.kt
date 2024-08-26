package com.abdullahalhakimi.smoothmotion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
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
import com.abdullahalhakimi.smoothmotion.animations.ExpandingCard
import com.abdullahalhakimi.smoothmotion.animations.PulsatingLoadingIndicator
import com.abdullahalhakimi.smoothmotion.animations.RotatingIcon
import com.abdullahalhakimi.smoothmotion.animations.SlideTransition

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
        // AnimatedButton Example
        AnimatedButton(
            onClick = { /* Do something */ },
            modifier = Modifier.fillMaxWidth()
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
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleMainActivityPreview() {
    ExampleMainActivityContent()
}