package com.example.uikit.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable



/**
 * Назначение:Тема приложения
 * Дата: 26-11-2026
 * Автор: Участник номер 11
 */
private val LightColorScheme = lightColorScheme(
    primary = Accent,                 // Главный акцент (кнопки, активные элементы)
    onPrimary = White,                // Текст и иконки поверх Accent
    background = White,               // Основной фон экранов
    onBackground = Black,             // Основной текст на фоне
    surface = White,                  // Фон карточек и поверхностей
    onSurface = Black,                // Текст на карточках
    surfaceVariant = InputBG,         // Фон полей ввода (если он отличается от белого)
    onSurfaceVariant = Description,   // Вторичный текст и описания
    outline = InputStr,               // Обводка / рамки полей ввода
    error = Error,                    // Цвет ошибок валидации
    onError = White                   // Текст поверх цвета ошибки
)

@Composable
fun ProffAppTheme(
    content: @Composable () -> Unit
) {


    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
