package com.example.dspread_yoshi_basic_use_case

import android.app.Application
import android.content.Context
import android.util.Log
import com.dspread.xpos.QPOSService

class DSpreadYoshiApplication  : Application() {

    companion object {
        var getApplicationInstance: Context? = null
    }

    private var pos: QPOSService? = null

    override fun onCreate() {
        super.onCreate()

        getApplicationInstance = this
    }

    fun getPOS() = pos

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

        pos?.let { pos ->
            Log.d(DSpreadYoshiApplication::class.java.name, "Pos is NOT NULL")

            pos.setContext(this)
            pos.setConext(this) // maybe typo?

            pos.initListener(listener)
        }

        onLoaded()
    }
}