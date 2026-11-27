package com.example.uikit.storybook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.components.PrimaryButton
import com.example.uikit.components.ProfCheckbox
import com.example.uikit.components.ProfPagination
import com.example.uikit.components.ProfTextField
import com.example.uikit.components.ProfTimer

/**
 * Назначение: Экран Витрина UIKIT
 * Дата создания: 26-11-2026
 * Автор: Романов Иван
 */

@Composable
fun StoryBookScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "UIKit StoryBook",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(text = "1. Кнопки (PrimaryButton)", fontWeight = FontWeight.Medium)

        PrimaryButton(text = "Primary кнопка(активна)", onClick = {}, enabled = true)
        PrimaryButton(text = "Primary кнопка(не активна)", onClick = {}, enabled = false)

        Text(text = "2. Поле ввода (ProfTextField)", fontWeight = FontWeight.Medium)

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        ProfTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email"
        )

        ProfTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            isPassword = true
        )

        ProfTextField(
            value = "wrong-email",
            onValueChange = {},
            placeholder = "Email",
            errorMessage = "Некорректный формат email"
        )

        ProfTextField(
            value = "Неактивное поле",
            onValueChange = {},
            placeholder = "Full Name",
            enabled = false
        )
        Text(text = "3. Точки", fontWeight = FontWeight.Medium)

        ProfPagination(
            totalDots = 3,
            selectedIndex = 0
        )
        ProfPagination(
            totalDots = 3,
            selectedIndex = 1
        )
        ProfPagination(
            totalDots = 3,
            selectedIndex = 2
        )
        Text(text = "4. Чекбокс", fontWeight = FontWeight.Medium)

        Row() {
            ProfCheckbox(
                checked = true,
                onCheckedChange = {}
            )
            Spacer(modifier = modifier.width(10.dp))
            ProfCheckbox(
                checked = false,
                onCheckedChange = {}
            )
        }
        Text(text = "5. Таймер", fontWeight = FontWeight.Medium)

        ProfTimer(
            time = "00:00"
        )
    }
}