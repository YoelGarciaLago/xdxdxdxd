package com.dam.mvvm_basic

import androidx.compose.ui.graphics.Color

/**
 * Clase para almacenar los datos del juego
 */
object Datos {
    var numero = 0
}

/**
 * Colores utilizados
 */

enum class Colores(val color: Color, val txt: String) {
    ROJO(color = Color.Red, txt = "roxo"),
    VERDE(color = Color.Green, txt = "verde"),
    AZUL(color = Color.Blue, txt = "azul"),
    AMARILLO(color = Color.Yellow, txt = "melo")
}

//data class juego()