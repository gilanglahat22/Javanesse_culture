package com.example.zap

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        //Get TextView in Frontend
        val tv_greeting = findViewById<TextView>(R.id.greet_name)

        //Get the Intent with the name from Activity Main
        val userName = sharedPref.getString(Constants.USERNAME, "User")

        //Text Views for Highest Scores
        val highest_score_general = findViewById<TextView>(R.id.highest_score_general)
        val highest_score_history = findViewById<TextView>(R.id.highest_score_history)
        val highest_score_movies = findViewById<TextView>(R.id.highest_score_movies)
        val highest_score_comics = findViewById<TextView>(R.id.highest_score_comics)

        //Highest Score Values
        val highestScoreGeneral = sharedPref.getInt(Constants.GENERAL_HIGHEST_SCORE, 0)
        val highestScoreHistory = sharedPref.getInt(Constants.HISTORY_HIGHEST_SCORE, 0)
        val highestScoreMovies = sharedPref.getInt(Constants.MOVIES_HIGHEST_SCORE, 0)
        val highestScoreComics = sharedPref.getInt(Constants.COMICS_HIGHEST_SCORE, 0)

        //Set the Greeting Text
        tv_greeting.text = userName

        //Assign Highest Scores to Text Views
        highest_score_general.text = highestScoreGeneral.toString()
        highest_score_history.text = highestScoreHistory.toString()
        highest_score_movies.text = highestScoreMovies.toString()
        highest_score_comics.text = highestScoreComics.toString()

        //Get the Front end Categories by CardView
        val general_category = findViewById<CardView>(R.id.general_category)
        val history_category = findViewById<CardView>(R.id.history_category)
        val movies_category = findViewById<CardView>(R.id.movies_category)
        val comics_category = findViewById<CardView>(R.id.comics_category)

        val mCategoryGen = findViewById<TextView>(R.id.general_category_name)
        val mCategoryHis = findViewById<TextView>(R.id.history_category_name)
        val mCategoryMov = findViewById<TextView>(R.id.movies_category_name)
        val mCategoryCom = findViewById<TextView>(R.id.comics_category_name)

        //General Category OnClickListener
        general_category.setOnClickListener{
            val intent = Intent(this, GeneralQuizActivity::class.java)
            intent.putExtra(Constants.USERNAME, userName)
            intent.putExtra(Constants.GENERAL_HIGHEST_SCORE, highestScoreGeneral)
            intent.putExtra(Constants.CATEGORY, mCategoryGen.text.toString())
            startActivity(intent);
        }

        //History Category OnClickListener
        history_category.setOnClickListener{
            val intent = Intent(this, HistoryQuizActivity::class.java)
            intent.putExtra(Constants.USERNAME, userName)
            intent.putExtra(Constants.HISTORY_HIGHEST_SCORE, highestScoreHistory)
            intent.putExtra(Constants.CATEGORY, mCategoryHis.text.toString())
            startActivity(intent);
        }

        //Movies Category OnClickListener
        movies_category.setOnClickListener{
            val intent = Intent(this, MoviesQuizActivity::class.java)
            intent.putExtra(Constants.USERNAME, userName)
            intent.putExtra(Constants.MOVIES_HIGHEST_SCORE, highestScoreMovies)
            intent.putExtra(Constants.CATEGORY, mCategoryMov.text.toString())
            startActivity(intent);
        }

        //Comics Category OnClickListener
        comics_category.setOnClickListener{
            val intent = Intent(this, ComicsQuizActivity::class.java)
            intent.putExtra(Constants.USERNAME, userName)
            intent.putExtra(Constants.COMICS_HIGHEST_SCORE, highestScoreComics)
            intent.putExtra(Constants.CATEGORY, mCategoryCom.text.toString())
            startActivity(intent);
        }

    }
}