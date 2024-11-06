package com.example.pasitea

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pasitea.databinding.ActivityTemporizadorBinding

class TemporizadorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTemporizadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemporizadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar el GIF de fondo
        Glide.with(this)
            .asGif()
            .load(R.drawable.temporizador_fondo_gif)
            .into(binding.imageViewBackgroundGif)
    }
}
