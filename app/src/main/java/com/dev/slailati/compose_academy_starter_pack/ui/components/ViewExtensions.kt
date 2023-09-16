package com.slailati.feature.search_vehicle.presentation.experimental

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.material3.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


// #001
fun Context.showToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

// #002
fun View.showSnackbar(
    message: String,
    length: Int = Snackbar.LENGTH_SHORT,
    actionText: String = "Fechar",
    onActionClick: () -> Unit = {}
) {
    val snackbar = Snackbar.make(this, message, length)
    snackbar.setAction(actionText) {
        onActionClick()
        snackbar.dismiss()
    }
    snackbar.show()
}

// #003
fun Context.showAlert(
    title: String,
    message: String,
    @DrawableRes icon: Int? = null,
    positiveButtonText: String,
    isCancelable: Boolean = false,
    onPrimaryButtonClick: () -> Unit,
    negativeButtonText: String? = null,
    onNegativeButtonClick: () -> Unit = {},
) {
    val alert = AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(isCancelable)
        .setPositiveButton(
            positiveButtonText
        ) { _, _ -> onPrimaryButtonClick() }

    icon?.let { alert.setIcon(icon) }

    if (!negativeButtonText.isNullOrEmpty())
        alert.setNegativeButton(
            negativeButtonText
        ) { _, _ -> onNegativeButtonClick() }

    alert.create().show()
}

// #004
fun View.visible() {
    if (!this.isVisible) this.visibility = View.VISIBLE
}

// #005
fun View.gone() {
    if (this.visibility != View.GONE) this.visibility = View.GONE
}

// #006
fun View.invisible() {
    if (this.visibility != View.INVISIBLE) this.visibility = View.INVISIBLE
}

// #007
fun View.toggleVisibility() {
    if (this.visibility == View.VISIBLE)
        gone()
    else
        visible()
}

// #008
fun View.enable() {
    if (!this.isEnabled) this.isEnabled = true
}

// #009
fun View.disable() {
    if (this.isEnabled) this.isEnabled = false
}

// #010
fun View.clickable() {
    if (!this.isClickable) this.isClickable = true
}

// #011
fun View.notClickable() {
    if (this.isClickable) this.isClickable = false
}

// #012
fun Any?.isNull() = this == null

// #012
fun Any?.isNotNull() = this != null

// #013
fun <T> T?.orDefault(default: T): T = this ?: default

// #014
fun String?.orEmpty(): String = this ?: ""

// #015
fun Int?.orZero(): Int = this ?: 0
// #016
fun Long?.orZero(): Long = this ?: 0L
// #017
fun Float?.orZero(): Float = this ?: 0f
// #018
fun Double?.orZero(): Double = this ?: 0.0

// #019
//fun ImageView.loadImage(url: String, @DrawableRes placeholder: Int = R.drawable.placeholder){
//    Glide.with(this)
//        .load(url)
//        .placeholder(placholder)
//        .into(this)
//}

// #020
fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

// #021
fun View.onDebounceClick(
    debounceTimeInMillis: Long = 500L,
    disableDuringDebounce: Boolean = false,
    onClick: () -> Unit
) {
    this.setOnClickListener {
        onClick()

        if (disableDuringDebounce)
            disable()
        else
            isClickable = false

        postDelayed({
            if (disableDuringDebounce)
                enable()
            else
                isClickable = true
        }, debounceTimeInMillis)
    }
}