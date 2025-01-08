package com.example.dspread_yoshi_basic_use_case.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

open class Formatters {

    companion object {
        fun convertUnixToString(unixTimestamp: Long): String {
            val date = Date(unixTimestamp * 1000)

            val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
            val formattedDate = dateFormat.format(date)

            return "D60_Boleto_release_$formattedDate"
        }
    }
}