package com.robertgama.miniapp1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://www.programiz.com/kotlin-programming/extension-functions
        fun EditText.checkForChange() {
            this.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }
                override fun afterTextChanged(s: Editable?) {
                    try {
                        if (s != null && s.isNotEmpty()) {
                            transferTime.text = calcTime()
                        }
                    } catch (e: Exception) {

                    }
                }
            })
        }
            fileInput.checkForChange()
            networkInput.checkForChange()
    }

    private fun calcTime(): String {

        val conversionNum = 8.389
        val fileInputS = fileInput.text.toString()
        val networkInputS = networkInput.text.toString()

        //calculates transfer time
        val total = fileInputS.toDouble() * (conversionNum / networkInputS.toDouble())

        return String.format("%.1f", total)
    }
}