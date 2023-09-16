package com.dev.slailati.compose_academy_starter_pack.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.slailati.compose_academy_starter_pack.R
import com.dev.slailati.compose_academy_starter_pack.ui.theme.outfitFontFamily
import kotlinx.coroutines.delay

val catMarioAnimatedVisibilityConfigList = listOf(
    AnimatedVisibilityConfig(
        enterTransitionName = "fadeIn",
        enterTransition = fadeIn(),
        exitTransitionName = "fadeOut",
        exitTransition = fadeOut()
    ),
    AnimatedVisibilityConfig(
        enterTransitionName = "slideIn",
        enterTransition = slideIn { _ ->
            IntOffset(
                x = -80,
                y = -80
            )
        },
        exitTransitionName = "slideOut",
        exitTransition = slideOut { _ ->
            IntOffset(
                x = 80,
                y = -80
            )
        }
    ),
    AnimatedVisibilityConfig(
        enterTransitionName = "slideInHorizontally",
        enterTransition = slideInHorizontally(),
        exitTransitionName = "slideOutHorizontally",
        exitTransition = slideOutHorizontally()
    ),
    AnimatedVisibilityConfig(
        enterTransitionName = "slideInVertically",
        enterTransition = slideInVertically(),
        exitTransitionName = "slideOutVertically",
        exitTransition = slideOutVertically()
    ),
    AnimatedVisibilityConfig(
        enterTransitionName = "scaleIn",
        enterTransition = scaleIn(),
        exitTransitionName = "scaleOut",
        exitTransition = scaleOut()
    ),
    AnimatedVisibilityConfig(
        enterTransitionName = "expandIn",
        enterTransition = expandIn(),
        exitTransitionName = "shrinkOut",
        exitTransition = shrinkOut()
    ),
    AnimatedVisibilityConfig(
        enterTransitionName = "expandHorizontally",
        enterTransition = expandHorizontally(),
        exitTransitionName = "shrinkHorizontally",
        exitTransition = shrinkHorizontally()
    ),
    AnimatedVisibilityConfig(
        enterTransitionName = "expandVertically",
        enterTransition = expandVertically(),
        exitTransitionName = "shrinkVertically",
        exitTransition = shrinkVertically()
    )
)

