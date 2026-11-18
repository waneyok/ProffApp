package com.example.proffapp.domain.usecase

/**
 * Назначение: Сценарий проверки email
 * Дата: 18-11-26
 * Автор: Романов Иван
 */

class ValidateEmailUseCase {
    private val emailRegex = "^[a-z0-9]+@[a-z0-9]+\\.ru$".toRegex()

    fun isValid(email: String): Boolean {
        return email.isNotBlank() && emailRegex.matches(email)
    }
}