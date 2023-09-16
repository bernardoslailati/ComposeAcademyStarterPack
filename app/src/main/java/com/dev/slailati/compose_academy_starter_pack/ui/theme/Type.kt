package com.dev.slailati.compose_academy_starter_pack.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.dev.slailati.compose_academy_starter_pack.R

val outfitFontFamily = FontFamily(
    androidx.compose.ui.text.font.Font(resId = R.font.outfit_regular),
    androidx.compose.ui.text.font.Font(resId = R.font.outfit_black, weight = FontWeight.Black),
    androidx.compose.ui.text.font.Font(resId = R.font.outfit_medium, weight = FontWeight.Medium),
    androidx.compose.ui.text.font.Font(resId = R.font.outfit_thin, weight = FontWeight.Thin),
    androidx.compose.ui.text.font.Font(resId = R.font.outfit_extra_bold, weight = FontWeight.ExtraBold),
    androidx.compose.ui.text.font.Font(resId = R.font.outfit_extra_light, weight = FontWeight.ExtraLight),
    androidx.compose.ui.text.font.Font(resId = R.font.outfit_semi_bold, weight = FontWeight.SemiBold),
    androidx.compose.ui.text.font.Font(resId = R.font.outfit_light, weight = FontWeight.Light)
)

val Typography = Typography().copy(
    displayLarge = Typography().displayLarge.copy(fontFamily = outfitFontFamily),
    displayMedium = Typography().displayMedium.copy(fontFamily = outfitFontFamily),
    displaySmall = Typography().displaySmall.copy(fontFamily = outfitFontFamily),
    headlineLarge = Typography().headlineLarge.copy(fontFamily = outfitFontFamily),
    headlineMedium = Typography().headlineMedium.copy(fontFamily = outfitFontFamily),
    headlineSmall = Typography().headlineSmall.copy(fontFamily = outfitFontFamily),
    titleLarge = Typography().titleLarge.copy(fontFamily = outfitFontFamily),
    titleMedium = Typography().titleMedium.copy(fontFamily = outfitFontFamily),
    titleSmall = Typography().titleSmall.copy(fontFamily = outfitFontFamily),
    bodyLarge = Typography().bodyLarge.copy(fontFamily = outfitFontFamily),
    bodyMedium = Typography().bodyMedium.copy(fontFamily = outfitFontFamily),
    bodySmall = Typography().bodySmall.copy(fontFamily = outfitFontFamily),
    labelLarge = Typography().labelLarge.copy(fontFamily = outfitFontFamily),
    labelMedium = Typography().labelMedium.copy(fontFamily = outfitFontFamily),
    labelSmall = Typography().labelSmall.copy(fontFamily = outfitFontFamily),
)