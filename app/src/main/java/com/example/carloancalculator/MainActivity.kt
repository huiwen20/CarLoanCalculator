package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    private fun calculateLoan() {
        //TODO: get all inputs and calculate outputs
        //To check the value is it empty
        if (editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.input_error))
            return
        }else if (editTextDownPayment.text.isEmpty()){
            editTextDownPayment.setError(getString(R.string.input_error))
            return
        }else if (editTextInterestRate.text.isEmpty()){
            editTextInterestRate.setError(getString(R.string.input_error))
            return
        }else if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.setError(getString(R.string.input_error))
            return
        }else{
            //return //end the program execution
        }

        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
        val interestRate: Float = editTextInterestRate.text.toString().toFloat()

        val loan: Int = carPrice-downPayment
        val interest: Float = loan*interestRate/100*loanPeriod
        val monthlyRepayment: Float = (loan+interest)/loanPeriod/12

        textViewLoan.text = String.format("%s, %d", getString(R.string.loan) ,loan)
        textViewInterest.text = String.format("%s, %.2f", getString(R.string.interest), interest)
        textViewRepayment.text = String.format("%s, %.2f", getString(R.string.monthly_payment), monthlyRepayment)


    }

    fun reset(view: View) {
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextInterestRate.text.clear()
        editTextLoanPeriod.text.clear()
    }
}
