package com.example.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener { calculateTip() }
        binding.etCostOfService.doAfterTextChanged {
            binding.btnCalculate.isEnabled = it.isNullOrEmpty().not()
        }
    }

    private fun calculateTip() {
        val cost = binding.etCostOfService.text?.trim().toString().toDouble()
        val percentage = when (binding.rgState.checkedRadioButtonId) {
            R.id.rbAmazing -> 0.20
            R.id.rbGood -> 0.18
            else -> 0.15
        }
        var tip = cost * percentage
        // check if round up tip or not
        if (binding.swRoundTip.isChecked)
            tip = ceil(tip)

        // format the tip
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tvTipAmount.text = getString(R.string.tip_amount, formattedTip)
    }
}