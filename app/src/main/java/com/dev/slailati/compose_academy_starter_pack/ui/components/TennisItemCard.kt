package com.dev.slailati.compose_academy_starter_pack.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.slailati.compose_academy_starter_pack.R
import com.dev.slailati.compose_academy_starter_pack.ui.extension.clickableWithoutRipple
import com.dev.slailati.compose_academy_starter_pack.ui.extension.shimmer
import kotlinx.coroutines.delay

@Composable
fun TennisItemCard(isLoading: Boolean) {
    var isFavorite by remember { mutableStateOf(false) }
    val linearGradientCardBackground = Brush.linearGradient(
        colors = listOf(
            Color(0xFF0457AF),
            Color(0xFF477AB5),
            Color(0xFFD2ECFC),
            Color(0xFFD2ECFC),
            Color(0xFFCC2222),
            Color(0xFFC40409),
        ),
    )

    val context = LocalContext.current

    if (isLoading)
        Column(modifier = Modifier.height(400.dp).width(300.dp).clip(shape = RoundedCornerShape(8.dp)).shimmer()) {}
    else
        Card {
            Column(
                modifier = Modifier
                    .background(linearGradientCardBackground)
                    .padding(16.dp)
                    .clickableWithoutRipple {
                        Toast
                            .makeText(
                                context,
                                "Clicado!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .size(48.dp)
                        .clickableWithoutRipple {        // instead of 'clickable.{ ... }'
                            isFavorite = !isFavorite
                        },
                    imageVector =
                    if (isFavorite)
                        Icons.Outlined.Favorite
                    else
                        Icons.Outlined.FavoriteBorder,
                    tint = Color.White,
                    contentDescription = "Favorite Icon"
                )
                Image(
                    modifier = Modifier
                        .height(400.dp)
                        .width(300.dp)
                        .padding(vertical = 24.dp),
                    painter = painterResource(id = R.drawable.nike_tennis),
                    contentDescription = "Nike Tennis Image"
                )
            }
        }
}

@Preview
@Composable
fun PreviewTennisItemCard() {
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = true) {
        delay(10_000)
        isLoading = false
    }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) {
            TennisItemCard(isLoading)
        }
    }
}