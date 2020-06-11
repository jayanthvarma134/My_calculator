package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener { display("1", true) }
        tvTwo.setOnClickListener { display("2", true) }
        tvThree.setOnClickListener {display("3", true) }
        tvFour.setOnClickListener { display("4", true) }
        tvFive.setOnClickListener { display("5", true) }
        tvSix.setOnClickListener { display("6", true) }
        tvSeven.setOnClickListener { display("7", true) }
        tvEight.setOnClickListener { display("8", true) }
        tvNine.setOnClickListener { display("9", true) }
        tvZero.setOnClickListener { display("0", true) }
        tvDot.setOnClickListener { display(".", true) }

        //Operators
        tvPlus.setOnClickListener { display("+", false) }
        tvMinus.setOnClickListener { display("-", false) }
        tvMul.setOnClickListener { display("*", false) }
        tvDivide.setOnClickListener { display("/", false) }
        //tvOpen.setOnClickListener { display("(", false) }
        //tvClose.setOnClickListener { display(")", false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0,string.length-1)
            }
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            try{
                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
            }catch(e:Exception){
                Log.d(tag = "Exception" , msg =  "messsage" , e.message)
            }

        }

    }


    fun display (string: String, canClear: Boolean) {

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""

        }
    }
}
