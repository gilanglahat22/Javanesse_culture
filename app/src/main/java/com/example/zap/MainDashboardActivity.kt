package com.example.zap

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainDashboardActivity: AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maindashboard)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mediaPlayer = MediaPlayer.create(this, R.raw.backsound)
        mediaPlayer.isLooping = true // Set the music to loop indefinitely
        mediaPlayer.setVolume(0.5f, 0.5f) // Set the volume (0.0f - 1.0f)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        //Get TextView in Frontend
        val tv_greeting = findViewById<TextView>(R.id.greet_name)
        val quiz_category = findViewById<CardView>(R.id.quiz_category)
        //Get the Intent with the name from Activity Main
        val userName = sharedPref.getString(Constants.USERNAME, "User")

        //Set the Greeting Text
        tv_greeting.text = userName

        quiz_category.setOnClickListener{
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra(Constants.USERNAME, userName)
            startActivity(intent);
        }
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer.start() // Start playing the music
    }
}