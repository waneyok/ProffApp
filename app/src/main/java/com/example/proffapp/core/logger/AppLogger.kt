package com.example.proffapp.core.logger

import android.util.Log

/**
 * Назначение: Класс для логирования
 * Дата: 18-11-2026
 * Автор: Романов Иван
 */
object AppLogger {
    fun i(tag: String, event: String, details: String){
        Log.i(tag, "[$tag]: $event -  $details")
    }
    fun d(tag: String, event: String, details: String){
        Log.d(tag, "[$tag]: $event -  $details")
    }
    fun e(tag: String, event: String, details: String){
        Log.e(tag, "[$tag]: $event -  $details")
    }
}