package com.example.calculator
import android.icu.text.DecimalFormat
import android.os.Build
import kotlin.text.Regex
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clear_button.setOnClickListener {
            input.text = ""
            output.text = ""

        }

        left_bracket.setOnClickListener {
            input.text = addToInputText(buttonValue = "(")

        }

        right_bracket.setOnClickListener {
            input.text = addToInputText(buttonValue = ")")

        }
        add.setOnClickListener {
            input.text = addToInputText(buttonValue = "+")

        }
        multification.setOnClickListener {
            input.text = addToInputText(buttonValue = "*")

        }
        division.setOnClickListener {
            input.text = addToInputText(buttonValue = "/")

        }
        sub.setOnClickListener {
            input.text = addToInputText(buttonValue = "-")

        }
        btn_0.setOnClickListener {
            input.text = addToInputText(buttonValue = "0")

        }

        btn_1.setOnClickListener {
            input.text = addToInputText(buttonValue = "1")

        }
        btn_2.setOnClickListener {
            input.text = addToInputText(buttonValue = "2")

        }
        btn_3.setOnClickListener {
            input.text = addToInputText(buttonValue = "3")

        }
        btn_4.setOnClickListener {
            input.text = addToInputText(buttonValue = "4")

        }
        btn_5.setOnClickListener {
            input.text = addToInputText(buttonValue = "5")

        }
        btn_6.setOnClickListener {
            input.text = addToInputText(buttonValue = "6")

        }
        btn_7.setOnClickListener {
            input.text = addToInputText(buttonValue = "7")

        }
        btn_8.setOnClickListener {
            input.text = addToInputText(buttonValue = "8")

        }
        btn_9.setOnClickListener {
            input.text = addToInputText(buttonValue = "9")

        }
        decimal_point.setOnClickListener {
            input.text = addToInputText(buttonValue = ".")

        }
        equal.setOnClickListener {
            showResult()

        }





    }



    private fun addToInputText(buttonValue : String):String{
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression():String{

        var expression = input.text.replace(Regex("÷"), "/")
        expression = input.text.replace(Regex("x"), "*")

        return  expression
    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun showResult(){

        try{
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this,R.color.red))


            }else{

                //show result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this,R.color.green))




            }
        } catch (e: Exception){

            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this,R.color.red))


        }

    }


}


