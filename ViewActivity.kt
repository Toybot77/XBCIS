package com.example.wesmobileapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var sbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        sbutton = findViewById(R.id.signOut)

        sbutton.setOnClickListener{

            Toast.makeText(
                baseContext,
                "Signing Out",
                Toast.LENGTH_SHORT
            ).show()

            Firebase.auth.signOut()

            val b = Intent(this, MainActivity::class.java)
            finish()
            startActivity(b)
        }


    }
}