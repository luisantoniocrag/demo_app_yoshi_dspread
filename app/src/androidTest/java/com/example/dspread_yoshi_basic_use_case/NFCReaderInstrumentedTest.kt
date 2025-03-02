package com.example.dspread_yoshi_basic_use_case

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiScrollable
import androidx.test.uiautomator.UiSelector
import org.junit.Test

class NFCReaderInstrumentedTest {

    companion object {
        const val TIMES = 100
    }

    @Test
    fun nfcReader() {

        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        val posInitialized = device.findObject(UiSelector().text("POS Inicializado"))
        val btnStartNFCReader = device.findObject(UiSelector().text("DETECTAR NFC"))
        val totalOfTransactions = device.findObject(UiSelector().text("100"))

        var successOperations = 0

        device.executeShellCommand("am start -n com.example.dspread_yoshi_basic_use_case/com.example.dspread_yoshi_basic_use_case.MainActivity")


        posInitialized.waitForExists(1000)

        if (posInitialized.exists()) {
            while (!totalOfTransactions.exists()) {
                println("✅POS is initialized ✅")

                btnStartNFCReader.waitForExists(1000)

                if (btnStartNFCReader.exists()) {
                    btnStartNFCReader.click()
                    successOperations++
                }
                Log.w(this::class.java.name, "Success operations =  $successOperations")
            }

            Thread.sleep(100000)

        } else {
            Log.w(this::class.java.name, "❌POS is NOT initialized❌")
        }
    }
}