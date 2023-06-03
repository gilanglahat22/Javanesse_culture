package com.example.zap

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class MoviesQuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mMoviesQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectOptions: Int = 0
    private var mUsername: String? = null
    private var mCategory: String? = null
    private lateinit var mediaPlayerBenar: MediaPlayer
    private lateinit var mediaPlayerSalah: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_quiz)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mediaPlayerBenar = MediaPlayer.create(this, R.raw.sound_benar)
        mediaPlayerBenar.setVolume(0.5f, 0.5f) // Set the volume (0.0f - 1.0f)
        mediaPlayerSalah = MediaPlayer.create(this, R.raw.sound_salah)
        mediaPlayerSalah.setVolume(0.5f, 0.5f) // Set the volume (0.0f - 1.0f)
        mUsername = intent.getStringExtra(Constants.USERNAME)
        mCategory = intent.getStringExtra(Constants.CATEGORY)

        //Get the Movies Questions List
        mMoviesQuestionsList = Constants.moviesQuestions()

        setMoviesQuestion()

        //Get Movies Question Options
        var tv_movies_option_one = findViewById<TextView>(R.id.tv_movies_option_one)
        var tv_movies_option_two = findViewById<TextView>(R.id.tv_movies_option_two)
        var tv_movies_option_three = findViewById<TextView>(R.id.tv_movies_option_three)
        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        tv_movies_option_one.setOnClickListener(this)
        tv_movies_option_two.setOnClickListener(this)
        tv_movies_option_three.setOnClickListener(this)
        btn_are_you_correct.setOnClickListener(this)

    }

    private fun setMoviesQuestion() {

        val moviesQuestion = mMoviesQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        if (mCurrentPosition == mMoviesQuestionsList!!.size) {
            btn_are_you_correct.text = "Finish"
        } else {
            btn_are_you_correct.text = "Is it correct?"
        }

        //Get Movies Question Items
        var movies_progressbar = findViewById<ProgressBar>(R.id.movies_progressbar)
        var tv_movies_progress = findViewById<TextView>(R.id.tv_movies_progress)
        var tv_movies_question = findViewById<TextView>(R.id.tv_movies_question)
        var movies_category_bottom_image = findViewById<ImageView>(R.id.movies_category_bottom_image)

        //Get Movies Question Options
        var tv_movies_option_one = findViewById<TextView>(R.id.tv_movies_option_one)
        var tv_movies_option_two = findViewById<TextView>(R.id.tv_movies_option_two)
        var tv_movies_option_three = findViewById<TextView>(R.id.tv_movies_option_three)

        movies_progressbar.progress = mCurrentPosition
        tv_movies_progress.text = "$mCurrentPosition" + "/" + movies_progressbar.max
        tv_movies_question.text = moviesQuestion!!.question
        movies_category_bottom_image.setImageResource(moviesQuestion.categoryImage)

        //Add Movies Questions Options
        tv_movies_option_one.text = moviesQuestion.optionOne
        tv_movies_option_two.text = moviesQuestion.optionTwo
        tv_movies_option_three.text = moviesQuestion.optionThree

    }

    private fun defaultOptionsView() {

        var tv_movies_option_one = findViewById<TextView>(R.id.tv_movies_option_one)
        var tv_movies_option_two = findViewById<TextView>(R.id.tv_movies_option_two)
        var tv_movies_option_three = findViewById<TextView>(R.id.tv_movies_option_three)

        val options = ArrayList<TextView>()
        options.add(0, tv_movies_option_one)
        options.add(1, tv_movies_option_two)
        options.add(2, tv_movies_option_three)

        for (option in options) {
            option.setTextColor(Color.parseColor("#131313"))
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_style
            )
        }

    }

    override fun onClick(v: View?) {

        var tv_movies_option_one = findViewById<TextView>(R.id.tv_movies_option_one)
        var tv_movies_option_two = findViewById<TextView>(R.id.tv_movies_option_two)
        var tv_movies_option_three = findViewById<TextView>(R.id.tv_movies_option_three)
        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        btn_are_you_correct.setEnabled(false)

        when(v?.id) {
            R.id.tv_movies_option_one ->{
                selectedOptionsView(tv_movies_option_one, 1)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.tv_movies_option_two ->{
                selectedOptionsView(tv_movies_option_two, 2)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.tv_movies_option_three ->{
                selectedOptionsView(tv_movies_option_three, 3)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.btn_are_you_correct ->{
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition ++

                    when {
                        mCurrentPosition <= mMoviesQuestionsList!!.size -> {
                            tv_movies_option_one.setClickable(true)
                            tv_movies_option_two.setClickable(true)
                            tv_movies_option_three.setClickable(true)
                            setMoviesQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.CATEGORY, mCategory)
                            intent.putExtra(Constants.USERNAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectOptions)
                            intent.putExtra(Constants.QUESTIONS_TOTAL, mMoviesQuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mMoviesQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        mediaPlayerSalah.start()
                        tv_movies_option_one.setClickable(false)
                        tv_movies_option_two.setClickable(false)
                        tv_movies_option_three.setClickable(false)
                        answerView(mSelectedOptionPosition, R.drawable.wrong_selected_option_style)
                    } else {
                        mediaPlayerBenar.start()
                        mCorrectOptions++
                        tv_movies_option_one.setClickable(false)
                        tv_movies_option_two.setClickable(false)
                        tv_movies_option_three.setClickable(false)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_selected_option_style)

                    if (mCurrentPosition == mMoviesQuestionsList!!.size) {
                        btn_are_you_correct.setEnabled(true)
                        btn_are_you_correct.text = "Finish"
                    } else {
                        btn_are_you_correct.setEnabled(true)
                        btn_are_you_correct.text = "Next Question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        var tv_movies_option_one = findViewById<TextView>(R.id.tv_movies_option_one)
        var tv_movies_option_two = findViewById<TextView>(R.id.tv_movies_option_two)
        var tv_movies_option_three = findViewById<TextView>(R.id.tv_movies_option_three)

        when(answer) {
            1 -> {
                tv_movies_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_movies_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_movies_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#FFFFFF"))
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.general_selected_option_style
        )
    }
}