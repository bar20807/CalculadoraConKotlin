package com.prueba.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import androidx.annotation.RequiresApi
import android.os.Build
import android.os.Bundle
import com.prueba.mainactivity.R
import android.content.Intent
import com.prueba.mainactivity.MainActivity
import android.text.SpannableStringBuilder
import android.view.View
import org.mariuszgromada.math.mxparser.Expression

class Calculadora : AppCompatActivity() {
    private var display: EditText? = null
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        display = findViewById(R.id.input)


    }

    private fun updateText(stringtoADD: String) {
        val oldText = display!!.text.toString()
        val cursorPosition = display!!.selectionStart
        val leftString = oldText.substring(0, cursorPosition)
        val rightString = oldText.substring(cursorPosition)
        if (getString(R.string.pantalla) == display!!.text.toString()) {
            display!!.setText(stringtoADD)
            display!!.setSelection(cursorPosition + 1)
        } else {
            display!!.setText(String.format("%s%s%s", leftString, stringtoADD, rightString))
            display!!.setSelection(cursorPosition + 1)
        }
    }

    fun regresarPrincipal(view: View?) {
        val regresar = Intent(this, MainActivity::class.java)
        startActivity(regresar)
    }

    fun btnCero(view: View?) {
        updateText("0")
    }

    fun btnUno(view: View?) {
        updateText("1")
    }

    fun btnDos(view: View?) {
        updateText("2")
    }

    fun btnTres(view: View?) {
        updateText("3")
    }

    fun btnCuatro(view: View?) {
        updateText("4")
    }

    fun btnCinco(view: View?) {
        updateText("5")
    }

    fun btnSeis(view: View?) {
        updateText("6")
    }

    fun btnSiete(view: View?) {
        updateText("7")
    }

    fun btnOcho(view: View?) {
        updateText("8")
    }

    fun btnNueve(view: View?) {
        updateText("9")
    }

    fun btnMas(view: View?) {
        updateText("+")
    }

    fun btnMenos(view: View?) {
        updateText("-")
    }

    fun btnDividir(view: View?) {
        updateText("÷")
    }

    fun btnmasMenos(view: View?) {
        updateText("+/-")
    }

    fun btnClear(view: View?) {
        display!!.setText("")
    }

    fun btnMultiplicar(view: View?) {
        updateText("×")
    }

    fun btnPunto(view: View?) {
        updateText(".")
    }

    fun btnIgual(view: View?) {
        var userExpression = display!!.text.toString()
        userExpression = userExpression.replace("÷".toRegex(), "/")
        userExpression = userExpression.replace("×".toRegex(), "*")
        val expression = Expression(userExpression)
        val result = expression.calculate().toString()
        display!!.setText(result)
        display!!.setSelection(result.length)
    }

    fun btnExponente(view: View?) {
        updateText("^")
    }

    fun btnParentesis(view: View?) {
        val cursorPosition = display!!.selectionStart
        var openParentesis = 0
        var closeParentesis = 0
        val textLen = display!!.text.length
        for (i in 0 until cursorPosition) {
            if (display!!.text.toString().substring(i, i + 1) == "(") {
                openParentesis += 1
            }
            if (display!!.text.toString().substring(i, i + 1) == ")") {
                closeParentesis += 1
            }
            //(8+9)x1
        }
        if (openParentesis == closeParentesis || display!!.text.toString().substring(textLen - 1, textLen) == "(") {
            updateText("(")
        } else if (closeParentesis < openParentesis && display!!.text.toString().substring(textLen - 1, textLen) != "(") {
            updateText(")")
        }
        display!!.setSelection(cursorPosition + 1)
    }

    fun btnBackSpace(view: View?) {
        val cursorPositon = display!!.selectionStart
        val lenText = display!!.text.length
        if (cursorPositon != 0 && lenText != 0) {
            val selection = display!!.text as SpannableStringBuilder
            selection.replace(cursorPositon - 1, cursorPositon, "")
            display!!.text = selection
            display!!.setSelection(cursorPositon - 1)
        }
    }
}