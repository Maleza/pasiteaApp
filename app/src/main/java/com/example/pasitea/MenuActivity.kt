package com.example.pasitea

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnAnimacion = findViewById<Button>(R.id.btnAnimacion)
        val btnTemporizador = findViewById<Button>(R.id.btnTemporizador)

        // Botón para abrir AnimacionActivity
        btnAnimacion.setOnClickListener {
            val intent = Intent(this, AnimacionActivity::class.java)
            startActivity(intent)
        }

        // Botón para abrir TemporizadorActivity
        btnTemporizador.setOnClickListener {
            val intent = Intent(this, TemporizadorActivity::class.java)
            startActivity(intent)
        }
    }
}