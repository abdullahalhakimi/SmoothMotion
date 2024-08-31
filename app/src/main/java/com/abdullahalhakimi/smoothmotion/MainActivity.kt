package com.abdullahalhakimi.smoothmotion

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdullahalhakimi.smoothmotion.animations.CircledDotsProgress
import com.abdullahalhakimi.smoothmotion.animations.DropCircleProgress
import com.abdullahalhakimi.smoothmotion.animations.LoadingDotsAnimation
import com.abdullahalhakimi.smoothmotion.animations.OutlinedLoadingDotsAnimation
import com.abdullahalhakimi.smoothmotion.animations.RotatingCircleProgress
import com.abdullahalhakimi.smoothmotion.animations.RotatingFilledCircleProgress
import com.abdullahalhakimi.smoothmotion.utils.Title

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleMainActivityContent(modifier = Modifier)
        }
    }
}

@Composable
fun ExampleMainActivityContent(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            DropCircleProgress(
                modifier = Modifier.size(90.dp),
                backgroundColor = Color.Gray.copy(alpha = 0.2f),
                color = MaterialTheme.colorScheme.primary
            )
            CircledDotsProgress(
                modifier = Modifier.size(90.dp),
                backgroundColor = Color.Gray.copy(alpha = 0.2f),
                color = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Title(title = "Drop Circle Progress")
            Title(title = "Circled Dots Progress")
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            RotatingCircleProgress(
                modifier = Modifier.size(90.dp),
                color = MaterialTheme.colorScheme.primary
            )
            RotatingFilledCircleProgress(
                modifier = Modifier.size(90.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Title(title = "Rotating Circle Progress")
            Title(title = "Rotating Filled Circle Progress")
        }
        Spacer(modifier = Modifier.height(100.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            LoadingDotsAnimation(
                circleSize = 20.dp,
                spaceBetween = 10.dp,
                travelDistance = 15.dp,
                circleColor = MaterialTheme.colorScheme.primary
            )
            OutlinedLoadingDotsAnimation(
                circleSize = 20.dp,
                spaceBetween = 10.dp,
                travelDistance = 15.dp,
                circleColor = MaterialTheme.colorScheme.primary
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Title(title = "Loading Dots Animation")
            Title(title = "Outlined Loading Dots Animation")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ExampleMainActivityPreview() {
    ExampleMainActivityContent()
}