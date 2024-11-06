package com.example.pasitea

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pasitea.databinding.ActivityAnimacionBinding

class AnimacionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimacionBinding
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar el GIF en el ImageView usando Glide
        Glide.with(this)
            .asGif()
            .load(R.drawable.animacion_1) // Usa animacion_1 como nombre del GIF
            .into(binding.imageViewGif)

        // Configurar y reproducir el sonido de fondo
        mediaPlayer = MediaPlayer.create(this, R.raw.ruido_blanco)
        mediaPlayer?.isLooping = true // Para que el sonido se repita
        mediaPlayer?.start()

        // Manejar el botón de retroceso usando OnBackPressedDispatcher
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                mediaPlayer?.stop() // Detener el sonido al regresar al menú
                mediaPlayer?.release()
                mediaPlayer = null
                finish() // Finalizar la actividad y regresar al menú
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
