package com.example.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Назначение: Поинты для экранов
 * Дата создания: 27-11-26
 * Автор: Участник №11
 */


@Composable
fun ProfPagination(
    totalDots: Int,
    selectedIndex: Int,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for(i in 0 until totalDots){
            Box(
                modifier = modifier
                    .size(10.dp)
                    .clip(CircleShape)
                    .background(
                        if (i == selectedIndex) Color(0xFFFA5075) else Color(0xFFFA5075).copy(alpha = 0.35f)
                    )
            )
        }
    }
}