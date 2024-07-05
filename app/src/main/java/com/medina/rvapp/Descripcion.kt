package com.medina.rvapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class Descripcion : AppCompatActivity() {
    lateinit var btnAtras: Button
    private lateinit var btnPlayPause: ImageButton
    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false
    private var audioResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_descripcion)

        // Obtiene los extras del intent y maneja la nullabilidad
        val songTitle = intent.getStringExtra("songTitle") ?: "Unknown Title"
        val songAuthor = intent.getStringExtra("songAuthor") ?: "Unknown Author"
        val songPhoto = intent.getStringExtra("songPhoto") ?: ""
        val songDescription = intent.getStringExtra("descripcion") ?: "No Description Available"

        audioResId = intent.getIntExtra("audioResId", 0)

        // Encuentra las vistas y asigna los valores
        val titleTextView: TextView = findViewById(R.id.tvTitlesong)
        val authorTextView: TextView = findViewById(R.id.tvAutor)
        val photoImageView: ImageView = findViewById(R.id.ivAvatar)
        val descriptionTextView: TextView = findViewById(R.id.tvDescripcion)

        titleTextView.text = songTitle
        authorTextView.text = songAuthor
        descriptionTextView.text = songDescription
        photoImageView.loadUrl(songPhoto)

        btnAtras = findViewById<Button>(R.id.btnAtras)
        btnAtras.setOnClickListener{ finish()}

        btnPlayPause = findViewById(R.id.btnPlayPause)

        if (audioResId != 0) {
            mediaPlayer = MediaPlayer.create(this, audioResId)
        }

        btnPlayPause.setOnClickListener {
            if (audioResId != 0) {
                if (isPlaying) {
                    mediaPlayer.pause()
                    btnPlayPause.setImageResource(R.drawable.ic_play)
                } else {
                    mediaPlayer.start()
                    btnPlayPause.setImageResource(R.drawable.ic_pause)
                }
                isPlaying = !isPlaying
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberar los recursos del MediaPlayer cuando la actividad se destruya
        if (this::mediaPlayer.isInitialized && audioResId != 0) {
            mediaPlayer.release()
        }
    }

    fun ImageView.loadUrl(url: String) {
        Picasso.get().load(url).into(this)
    }
}