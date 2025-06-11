package br.com.nsbarros.android.compose.lojateniscompose.extensions

import java.text.NumberFormat
import java.util.Locale

fun Double.toBrazilianCurrency(): String {
    return NumberFormat.getCurrencyInstance(Locale("pt", "br")).format(this)
}