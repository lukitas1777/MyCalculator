package com.furkan.mycalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var firstNumberEditText: EditText
    private lateinit var secondNumberEditText: EditText
    private lateinit var addButton: Button
    private lateinit var subtractButton: Button
    private lateinit var multiplyButton: Button
    private lateinit var divideButton: Button
    private lateinit var calculationResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberEditText = findViewById(R.id.firstNumber)
        secondNumberEditText = findViewById(R.id.secondNumber)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)
        calculationResult = findViewById(R.id.calculationResult)

        addButton.setOnClickListener { performOperation("+") }
        subtractButton.setOnClickListener { performOperation("-") }
        multiplyButton.setOnClickListener { performOperation("*") }
        divideButton.setOnClickListener { performOperation("/") }
    }

    private fun performOperation(operator: String) {
        val firstNumberString = firstNumberEditText.text.toString()
        val secondNumberString = secondNumberEditText.text.toString()

        if (firstNumberString.isEmpty() || secondNumberString.isEmpty()) {
            calculationResult.text = "Number cannot be null"
            return
        }
        try {
            val firstNumber = firstNumberString.toDouble()
            val secondNumber = secondNumberString.toDouble()

            val result = when (operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> {calculationResult.text = secondNumber.toString()
                    if (secondNumber == 0.0) {

                        calculationResult.text = "Cannot be divided by zero"
                        return
                    } else {
                        firstNumber / secondNumber
                    }
                }
                else ->  0.0
            }
            calculationResult.text = result.toString()

        }
        catch (e: NumberFormatException) {
            calculationResult.text = "Enter a valid number"
        }
    }
}