package com.abdullahalhakimi.smoothmotion.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@Composable
fun Title(modifier: Modifier = Modifier, title: String) {
    Text(
        modifier = modifier.padding(top = 15.dp),
        text = title,
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = TextUnit(14f, TextUnitType.Sp)
    )
}