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

class GeneralQuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mGeneralQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectOptions: Int = 0
    private var mUsername: String? = null
    private var mCategory: String? = null
    private lateinit var mediaPlayerBenar: MediaPlayer
    private lateinit var mediaPlayerSalah: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_quiz)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mediaPlayerBenar = MediaPlayer.create(this, R.raw.sound_benar)
        mediaPlayerBenar.setVolume(0.5f, 0.5f) // Set the volume (0.0f - 1.0f)

        mediaPlayerSalah = MediaPlayer.create(this, R.raw.sound_salah)
        mediaPlayerSalah.setVolume(0.5f, 0.5f) // Set the volume (0.0f - 1.0f)
        mUsername = intent.getStringExtra(Constants.USERNAME)
        mCategory = intent.getStringExtra(Constants.CATEGORY)

        //Get the General Questions List
        mGeneralQuestionsList = Constants.generalQuestions()

        setGeneralQuestion()

        //Get General Question Options
        var tv_general_option_one = findViewById<TextView>(R.id.tv_general_option_one)
        var tv_general_option_two = findViewById<TextView>(R.id.tv_general_option_two)
        var tv_general_option_three = findViewById<TextView>(R.id.tv_general_option_three)
        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        tv_general_option_one.setOnClickListener(this)
        tv_general_option_two.setOnClickListener(this)
        tv_general_option_three.setOnClickListener(this)
        btn_are_you_correct.setOnClickListener(this)

    }

    private fun setGeneralQuestion() {

        val generalQuestion = mGeneralQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        if (mCurrentPosition == mGeneralQuestionsList!!.size) {
            btn_are_you_correct.text = "Finish"
        } else {
            btn_are_you_correct.text = "Is it correct?"
        }

        //Get General Question Items
        var general_progressbar = findViewById<ProgressBar>(R.id.general_progressbar)
        var tv_general_progress = findViewById<TextView>(R.id.tv_general_progress)
        var tv_general_question = findViewById<TextView>(R.id.tv_general_question)
        var general_category_bottom_image = findViewById<ImageView>(R.id.general_category_bottom_image)

        //Get General Question Options
        var tv_general_option_one = findViewById<TextView>(R.id.tv_general_option_one)
        var tv_general_option_two = findViewById<TextView>(R.id.tv_general_option_two)
        var tv_general_option_three = findViewById<TextView>(R.id.tv_general_option_three)

        general_progressbar.progress = mCurrentPosition
        tv_general_progress.text = "$mCurrentPosition" + "/" + 4
        tv_general_question.text = generalQuestion!!.question
        general_category_bottom_image.setImageResource(generalQuestion.categoryImage)

        //Add General Questions Options
        tv_general_option_one.text = generalQuestion.optionOne
        tv_general_option_two.text = generalQuestion.optionTwo
        tv_general_option_three.text = generalQuestion.optionThree
    }

    private fun defaultOptionsView() {

        var tv_general_option_one = findViewById<TextView>(R.id.tv_general_option_one)
        var tv_general_option_two = findViewById<TextView>(R.id.tv_general_option_two)
        var tv_general_option_three = findViewById<TextView>(R.id.tv_general_option_three)

        val options = ArrayList<TextView>()
        options.add(0, tv_general_option_one)
        options.add(1, tv_general_option_two)
        options.add(2, tv_general_option_three)

        for (option in options) {
            option.setTextColor(Color.parseColor("#131313"))
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.option_style
            )
        }

    }

    override fun onClick(v: View?) {

        var tv_general_option_one = findViewById<TextView>(R.id.tv_general_option_one)
        var tv_general_option_two = findViewById<TextView>(R.id.tv_general_option_two)
        var tv_general_option_three = findViewById<TextView>(R.id.tv_general_option_three)
        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        btn_are_you_correct.setEnabled(false)

        when(v?.id) {
            R.id.tv_general_option_one ->{
                selectedOptionsView(tv_general_option_one, 1)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.tv_general_option_two ->{
                selectedOptionsView(tv_general_option_two, 2)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.tv_general_option_three ->{
                selectedOptionsView(tv_general_option_three, 3)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.btn_are_you_correct ->{
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition ++

                    when {
                        mCurrentPosition <= mGeneralQuestionsList!!.size -> {
                            tv_general_option_one.setClickable(true)
                            tv_general_option_two.setClickable(true)
                            tv_general_option_three.setClickable(true)
                            setGeneralQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.CATEGORY, mCategory)
                            intent.putExtra(Constants.USERNAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectOptions)
                            intent.putExtra(Constants.QUESTIONS_TOTAL, mGeneralQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mGeneralQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        mediaPlayerSalah.start()
                        tv_general_option_one.setClickable(false)
                        tv_general_option_two.setClickable(false)
                        tv_general_option_three.setClickable(false)
                        answerView(mSelectedOptionPosition, R.drawable.wrong_selected_option_style)
                    } else {
                        mediaPlayerBenar.start()
                        mCorrectOptions++
                        tv_general_option_one.setClickable(false)
                        tv_general_option_two.setClickable(false)
                        tv_general_option_three.setClickable(false)
                    }

                    answerView(question.correctAnswer, R.drawable.correct_selected_option_style)

                    if (mCurrentPosition == mGeneralQuestionsList!!.size) {
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

        var tv_general_option_one = findViewById<TextView>(R.id.tv_general_option_one)
        var tv_general_option_two = findViewById<TextView>(R.id.tv_general_option_two)
        var tv_general_option_three = findViewById<TextView>(R.id.tv_general_option_three)

        when(answer) {
            1 -> {
                tv_general_option_one.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            2 -> {
                tv_general_option_two.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            3 -> {
                tv_general_option_three.background = ContextCompat.getDrawable(
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