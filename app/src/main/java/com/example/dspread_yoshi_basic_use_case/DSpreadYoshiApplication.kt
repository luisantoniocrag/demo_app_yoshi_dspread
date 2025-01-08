package com.example.dspread_yoshi_basic_use_case

import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import com.dspread.xpos.QPOSService
import com.example.dspread_yoshi_basic_use_case.utils.Formatters

class DSpreadYoshiApplication  : Application() {

    companion object {
        var getApplicationInstance: Context? = null
        var deviceVersionInformation: String? = null
    }

    private var pos: QPOSService? = null

    override fun onCreate() {
        super.onCreate()

        getApplicationInstance = this
        deviceVersionInformation = Formatters.convertUnixToString(extractUnixTimestampFromFingerprint(Build.FINGERPRINT))
    }

    fun getPOS() = pos

    fun getDeviceVersionInformation() = deviceVersionInformation

    fun open(
        mode: QPOSService.CommunicationMode, context: Context?,
        onLoaded: () -> Unit
    ) {
        Log.d(DSpreadYoshiApplication::class.java.name, "open()")
        val listener = MyQPOSClass()

        pos = QPOSService.getInstance(context, mode)

        if (pos == null) {
            Log.d(DSpreadYoshiApplication::class.java.name, "Pos is NULL")
            return
        }

        Thread.sleep(1500)

        pos?.let { pos ->
            Log.d(DSpreadYoshiApplication::class.java.name, "Pos is NOT NULL")

            pos.setContext(this)
            pos.setConext(this) // maybe typo?

            pos.initListener(listener)
        }

        onLoaded()
    }

    private fun extractUnixTimestampFromFingerprint(input: String): Long {
        val regex = "\\b\\d{10}\\b".toRegex()

        val matchResult = regex.find(input)

        return (matchResult?.value)?.toLong() ?: 0L
    }
}