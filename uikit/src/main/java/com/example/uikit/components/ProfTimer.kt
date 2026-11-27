package com.example.uikit.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.theme.ProfTextStyles
import com.example.uikit.theme.White
import com.example.uikit.theme.gradient

/**
 * Назначение: Таймер для игр
 * Дата создания: 27-11-26
 * Автор: Участник №11
 */


@Composable
fun ProfTimer(
    time: String,
    modifier: Modifier = Modifier,
    title: String = "Timer"
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .size(295.dp, 100.dp)
            .background(gradient),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = title,
                style = ProfTextStyles.caption2Regular,
                color = White,
                maxLines = 1

            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = time,
                style = ProfTextStyles.title1ExtraBold,
                fontSize = 30.sp,
                color = White,
                letterSpacing = 0.3f.sp,
                lineHeight = 45.sp,
                maxLines = 1

            )
        }
    }
}