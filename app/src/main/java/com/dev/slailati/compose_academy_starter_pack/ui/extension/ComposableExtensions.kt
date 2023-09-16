package com.dev.slailati.compose_academy_starter_pack.ui.extension

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize

fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier =
    composed(
        factory = {
            this.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onClick() }
            )
        }
    )

fun Modifier.shimmer(): Modifier =
    composed {
        var size by remember { mutableStateOf(IntSize.Zero) }
        val transition = rememberInfiniteTransition(label = "Shimmer - Transition")
        val startOffsetX by transition.animateFloat(
            initialValue = -1.5f * size.width.toFloat(),
            targetValue = 1.5f * size.width.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000)
            ), label = "Shimmer - Start Offset X"
        )

        background(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xCC3D3D3D),
                    Color(0xCC535353),
                    Color(0xCC9C9C9C),
                    Color(0xCCC0C0C0),
                ),
                start = Offset(startOffsetX, 0f),
                end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat()),
            )
        )
            .onGloballyPositioned {
                size = it.size
            }
    }