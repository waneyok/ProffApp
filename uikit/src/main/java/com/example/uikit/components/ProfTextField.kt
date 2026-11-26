package com.example.uikit.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.Accent
import com.example.uikit.theme.Black
import com.example.uikit.theme.Error
import com.example.uikit.theme.InputIcn
import com.example.uikit.theme.InputStr
import com.example.uikit.theme.Placeholder
import com.example.uikit.theme.gradient

/**
 * Назначение: Поле ввода дизайн-системы UIKit (Single Responsibility: отрисовка поля ввода и его состояний).
 * Дата создания: 26-11-2026
 * Автор: Участник №11
 */
@Composable
fun ProfTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    isPassword: Boolean = false,
    enabled: Boolean = true
) {
    // Следим, нажал ли пользователь на поле (стоит ли внутри курсор)
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    // Переключатель для пароля: false = точки, true = обычный текст
    var isPasswordVisible by remember { mutableStateOf(false) }

    // Выбираем заливку и толщину нижней линии под текущее состояние
    val lineHeight = if (isFocused) 2.dp else 1.dp
    val lineBackground = when {
        !enabled -> Modifier.background(InputStr.copy(alpha = 0.4f))
        errorMessage != null -> Modifier.background(Error)
        else -> Modifier.background(gradient)
    }

    Column(modifier = modifier.fillMaxWidth()) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true,
            interactionSource = interactionSource,
            cursorBrush = SolidColor(Accent),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = if (enabled) Black else Black.copy(alpha = 0.4f)
            ),
            visualTransformation = if (isPassword && !isPasswordVisible) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
            ),
            decorationBox = { innerTextField ->
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            if (value.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = if (enabled) Placeholder else Placeholder.copy(alpha = 0.4f)
                                )
                            }
                            innerTextField()
                        }

                        if (isPassword) {
                            EyeIcon(
                                isVisible = isPasswordVisible,
                                tint = if (enabled) InputIcn else InputIcn.copy(alpha = 0.4f),
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .size(22.dp)
                                    .clickable(enabled = enabled) {
                                        isPasswordVisible = !isPasswordVisible
                                    }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Нижняя линия с градиентом из темы
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(lineHeight)
                            .then(lineBackground)
                    )
                }
            }
        )

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodySmall,
                color = Error
            )
        }
    }
}

/**
 * Назначение: Иконка глаза для переключения видимости пароля (Single Responsibility: отрисовка иконки).
 * Дата создания: 26-11-2026
 * Автор: Участник №11
 */
@Composable
private fun EyeIcon(
    isVisible: Boolean,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height

        val eyePath = Path().apply {
            moveTo(w * 0.08f, h * 0.5f)
            quadraticBezierTo(w * 0.5f, h * 0.1f, w * 0.92f, h * 0.5f)
            quadraticBezierTo(w * 0.5f, h * 0.9f, w * 0.08f, h * 0.5f)
        }
        drawPath(path = eyePath, color = tint, style = Stroke(width = 1.6.dp.toPx()))
        drawCircle(color = tint, radius = h * 0.15f, center = Offset(w * 0.5f, h * 0.5f))
        if (!isVisible) {
            drawLine(
                color = tint,
                start = Offset(w * 0.18f, h * 0.82f),
                end = Offset(w * 0.82f, h * 0.18f),
                strokeWidth = 1.6.dp.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}