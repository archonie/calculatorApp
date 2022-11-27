package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun btnNumClick(view: View){
        if(newOp){
            showNum.setText("")
        }
        newOp = false

        var btnChoose = view as Button
        var btnClickValue: String =  showNum.text.toString()
        when(btnChoose.id){
            btn0.id->{
                btnClickValue += "0"
            }
            btn1.id->{
                btnClickValue += "1"
            }
            btn2.id->{
                btnClickValue += "2"
            }
            btn3.id->{
                btnClickValue += "3"
            }
            btn4.id->{
                btnClickValue += "4"
            }
            btn5.id->{
                btnClickValue += "5"
            }
            btn6.id->{
                btnClickValue += "6"
            }
            btn7.id->{
                btnClickValue += "7"
            }
            btn8.id->{
                btnClickValue += "8"
            }
            btn9.id->{
                btnClickValue += "9"
            }
            btnPlusMinus.id->{
                btnClickValue = "-" + btnClickValue
            }
            btnDot.id->{
                btnClickValue +="."
            }
        }
        showNum.setText(btnClickValue)
    }
    var operator = "*"
    var oldNum = ""
    var newOp = true
    fun btnOpClick(view: View){
        var btnOpChoose = view as Button
        when(btnOpChoose.id){
            btnDivide.id->{
                operator = "/"
            }
            btnMultiply.id->{
                operator = "X"
            }
            btnMinus.id->{
                operator = "-"
            }
            btnPlus.id-> {
                operator = "+"
            }

        }
        oldNum = showNum.text.toString()
        newOp = true
        operatorText.setText(operator)

    }
    fun btnEqualClick(view: View){
        var  newNum = showNum.text.toString()
        var resultNum: Double ?= null
        when(operator){
            "/"->{
                resultNum = oldNum.toDouble() / newNum.toDouble()
            }
            "X"->{
                resultNum = oldNum.toDouble() * newNum.toDouble()
            }
            "-"->{
                resultNum = oldNum.toDouble() - newNum.toDouble()
            }
            "+"->{
                resultNum = oldNum.toDouble() + newNum.toDouble()
            }
        }
        showNum.setText(resultNum.toString())
        newOp = true
        oldNum = "0"
        operatorText.setText("")
    }
    fun btnClearClick(view: View){
        showNum.setText("0")
        newOp = true
    }
    fun btnModulaClick(view: View){
        var num: Double = showNum.text.toString().toDouble() /100
        showNum.setText(num.toString())
        newOp=true


    }
}