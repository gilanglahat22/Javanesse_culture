package com.example.zap

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.io.IOException
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mediaPlayer = MediaPlayer.create(this, R.raw.wonderful_indonesia)
        mediaPlayer.isLooping = true // Set the music to loop indefinitely
        mediaPlayer.setVolume(0.5f, 0.5f) // Set the volume (0.0f - 1.0f)

        //Reference Start Button Manually
        val btn_start = findViewById<Button>(R.id.btn_start)
        val et_name = findViewById<TextView>(R.id.et_name)

        //Start Button Listener
        btn_start.setOnClickListener {
            if(et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()

                val intent = Intent(this, DashboardMateriActivity::class.java)

                editor.apply{
                    putString(Constants.USERNAME, et_name.text.toString())
                    apply()
                }

                startActivity(intent)
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer.start() // Start playing the music
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer.pause() // Pause the music
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.stop() // Stop the music
        mediaPlayer.release() // Release the MediaPlayer resources
    }
}