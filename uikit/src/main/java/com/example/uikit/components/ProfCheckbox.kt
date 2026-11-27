package com.example.uikit.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.theme.Primary

/**
 * Назначение: Чекбокс дизайн-системы UIKit (Single Responsibility: отрисовка состояния выбора).
 * Дата создания: 27-11-2026
 * Автор: Участник №11
 */
@Composable
fun ProfCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(14.dp)
            .border(width = 1.dp, color = Primary)
            .clickable { onCheckedChange(!checked) },
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = null,
                tint = Primary,
                modifier = Modifier.size(width = 7.dp, height = 5.dp)
            )
        }
    }
}