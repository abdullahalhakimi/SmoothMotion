package com.abdullahalhakimi.smoothmotion.animations

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExpandingCard(
    headerContent: @Composable () -> Unit,
    expandedContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    onClick: () -> Unit = {},
    animationDuration: Int = 300,
    cornerRadius: Int = 8,
    padding: Int = 16
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(padding.dp)
            .clickable { onClick() }
            .animateContentSize(tween(durationMillis = animationDuration)),
        shape = RoundedCornerShape(cornerRadius.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(padding.dp)) {
            headerContent()
            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                expandedContent()
            }
        }
    }
}



//@Composable
//fun ExpandingCard(
//    headerContent: @Composable () -> Unit,
//    expandedContent: @Composable () -> Unit,
//    modifier: Modifier = Modifier,
//    animationDuration: Int = 300,
//    cornerRadius: Int = 8,
//    padding: Int = 16
//) {
//    var expanded by remember { mutableStateOf(false) }
//
//    Surface(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(padding.dp)
//            .clickable { expanded = !expanded }
//            .animateContentSize(tween(durationMillis = animationDuration)),
//        shape = RoundedCornerShape(cornerRadius.dp),
//        color = MaterialTheme.colorScheme.surface,
//        tonalElevation = 4.dp
//    ) {
//        Column(modifier = Modifier.padding(padding.dp)) {
//            headerContent()
//            if (expanded) {
//                Spacer(modifier = Modifier.height(8.dp))
//                expandedContent()
//            }
//        }
//    }
//}