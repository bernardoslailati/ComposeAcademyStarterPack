package com.dev.slailati.compose_academy_starter_pack.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.slailati.compose_academy_starter_pack.R
import com.dev.slailati.compose_academy_starter_pack.ui.theme.ComposeAcademyStarterPackTheme
import com.dev.slailati.compose_academy_starter_pack.ui.theme.outfitFontFamily

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlipCreditCardItem(
    modifier: Modifier = Modifier,
    cardFace: CardFace,
    onClick: (currentCardFace: CardFace) -> Unit,
    front: @Composable () -> Unit = {},
    back: @Composable () -> Unit = {},
) {
    val rotation = animateFloatAsState(
        targetValue = cardFace.angle,
        animationSpec = tween(durationMillis = 800),
        label = "Card Rotation"
    )

    Card(
        onClick = { onClick(cardFace) },
        modifier = modifier
            .graphicsLayer {
                rotationY = rotation.value
                cameraDistance = 12f * density
            },
    ) {
        if (rotation.value <= 90f) {
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

@Composable
fun MasterCardBlackFront() {
    Column(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Black,
                        Color.DarkGray
                    )
                )
            )
            .drawBehind {
                drawCircle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.4f),
                            Color.Gray.copy(alpha = 0.2f)
                        )
                    ),
                    center = this.size.center * 2f,
                    radius = this.size.width / 2f
                )
                drawCircle(
                    brush = Brush.linearGradient(
                        tileMode = TileMode.Mirror,
                        colors = listOf(
                            Color.Black.copy(alpha = 0.4f),
                            Color.Gray.copy(alpha = 0.2f)
                        )
                    ),
                    center = this.size.center.copy(y = this.size.height * 1.4f),
                    radius = this.size.width / 2.5f
                )
            }
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier.size(36.dp),
                    painter = painterResource(R.drawable.ic_mastercard_logo),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Master Card", color = Color.White)
            }
            Image(
                modifier = Modifier.size(36.dp),
                painter = painterResource(R.drawable.ic_chip_credit_card),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Número do Cartão",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "8050 5040 2030 3020",
                color = Color.White,
                fontFamily = outfitFontFamily,
                fontSize = 18.sp,
                letterSpacing = 4.sp
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "BERNARDO M SLAILATI", color = Color.White)
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "Validade",
                    color = Color.White,
                    fontSize = 12.sp
                )
                Text(
                    text = "05/28",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun MasterCardBlackBack() {
    Column(
        modifier = Modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Black,
                        Color.DarkGray
                    ).asReversed()
                )
            )
            .drawBehind {
                drawCircle(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.4f),
                            Color.Gray.copy(alpha = 0.2f)
                        )
                    ),
                    center = Offset.Zero.copy(y = this.size.height),
                    radius = this.size.width / 2f
                )
                drawCircle(
                    brush = Brush.linearGradient(
                        tileMode = TileMode.Mirror,
                        colors = listOf(
                            Color.Black.copy(alpha = 0.4f),
                            Color.Gray.copy(alpha = 0.2f)
                        )
                    ),
                    center = this.size.center.copy(y = this.size.height * 1.5f),
                    radius = this.size.width / 2.5f
                )
            }
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(R.drawable.ic_chip_credit_card),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Número do Cartão",
                color = Color.White,
                fontSize = 14.sp
            )
            Text(
                text = "8050 5040 2030 3020",
                color = Color.White,
                fontSize = 16.sp,
                letterSpacing = 4.sp
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Validade",
                    color = Color.White,
                    fontSize = 12.sp
                )
                Text(
                    text = "05/28",
                    fontSize = 18.sp,
                    color = Color.White,
                )
            }
            Column {
                Text(
                    text = "CVV",
                    color = Color.White,
                    fontSize = 12.sp
                )
                Text(
                    text = "512",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 4.sp,
                    fontSize = 18.sp
                )
            }
            Image(
                modifier = Modifier.size(32.dp),
                painter = painterResource(R.drawable.ic_mastercard_logo),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun PreviewFlipCreditCardFront() {
    MaterialTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            var state: CardFace by remember { mutableStateOf(CardFace.Front) }

            FlipCreditCardItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 200.dp)
                    .padding(vertical = 36.dp, horizontal = 16.dp),
                cardFace = state,
                onClick = {
                    state = it.flip()
                },
                front = {
                    MasterCardBlackFront()
                },
                back = {
                    MasterCardBlackBack()
                }
            )
        }
    }
}

@Composable
fun MasterCardBlack() {
    var state: CardFace by remember {
        mutableStateOf(CardFace.Back)
    }

    FlipCreditCardItem(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .padding(vertical = 36.dp, horizontal = 16.dp),
        cardFace = state,
        onClick = {
            state = it.flip()
        },
        front = {
            MasterCardBlackFront()
        },
        back = {
            MasterCardBlackBack()
        }
    )
}

@Preview
@Composable
fun PreviewFlipCreditCardBack() {
    ComposeAcademyStarterPackTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            MasterCardBlack()
        }
    }
}