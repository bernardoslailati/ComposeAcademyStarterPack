package com.dev.slailati.compose_academy_starter_pack.ui.components.flip_credit_card

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import com.dev.slailati.compose_academy_starter_pack.ui.components.flip_credit_card.CardFace
import com.dev.slailati.compose_academy_starter_pack.ui.components.flip_credit_card.MasterCardBlack
import com.dev.slailati.compose_academy_starter_pack.ui.theme.ComposeAcademyStarterPackTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlipCardItem(
    modifier: Modifier = Modifier,
    cardFace: CardFace,
    onClick: (currentCardFace: CardFace) -> Unit,
    front: @Composable () -> Unit = {},
    back: @Composable () -> Unit = {},
) {
    val animateRotation = animateFloatAsState(
        targetValue = cardFace.angle,
        animationSpec = tween(durationMillis = 800),
        label = "Card Rotation"
    )

    Card(
        onClick = { onClick(cardFace) },
        modifier = modifier
            .graphicsLayer {
                rotationY = animateRotation.value
                cameraDistance = 12f * density
            },
    ) {
        if (animateRotation.value <= 90f) {
            Box {
                front()
            }
        } else {
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        rotationY = 180f
                    },
            ) {
                back()
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewMasterCardBlackFlipping() {
    ComposeAcademyStarterPackTheme {
        Column {
            MasterCardBlack()
        }
    }
}
