package com.example.dspread_yoshi_basic_use_case

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dspread.xpos.QPOSService
import com.example.dspread_yoshi_basic_use_case.adapters.MessageErrorsRecyclerView
import com.example.dspread_yoshi_basic_use_case.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Hashtable

class MainActivity : AppCompatActivity(), MifareCardOperationCallback {

    private lateinit var binding : ActivityMainBinding
    private lateinit var pos : QPOSService

    var posIsActive = false
    private lateinit var applicationClass : DSpreadYoshiApplication

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        applicationClass = (application as DSpreadYoshiApplication)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        CoroutineScope(Dispatchers.Default).launch {
            CoroutineScope(Dispatchers.Main).launch {
                binding.tvPOSStatus.text = "Iniciando POS..."
            }
            delay(1000)
            initalizePOS()
        }

        setUI()
    }

    private fun setUI() {
        binding.tvDeviceVersionInformation.text = applicationClass.getDeviceVersionInformation()
    }


    private suspend fun initalizePOS() {
        applicationClass.open(
            mode = QPOSService.CommunicationMode.UART, this
        ) {
            CoroutineScope(Dispatchers.Main).launch {
                binding.tvPOSStatus.text = "POS Inicializado"
                binding.actionBtn.isClickable = true
                binding.actionBtn.isFocusable = true
                setButtonStatus()
            }
        }

        delay(100)

        (application as DSpreadYoshiApplication).getPOS()?.let {
            pos = it
            posIsActive = pos.isQposPresent
        }

        MyQPOSClass.setMifareCardOperationCallback(this)
        delay(200)

        pos?.openUart()
    }

    private fun setButtonStatus() {
        binding.actionBtn.setOnClickListener {
            disableButton()
            binding.actionBtn.text = "Detectando NFC...".uppercase()
            binding.tvCardInfo.visibility = View.GONE
            pos?.pollOnMifareCard(10)
        }
    }

    private fun disableButton() {
        binding.actionBtn.setOnClickListener { }
    }

    @SuppressLint("SetTextI18n")
    override fun onSearchMifareCardResult(arg0: Hashtable<String, String>?) {
        CoroutineScope(Dispatchers.Default).launch {
            pos?.finishMifareCard(1)

            CoroutineScope(Dispatchers.Main).launch {
                binding.actionBtn.text = "Detectar NFC".uppercase()
                binding.tvCardInfo.visibility = View.VISIBLE

                val cardType = arg0?.get("cardType")
                val status = arg0?.get("status")
                val cardUidLen = arg0?.get("cardUidLen")
                val ATQA = arg0?.get("ATQA")
                val cardAts = arg0?.get("cardAts")
                val cardUid = arg0?.get("cardUid")
                val SAK = arg0?.get("SAK")
                val cardAtsLen = arg0?.get("cardAtsLen")

                binding.tvCardInfo.text = """
                    card type: $cardType
                    status: $status
                    cardUidLen: $cardUidLen
                    ATQA: $ATQA
                    cardAts: $cardAts
                    cardUid: $cardUid
                    SAK: $SAK
                    cardAtsLen: $cardAtsLen
                """.trimIndent()

                val nOfSuccess = (binding.tvSuccessTransactions.text).toString().toInt() ?: 0
                binding.tvSuccessTransactions.text = (nOfSuccess+1).toString()
                increaseTotalTransactions()

                setButtonStatus()
            }
        }
    }

    override fun getMifareFastReadData(p0: Hashtable<String, String>?) {
    }

    override fun writeMifareULData(p0: String?) {
    }

    override fun verifyMifareULData(p0: Hashtable<String, String>?) {
    }

    override fun onFinishMifareCardResult(p0: Boolean) {
    }

    override fun onRequestQposConnected() {
    }

    override fun onError(p0: QPOSService.Error?) {
        CoroutineScope(Dispatchers.Default).launch {
            pos?.finishMifareCard(1)
            CoroutineScope(Dispatchers.Main).launch {
                val nOfErrors = (binding.tvErrorTransactions.text).toString().toInt() ?: 0
                binding.tvErrorTransactions.text = (nOfErrors+1).toString()
                increaseTotalTransactions()

                val errorMsg = p0.toString()
                launchErrorModal(errorMsg)
            }
            delay(3000)

            pos?.pollOnMifareCard(10)
        }
    }

    private fun increaseTotalTransactions() {
        val nTotal = (binding.tvTotalTransactions.text).toString().toInt() ?: 0
        binding.tvTotalTransactions.text = (nTotal+1).toString()
    }

    private fun launchErrorModal(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("onError()")
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}