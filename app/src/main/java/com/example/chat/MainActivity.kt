package com.example.chat

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var mensajeRecibido: TextView

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val mensaje = result.data?.getStringExtra("mensaje")
            mensajeRecibido.text = mensaje
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mensajeRecibido = findViewById(R.id.mensajeRecibido)
        val mensajeEnviado = findViewById<EditText>(R.id.mensajeEnviado)

        val enviarButton = findViewById<Button>(R.id.enviarButton)

        enviarButton.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("mensaje", mensajeEnviado.text.toString())
            startForResult.launch(intent)
        }
    }
}