@Composable
fun AnimatedVisibilityTypes(
    modifier: Modifier = Modifier,
    animatedVisibilityConfigList: List<AnimatedVisibilityConfig>
) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = null) {
        repeat(50) {
            delay(1_000)
            isVisible = !isVisible
        }
    }

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                fontFamily = outfitFontFamily,
                text = "EnterTransition",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
            Text(
                fontFamily = outfitFontFamily,
                text = "ExitTransition",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 4.dp)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color.Yellow,
                            Color(0xFFFFC107),
                            Color(0xFFFF9800),
                            Color(0xFFFF5722)
                        )
                    ),
                    shape = RoundedCornerShape(size = 0.dp)
                ),
        )
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 36.dp, vertical = 24.dp),
            columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(animatedVisibilityConfigList) { animatedVisibilityConfig ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = animatedVisibilityConfig.enterTransitionName,
                            fontFamily = outfitFontFamily,
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Card(
                            modifier = Modifier.size(80.dp),
                            elevation = CardDefaults.cardElevation(4.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(80.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                AnimatedVisibility(
                                    visible = isVisible,
                                    enter = animatedVisibilityConfig.enterTransition,
                                    exit = animatedVisibilityConfig.exitTransition
                                ) {
                                    Image(
                                        modifier = Modifier.size(64.dp),
                                        painter = painterResource(R.drawable.cat_mario),
                                        contentDescription = "Cat Mario Image"
                                    )
                                }
                            }
                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = animatedVisibilityConfig.exitTransitionName,
                            fontFamily = outfitFontFamily,
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Card(
                            modifier = Modifier.size(80.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(80.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                AnimatedVisibility(
                                    visible = !isVisible,
                                    enter = animatedVisibilityConfig.enterTransition,
                                    exit = animatedVisibilityConfig.exitTransition
                                ) {
                                    Image(
                                        modifier = Modifier.size(64.dp),
                                        painter = painterResource(R.drawable.cat_mario),
                                        contentDescription = "Cat Mario Image"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = false, showSystemUi = false)
@Composable
fun PreviewList() {
    AnimatedVisibilityTypes(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        animatedVisibilityConfigList = catMarioAnimatedVisibilityConfigList
    )
}

@Preview(widthDp = 1080, heightDp = 1080)
@Composable
fun PreviewItem() {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = null) {
        repeat(50) {
            delay(1_000)
            isVisible = !isVisible
        }
    }

    Box(modifier = Modifier.paint(painter = painterResource(R.drawable.bg_compose_post))) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    fontFamily = outfitFontFamily,
                    text = "EnterTransition",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    fontFamily = outfitFontFamily,
                    text = "ExitTransition",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Center
                )
            }
            LazyVerticalGrid(
                contentPadding = PaddingValues(horizontal = 48.dp, vertical = 16.dp),
                columns = GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(
                    catMarioAnimatedVisibilityConfigList.subList(
                        6,
                        8
                    )
                ) { animatedVisibilityConfig ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier.widthIn(min = 96.dp),
                                text = animatedVisibilityConfig.enterTransitionName,
                                fontFamily = outfitFontFamily,
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Card(
                                modifier = Modifier.size(64.dp),
                                elevation = CardDefaults.cardElevation(4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                shape = RoundedCornerShape(64.dp)
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    AnimatedVisibility(
                                        visible = isVisible,
                                        enter = animatedVisibilityConfig.enterTransition,
                                        exit = animatedVisibilityConfig.exitTransition
                                    ) {
                                        Image(
                                            modifier = Modifier.size(48.dp),
                                            painter = painterResource(R.drawable.cat_mario),
                                            contentDescription = "Cat Mario Image"
                                        )
                                    }
                                }
                            }
                        }

                        Column(
                            modifier = Modifier.fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier.widthIn(min = 96.dp),
                                text = animatedVisibilityConfig.exitTransitionName,
                                fontFamily = outfitFontFamily,
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Card(
                                modifier = Modifier.size(64.dp),
                                elevation = CardDefaults.cardElevation(8.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                shape = RoundedCornerShape(64.dp)
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    AnimatedVisibility(
                                        visible = !isVisible,
                                        enter = animatedVisibilityConfig.enterTransition,
                                        exit = animatedVisibilityConfig.exitTransition
                                    ) {
                                        Image(
                                            modifier = Modifier.size(48.dp),
                                            painter = painterResource(R.drawable.cat_mario),
                                            contentDescription = "Cat Mario Image"
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CatMarioImage(
    isVisible: Boolean,
    enterTransition: EnterTransition,
    exitTransition: ExitTransition
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = enterTransition,  // slideIn,
        exit = exitTransition,     // slideOut,
        content = {
            Image(
                painter = painterResource(R.drawable.cat_mario),
                contentDescription = "Cat Mario Image"
            )
        }
    )
}

const val REPEAT_ANIMATION_TIMES = 50
const val ANIMATION_INTERVAL = 1_000L

@Preview
@Composable
fun PreviewCatMarioImage() {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = null) {
        repeat(REPEAT_ANIMATION_TIMES) {
            delay(ANIMATION_INTERVAL)
            isVisible = !isVisible
        }
    }

    CatMarioImage(isVisible, slideInVertically { height -> height } + fadeIn(), slideOutVertically { height -> -height } + fadeOut())
}

data class AnimatedVisibilityConfig(
    val enterTransitionName: String,
    val enterTransition: EnterTransition,
    val exitTransitionName: String,
    val exitTransition: ExitTransition
)