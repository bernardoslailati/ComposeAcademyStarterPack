package com.dev.slailati.compose_academy_starter_pack.ui.components.flip_credit_card

sealed class CardFace(val angle: Float) {
    object Front : CardFace(angle = 0f)
    object Back : CardFace(angle = 180f)

    fun flip(): CardFace {
        return when (this) {
            is Back -> Front
            is Front -> Back
        }
    }
}
