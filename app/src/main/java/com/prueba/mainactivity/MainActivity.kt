package com.prueba.mainactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irCalculadora(view: View?) {
        val siguiente = Intent(this, Calculadora::class.java)
        startActivity(siguiente)
    }
}