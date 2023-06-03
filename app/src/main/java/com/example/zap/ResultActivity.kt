package com.example.zap

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.media.SoundPool
import android.widget.Toast

class ResultActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        mediaPlayer = MediaPlayer.create(this, R.raw.results_sound_effect)
        mediaPlayer.setVolume(0.5f, 0.5f) // Set the volume (0.0f - 1.0f)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        val greet_name = findViewById<TextView>(R.id.greet_name)
        val tv_score = findViewById<TextView>(R.id.tv_score)
        val btn_finish = findViewById<Button>(R.id.btn_finish)

        val userName = sharedPref.getString(Constants.USERNAME, "User")
        val editor = sharedPref.edit()

        greet_name.text = userName

        val highestScoreGeneral = sharedPref.getInt(Constants.GENERAL_HIGHEST_SCORE, 0)
        val highestScoreHistory = sharedPref.getInt(Constants.HISTORY_HIGHEST_SCORE, 0)
        val highestScoreMovies = sharedPref.getInt(Constants.MOVIES_HIGHEST_SCORE, 0)
        val highestScoreComics = sharedPref.getInt(Constants.COMICS_HIGHEST_SCORE, 0)

        val totalQuestions = intent.getIntExtra(Constants.QUESTIONS_TOTAL, 0)
        val correctOptions = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val categoryName = intent.getStringExtra(Constants.CATEGORY)

        if (categoryName == "General") {
            if (correctOptions > highestScoreGeneral) {
                editor.apply {
                    putInt(Constants.GENERAL_HIGHEST_SCORE, correctOptions)
                    apply()
                }
            }
        }
        if (categoryName == "History") {
            if (correctOptions > highestScoreHistory) {
                editor.apply {
                    putInt(Constants.HISTORY_HIGHEST_SCORE, correctOptions)
                    apply()
                }
            }
        }
        if (categoryName == "Movies") {
            if (correctOptions > highestScoreMovies) {
                editor.apply {
                    putInt(Constants.MOVIES_HIGHEST_SCORE, correctOptions)
                    apply()
                }
            }
        }
        if (categoryName == "Comics") {
            if (correctOptions > highestScoreComics) {
                editor.apply {
                    putInt(Constants.COMICS_HIGHEST_SCORE, correctOptions)
                    apply()
                }
            }
        }
        tv_score.text = "Akurasi skor kamu adalah $correctOptions/$totalQuestions"

        btn_finish.setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
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