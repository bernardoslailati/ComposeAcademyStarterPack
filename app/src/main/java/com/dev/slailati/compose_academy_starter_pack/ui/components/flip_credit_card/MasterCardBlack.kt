package com.dev.slailati.compose_academy_starter_pack.ui.components.flip_credit_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.slailati.compose_academy_starter_pack.R
import com.dev.slailati.compose_academy_starter_pack.ui.theme.ComposeAcademyStarterPackTheme

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
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "8050 5040 2030 3020",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 16.sp,
            letterSpacing = 6.sp
        )
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
                Spacer(modifier = Modifier.height(4.dp))
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
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "8050 5040 2030 3020",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 16.sp,
            letterSpacing = 6.sp
        )
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
                Spacer(modifier = Modifier.height(4.dp))
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
                Spacer(modifier = Modifier.height(4.dp))
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

@Composable
fun MasterCardBlack(initialCardFace: CardFace = CardFace.Front) {
    var state: CardFace by remember {
        mutableStateOf(initialCardFace)
    }

    FlipCardItem(
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
fun PreviewFlipCreditCardFront() {
    ComposeAcademyStarterPackTheme {
        MasterCardBlack()
    }
}

@Preview
@Composable
fun PreviewFlipCreditCardBack() {
    ComposeAcademyStarterPackTheme {
        MasterCardBlack(initialCardFace = CardFace.Back)
    }
}