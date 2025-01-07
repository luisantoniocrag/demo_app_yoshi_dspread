package com.example.dspread_yoshi_basic_use_case

import android.bluetooth.BluetoothDevice
import android.util.Log
import com.dspread.xpos.CQPOSService
import com.dspread.xpos.QPOSService
import java.util.ArrayList
import java.util.HashMap
import java.util.Hashtable
import java.util.LinkedHashMap

class MyQPOSClass : CQPOSService() {

    companion object {
        private var mifareCardOperationCallback: MifareCardOperationCallback? = null

        fun setMifareCardOperationCallback(callback: MifareCardOperationCallback) {
            mifareCardOperationCallback = callback
        }
    }

    override fun onGetDeviceTestResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onQposRequestPinResult(p0: MutableList<String>?, p1: Int) {
        Log.d(this::class.java.name, "onQposRequestPinResult() p0=$p0, p1=$p1")
        mifareCardOperationCallback?.onQposRequestPinResult(p0, p1)
    }

    override fun onReturnD20SleepTimeResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onQposRequestPinStartResult(p0: MutableList<String>?) {
        Log.d(this::class.java.name, "onQposRequestPinStartResult() p0=$p0")

    }

    override fun onQposPinMapSyncResult(p0: Boolean, p1: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onRequestWaitingUser() {
        Log.d(this::class.java.name, "onRequestWaitingUser()")
        mifareCardOperationCallback?.onRequestWaitingUser()
    }


    override fun onReturnSpLogResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnRsaResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposInitModeResult(p0: Boolean) {
        Log.d(this::class.java.name, "onQposInitModeResult() = $p0")
    }

    override fun onD20StatusResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposTestSelfCommandResult(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposTestCommandResult(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposGetRealTimeSelfDestructStatus(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturPosSelfDestructRecords(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposIdResult(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onQposKsnResult(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onQposIsCardExist(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onRequestDeviceScanFinished() {
        TODO("Not yet implemented")
    }

    override fun onQposInfoResult(p0: Hashtable<String, String>?) {
        Log.d(this::class.java.name, "onQposInfoResult() = $p0")

    }

    override fun onQposGetDeviceECCPublicKeyResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposUpdateServerECCPublicKeyResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onQposTestResult(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onQposCertificateInfoResult(p0: MutableList<String>?) {
        TODO("Not yet implemented")
    }

    override fun onQposGenerateSessionKeysResult(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onQposDoSetRsaPublicKey(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onSearchMifareCardResult(p0: Hashtable<String, String>?) {
        Log.d(this::class.java.name, "onSearchMifareCardResult() = $p0")
        mifareCardOperationCallback?.onSearchMifareCardResult(p0)
    }

    override fun onBatchReadMifareCardResult(
        p0: String?,
        p1: Hashtable<String, MutableList<String>>?
    ) {
        TODO("Not yet implemented")
    }

    override fun onBatchWriteMifareCardResult(
        p0: String?,
        p1: Hashtable<String, MutableList<String>>?
    ) {
        TODO("Not yet implemented")
    }

    override fun onDoTradeResult(p0: QPOSService.DoTradeResult?, p1: Hashtable<String, String>?) {
        Log.d(this::class.java.name, "onDoTradeResult() p0= $p0, p1=$p1")
        mifareCardOperationCallback?.onDoTradeResult(p0, p1)
    }

    override fun onFinishMifareCardResult(p0: Boolean) {
        Log.d(this::class.java.name, "onFinishMifareCardResult() = $p0")
        mifareCardOperationCallback?.onFinishMifareCardResult(p0)
    }

    override fun onVerifyMifareCardResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReadMifareCardResult(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onWriteMifareCardResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onOperateMifareCardResult(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun getMifareCardVersion(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun getMifareReadData(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun getMifareFastReadData(p0: Hashtable<String, String>?) {
        Log.d(this::class.java.name, "getMifareFastReadData() = $p0")
        mifareCardOperationCallback?.getMifareFastReadData(p0)
    }

    override fun writeMifareULData(p0: String?) {
        Log.d(this::class.java.name, "writeMifareULData() = $p0")
        mifareCardOperationCallback?.writeMifareULData(p0)
    }

    override fun verifyMifareULData(p0: Hashtable<String, String>?) {
        Log.d(this::class.java.name, "verifyMifareULData() = $p0")
        mifareCardOperationCallback?.verifyMifareULData(p0)
    }

    override fun transferMifareData(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestSetAmount() {
        Log.d(this::class.java.name, "onRequestSetAmount()")
        mifareCardOperationCallback?.onRequestSetAmount()
    }

    override fun onRequestSelectEmvApp(p0: ArrayList<String>?) {
        TODO("Not yet implemented")
    }

    override fun onRequestIsServerConnected() {
        TODO("Not yet implemented")
    }

    override fun onRequestFinalConfirm() {
        TODO("Not yet implemented")
    }

    override fun onRequestOnlineProcess(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestTime() {
        Log.d(this::class.java.name, "onRequestTime()")
        mifareCardOperationCallback?.onRequestTime()
    }

    override fun onRequestTransactionResult(p0: QPOSService.TransactionResult?) {
        Log.d(this::class.java.name, "onRequestTransactionResult() p0=$p0")
    }

    override fun onRequestTransactionLog(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestBatchData(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestQposConnected() {
        Log.d(this::class.java.name, "onRequestQposConnected()")
        mifareCardOperationCallback?.onRequestQposConnected()
    }

    override fun onRequestQposDisconnected() {
        Log.d(this::class.java.name, "onRequestQposDisconnected()")
    }


    override fun onRequestNoQposDetected() {
        Log.d(this::class.java.name, "onRequestNoQposDetected()")
    }

    override fun onRequestNoQposDetectedUnbond() {
        Log.d(this::class.java.name, "onRequestNoQposDetectedUnbond()")
    }

    override fun onError(p0: QPOSService.Error?) {
        Log.e(this::class.java.name, "onError() = $p0")
        mifareCardOperationCallback?.onError(p0)
    }

    override fun onRequestDisplay(p0: QPOSService.Display?) {
        Log.d(this::class.java.name, "onRequestDisplay() p0=$p0")
    }

    override fun onReturnReversalData(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnGetPinInputResult(p0: Int) {
        Log.d(this::class.java.name, "onReturnGetPinInputResult() p0=$p0")
    }

    override fun onReturnGetKeyBoardInputResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnGetPinResult(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnPowerOnIccResult(p0: Boolean, p1: String?, p2: String?, p3: Int) {
        TODO("Not yet implemented")
    }

    override fun onReturnPowerOffIccResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnApduResult(p0: Boolean, p1: String?, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun onReturnSetSleepTimeResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onGetCardNoResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestSignatureResult(p0: ByteArray?) {
        TODO("Not yet implemented")
    }

    override fun onRequestCalculateMac(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestUpdateWorkKeyResult(p0: QPOSService.UpdateInformationResult?) {
        TODO("Not yet implemented")
    }

    override fun onRequestSendTR31KeyResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnCustomConfigResult(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnDoInputCustomStr(p0: Boolean, p1: String?, p2: String?) {
        TODO("Not yet implemented")
    }

    override fun onRetuenGetTR31Token(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestSetPin() {
        Log.d(this::class.java.name, "onRequestSetPin()")
        mifareCardOperationCallback?.onRequestSetPin()
    }


    override fun onRequestUpdateKey(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnUpdateIPEKResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnRSAResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnUpdateEMVResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnGetQuickEmvResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnGetEMVListResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnGetCustomEMVListResult(p0: MutableMap<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnUpdateEMVRIDResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onDeviceFound(p0: BluetoothDevice?) {
        TODO("Not yet implemented")
    }

    override fun onReturnBatchSendAPDUResult(p0: LinkedHashMap<Int, String>?) {
        TODO("Not yet implemented")
    }

    override fun onBluetoothBonding() {
        TODO("Not yet implemented")
    }

    override fun onBluetoothBonded() {
        TODO("Not yet implemented")
    }

    override fun onWaitingforData(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onBluetoothBondFailed() {
        TODO("Not yet implemented")
    }

    override fun onBluetoothBondTimeout() {
        TODO("Not yet implemented")
    }

    override fun onReturniccCashBack(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onLcdShowCustomDisplay(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onSetCustomLogoDisplay(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onUpdatePosFirmwareResult(p0: QPOSService.UpdateInformationResult?) {
        TODO("Not yet implemented")
    }

    override fun onReturnPosFirmwareUpdateProgressResult(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun onBluetoothBoardStateResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnDownloadRsaPublicKey(p0: HashMap<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onGetPosComm(p0: Int, p1: String?, p2: String?) {
        TODO("Not yet implemented")
    }

    override fun onUpdateMasterKeyResult(p0: Boolean, p1: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onPinKey_TDES_Result(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onEmvICCExceptionData(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onSetParamsResult(p0: Boolean, p1: Hashtable<String, Any>?) {
        TODO("Not yet implemented")
    }

    override fun onSetVendorIDResult(p0: Boolean, p1: Hashtable<String, Any>?) {
        TODO("Not yet implemented")
    }

    override fun onGetInputAmountResult(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnNFCApduResult(p0: Boolean, p1: String?, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun onReturnMPUCardInfo(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnPowerOnNFCResult(
        p0: Boolean,
        cardType: QPOSService.CardsType?,
        p1: String?,
        p3: Int
    ) {
        Log.d(this::class.java.name, "p0=$p0, cardType=$cardType, p1=$p1, p3=$p3")
    }

    override fun onReturnPowerOnCardResult(p0: Boolean, p1: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnPowerOffCardResult(p0: Boolean, p1: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnSearchCardResult(p0: Boolean, p1: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnReadCardResult(p0: Boolean, p1: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnCheckCardResult(p0: Boolean, p1: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnPowerOffNFCResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onCbcMacResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReadBusinessCardResult(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReadGasCardResult(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onWriteBusinessCardResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onWriteGasCardResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onConfirmAmountResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onSetManagementKey(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onSetSleepModeTime(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onGetSleepModeTime(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onGetShutDownTime(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onEncryptData(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onAddKey(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onSetBuzzerResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onSetBuzzerTimeResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onSetBuzzerStatusResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onGetBuzzerStatusResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnPlayBuzzerByTypeResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnOperateLEDByTypeResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onQposDoTradeLog(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onQposDoGetTradeLogNum(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposDoGetTradeLog(p0: String?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestDevice() {
        TODO("Not yet implemented")
    }

    override fun onGetKeyCheckValue(p0: Hashtable<String, String>?) {
        TODO("Not yet implemented")
    }

    override fun onSetPosBluConfig(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onTradeCancelled() {
        Log.d(this::class.java.name, "onTradeCancelled()")
    }

    override fun onReturnSetAESResult(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnAESTransmissonKeyResult(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnSignature(p0: Boolean, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnConverEncryptedBlockFormat(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposIsCardExistInOnlineProcess(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnSetConnectedShutDownTimeResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnGetConnectedShutDownTimeResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onRequestNFCBatchData(p0: QPOSService.TransactionResult?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnUpdateKeyByTR_31Result(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onRequestGenerateTransportKey(p0: Hashtable<*, *>?) {
        TODO("Not yet implemented")
    }

    override fun onReturnAnalyseDigEnvelop(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnDisplayQRCodeResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnDeviceCSRResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnStoreCertificatesResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onReturnSignatureAndCertificatesResult(p0: String?, p1: String?, p2: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnDeviceSigningCertResult(p0: String?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnServerCertResult(p0: String?, p1: String?) {
        TODO("Not yet implemented")
    }

    override fun onQposSetLEDColorResult(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onQposGetLEDColorResult(p0: String?) {
        TODO("Not yet implemented")
    }

    override fun onReturnDeviceCertAndSignatureResult(p0: String?, p1: String?) {
        TODO("Not yet implemented")
    }

}