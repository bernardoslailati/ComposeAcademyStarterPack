package com.slailati.feature.search_vehicle.presentation.experimental

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slailati.core.ui.R
import com.slailati.ui.theme.typography.outfitFontFamily
import kotlin.math.absoluteValue

@Composable
fun BrazilianForm() {
    val cpf = remember { mutableStateOf("") }
    val cnpj = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        BrazilianTextField(textResult = cpf, BrazilianMask.CPF)
        Spacer(modifier = Modifier.height(16.dp))
        BrazilianTextField(textResult = cnpj, BrazilianMask.CNPJ)
        Spacer(modifier = Modifier.height(16.dp))
        BrazilianTextField(textResult = phone, BrazilianMask.PHONE_NUMBER)
    }
}

enum class BrazilianMask(
    val pattern: String,
    @DrawableRes val iconRes: Int? = null,
    @StringRes val placeholderRes: Int
) {

    CPF(
        pattern = "###.###.###-##",
        iconRes = R.drawable.ic_person,
        placeholderRes = R.string.cpf
    ),
    CNPJ(
        pattern = "##.###.###/0001-##",
        iconRes = R.drawable.ic_store,
        placeholderRes = R.string.cnpj
    ),
    PHONE_NUMBER(
        pattern = "\uD83C\uDDE7\uD83C\uDDF7 +55 (##) #####-####",
        iconRes = R.drawable.ic_phone,
        placeholderRes = R.string.phone_number
    );

    companion object {
        const val SYMBOL: Char = '#'
    }

}

@Composable
fun BrazilianTextField(textResult: MutableState<String>, brazilianMask: BrazilianMask) {
    val customTextFieldColors = TextFieldDefaults.colors(
        cursorColor = Color(0xFF002B41),
        unfocusedIndicatorColor = Color(0xFF002B41),
        focusedIndicatorColor = Color(0xFF002B41),
        focusedContainerColor = Color(0xFFFAFAFA),
        unfocusedContainerColor = Color(0xFFFAFAFA),
        disabledContainerColor = Color(0xFFFAFAFA),
    )

    val customTextFieldTextStyle = TextStyle.Default.copy(
        fontFamily = outfitFontFamily,
        fontSize = 16.sp,
        letterSpacing = 1.sp
    )

    TextField(
        modifier = Modifier.fillMaxWidth(),
        colors = customTextFieldColors,
        textStyle = customTextFieldTextStyle,
        value = textResult.value,
        leadingIcon = {
            brazilianMask.iconRes?.let {
                Icon(
                    modifier = Modifier.padding(8.dp),
                    painter = painterResource(it),
                    contentDescription = "${brazilianMask.name} Icon"
                )
            }
        },
        placeholder = {
            Text(
                text = stringResource(brazilianMask.placeholderRes),
                color = Color.DarkGray.copy(alpha = 0.8f),
                fontFamily = outfitFontFamily
            )
        },
        onValueChange = {
            val totalSymbols =
                brazilianMask.pattern.filter { char -> char == BrazilianMask.SYMBOL }.length
            if (it.length > totalSymbols) return@TextField

            textResult.value = it.filter { char -> char.isDigit() }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        visualTransformation = CustomMaskVisualTransformation(
            maskSymbol = BrazilianMask.SYMBOL,
            maskPattern = brazilianMask.pattern
        )
    )
}

class CustomMaskVisualTransformation(
    private val maskSymbol: Char,
    private val maskPattern: String
) : VisualTransformation {

    private val notMaskSymbolIndices = maskPattern.indices.filter { maskPattern[it] != maskSymbol }

    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""

        var maskIndex = 0
        text.forEach { char ->
            while (notMaskSymbolIndices.contains(maskIndex)) {
                out += maskPattern[maskIndex]
                maskIndex++
            }
            out += char
            maskIndex++
        }

        return TransformedText(AnnotatedString(out), offsetTranslator())
    }

    private fun offsetTranslator() = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            val offsetValue = offset.absoluteValue
            if (offsetValue == 0) return 0

            var numberOfSymbols = 0
            val masked = maskPattern.takeWhile {
                if (it == maskSymbol) numberOfSymbols++
                numberOfSymbols < offsetValue
            }

            return masked.length + 1
        }

        override fun transformedToOriginal(offset: Int): Int {
            return maskPattern.take(offset.absoluteValue).count { it == maskSymbol }
        }
    }

}

@Preview(backgroundColor = 0xFF1A1A1A)
@Composable
fun PreviewBrazilianForm() {
    BrazilianForm()
}