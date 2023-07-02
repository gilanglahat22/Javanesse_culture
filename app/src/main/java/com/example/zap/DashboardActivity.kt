package com.example.zap

import android.content.Context
import android.content.Intent
import android.hardware.SensorEventListener
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.zap.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity()  {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mediaPlayer = MediaPlayer.create(this, R.raw.backsound)
        mediaPlayer.isLooping = true // Set the music to loop indefinitely
        mediaPlayer.setVolume(0.5f, 0.5f) // Set the volume (0.0f - 1.0f)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        //Get TextView in Frontend
        val tv_greeting = findViewById<TextView>(R.id.greet_name)

        //Get the Intent with the name from Activity Main
        val userName = sharedPref.getString(Constants.USERNAME, "User")

//        //Text Views for Highest Scores
//        val highest_score_general = findViewById<TextView>(R.id.highest_score_general)
//        val highest_score_history = findViewById<TextView>(R.id.highest_score_history)
//        val highest_score_movies = findViewById<TextView>(R.id.highest_score_movies)
//        val highest_score_comics = findViewById<TextView>(R.id.highest_score_comics)
//
//        //Highest Score Values
//        val highestScoreGeneral = sharedPref.getInt(Constants.GENERAL_HIGHEST_SCORE, 0)
//        val highestScoreHistory = sharedPref.getInt(Constants.HISTORY_HIGHEST_SCORE, 0)
//        val highestScoreMovies = sharedPref.getInt(Constants.MOVIES_HIGHEST_SCORE, 0)
//        val highestScoreComics = sharedPref.getInt(Constants.COMICS_HIGHEST_SCORE, 0)
//
//        //Set the Greeting Text
        tv_greeting.text = userName
//
//        //Assign Highest Scores to Text Views
//        highest_score_general.text = highestScoreGeneral.toString()
//        highest_score_history.text = highestScoreHistory.toString()
//        highest_score_movies.text = highestScoreMovies.toString()
//        highest_score_comics.text = highestScoreComics.toString()
//
//        //Get the Front end Categories by CardView
//        val general_category = findViewById<CardView>(R.id.general_category)
//        val history_category = findViewById<CardView>(R.id.history_category)
//        val movies_category = findViewById<CardView>(R.id.movies_category)
//        val comics_category = findViewById<CardView>(R.id.comics_category)
//
//        val mCategoryGen = findViewById<TextView>(R.id.general_category_name)
//        val mCategoryHis = findViewById<TextView>(R.id.history_category_name)
//        val mCategoryMov = findViewById<TextView>(R.id.movies_category_name)
//        val mCategoryCom = findViewById<TextView>(R.id.comics_category_name)

        //General Category OnClickListener
//        general_category.setOnClickListener{
//            val intent = Intent(this, GeneralQuizActivity::class.java)
//            intent.putExtra(Constants.USERNAME, userName)
//            intent.putExtra(Constants.GENERAL_HIGHEST_SCORE, highestScoreGeneral)
//            intent.putExtra(Constants.CATEGORY, mCategoryGen.text.toString())
//            startActivity(intent);
//            finish();
//        }
//
//        //History Category OnClickListener
//        history_category.setOnClickListener{
//            val intent = Intent(this, HistoryQuizActivity::class.java)
//            intent.putExtra(Constants.USERNAME, userName)
//            intent.putExtra(Constants.HISTORY_HIGHEST_SCORE, highestScoreHistory)
//            intent.putExtra(Constants.CATEGORY, mCategoryHis.text.toString())
//            startActivity(intent);
//            finish();
//        }
//
//        //Movies Category OnClickListener
//        movies_category.setOnClickListener{
//            val intent = Intent(this, MoviesQuizActivity::class.java)
//            intent.putExtra(Constants.USERNAME, userName)
//            intent.putExtra(Constants.MOVIES_HIGHEST_SCORE, highestScoreMovies)
//            intent.putExtra(Constants.CATEGORY, mCategoryMov.text.toString())
//            startActivity(intent);
//            finish();
//        }
//
//        //Comics Category OnClickListener
//        comics_category.setOnClickListener{
//            val intent = Intent(this, ComicsQuizActivity::class.java)
//            intent.putExtra(Constants.USERNAME, userName)
//            intent.putExtra(Constants.COMICS_HIGHEST_SCORE, highestScoreComics)
//            intent.putExtra(Constants.CATEGORY, mCategoryCom.text.toString())
//            startActivity(intent);
//            finish();
//        }
        val video_pembelajaran = findViewById<CardView>(R.id.video_pembelajaran)
        val petunjuk_penggunaan = findViewById<CardView>(R.id.petunjuk_penggunaan)
        video_pembelajaran.setOnClickListener{
            val intent = Intent(this, VideoPembelajaranActivity::class.java)
            intent.putExtra(Constants.USERNAME, userName)
            intent.putExtra(Constants.CATEGORY, "Video Pembelajaran")
            startActivity(intent);
            finish();
        }

        petunjuk_penggunaan.setOnClickListener{
            val intent = Intent(this, PetunjukPembelajaranActivity::class.java)
            intent.putExtra(Constants.USERNAME, userName)
            intent.putExtra(Constants.CATEGORY, "Petunjuk Penggunaan")
            startActivity(intent);
            finish();
        }

        findViewById<BottomNavigationView>(R.id.bottomNavigationViewDashboard).setOnNavigationItemSelectedListener  {
            when(it.itemId) {
                R.id.quiz -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.putExtra(Constants.USERNAME, userName)
                    intent.putExtra(Constants.CATEGORY, "")
                    startActivity(intent);
                    finish();
                    true
                }
                R.id.materi -> {
                    val intent = Intent(this, DashboardMateriActivity::class.java)
                    intent.putExtra(Constants.USERNAME, userName)
                    intent.putExtra(Constants.CATEGORY, "")
                    startActivity(intent);
                    finish();
                    true
                }
                else ->{
                    false
                }
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