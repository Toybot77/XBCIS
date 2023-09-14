package com.example.wesmobileapp

import android.content.ContentValues.TAG
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        lateinit var mediaPlayer2: MediaPlayer
        val videoView2: VideoView = findViewById(R.id.videoV)
        videoView2.setVideoURI(
            Uri.parse(
                "android.resource://" + packageName
                        + "/" + R.raw.bgvideo))

        videoView2.start()
        videoView2.setOnCompletionListener {
            MediaPlayer.OnCompletionListener {
                mediaPlayer2.isLooping
            }
        }

        mAuth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()


        val button2: Button = findViewById(R.id.loginButton)
        val user: TextInputEditText = findViewById(R.id.uText)
        val pass: TextInputEditText = findViewById(R.id.pText)
        val bar: ProgressBar = findViewById(R.id.pBar)

        button2.setOnClickListener {

            bar.visibility = View.VISIBLE

            val email = user.text.toString()
            val password = pass.text.toString()

            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        finish()
                        Log.d(TAG, "signInWithEmail:success")
                        Toast.makeText(
                            baseContext,
                            "Authentication successful.",
                            Toast.LENGTH_SHORT
                        ).show()
                        val x = Intent(applicationContext, ViewActivity::class.java)
                        finish()
                        startActivity(x)
                    } else {
                        val i = Intent(this, LoginActivity::class.java)
                        finish()
                        overridePendingTransition(0, 0)
                        startActivity(i)
                        overridePendingTransition(0, 0)
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }


        }
    }

}










