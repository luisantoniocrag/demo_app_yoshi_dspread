package com.example.dspread_yoshi_basic_use_case

import com.dspread.xpos.QPOSService
import java.util.Hashtable

interface MifareCardOperationCallback {
    fun onSearchMifareCardResult(arg0: Hashtable<String, String>?)
    fun getMifareFastReadData(p0: Hashtable<String, String>?)
    fun writeMifareULData(p0: String?)
    fun verifyMifareULData(p0: Hashtable<String, String>?)
    fun onFinishMifareCardResult(p0: Boolean)
    fun onRequestQposConnected()
    fun onError(p0: QPOSService.Error?)
    fun onRequestSetAmount()
    fun onRequestTime()
    fun onDoTradeResult(p0: QPOSService.DoTradeResult?, p1: Hashtable<String, String>?)
    fun onQposRequestPinResult(p0: MutableList<String>?, p1: Int)
    fun onRequestSetPin()
    fun onRequestWaitingUser()
}
