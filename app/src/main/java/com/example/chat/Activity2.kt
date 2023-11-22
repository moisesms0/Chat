package com.example.chat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mensajeRecibido = findViewById<TextView>(R.id.mensajeRecibido)
        val mensajeEnviado = findViewById<EditText>(R.id.mensajeEnviado)
        val enviarButton = findViewById<Button>(R.id.enviarButton)

        mensajeRecibido.text = intent.getStringExtra("mensaje")

        enviarButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("mensaje", mensajeEnviado.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}