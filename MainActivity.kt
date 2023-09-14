package com.example.wesmobileapp

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(){


    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoView: VideoView = findViewById(R.id.videoView)

        videoView.setVideoURI(
            Uri.parse("android.resource://" + packageName
                    + "/" + R.raw.bgvideo))
        videoView.start()

        videoView.setOnCompletionListener {
            MediaPlayer.OnCompletionListener{
                mediaPlayer.isLooping
            }
        }

        button = findViewById(R.id.button)
    }



    override fun onStart() {
        super.onStart()

        button.setOnClickListener {
            val a = Intent(this, LoginActivity::class.java)
            finish()
            startActivity(a)

        }
    }
}
