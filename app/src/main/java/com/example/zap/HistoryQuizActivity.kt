package com.example.zap

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class HistoryQuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mHistoryQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectOptions: Int = 0
    private var mUsername: String? = null
    private var mCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_quiz)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUsername = intent.getStringExtra(Constants.USERNAME)
        mCategory = intent.getStringExtra(Constants.CATEGORY)

        //Get the History Questions List
        mHistoryQuestionsList = Constants.historyQuestions()

        setHistoryQuestion()

        //Get History Question Options
        var tv_history_option_one = findViewById<TextView>(R.id.tv_history_option_one)
        var tv_history_option_two = findViewById<TextView>(R.id.tv_history_option_two)
        var tv_history_option_three = findViewById<TextView>(R.id.tv_history_option_three)
        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        tv_history_option_one.setOnClickListener(this)
        tv_history_option_two.setOnClickListener(this)
        tv_history_option_three.setOnClickListener(this)
        btn_are_you_correct.setOnClickListener(this)

    }

    private fun setHistoryQuestion() {

        val historyQuestion = mHistoryQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        if (mCurrentPosition == mHistoryQuestionsList!!.size) {
            btn_are_you_correct.text = "Finish"
        } else {
            btn_are_you_correct.text = "Is it correct?"
        }

        //Get History Question Items
        var history_progressbar = findViewById<ProgressBar>(R.id.history_progressbar)
        var tv_history_progress = findViewById<TextView>(R.id.tv_history_progress)
        var tv_history_question = findViewById<TextView>(R.id.tv_history_question)
        var history_category_bottom_image = findViewById<ImageView>(R.id.history_category_bottom_image)

        //Get History Question Options
        var tv_history_option_one = findViewById<TextView>(R.id.tv_history_option_one)
        var tv_history_option_two = findViewById<TextView>(R.id.tv_history_option_two)
        var tv_history_option_three = findViewById<TextView>(R.id.tv_history_option_three)

        history_progressbar.progress = mCurrentPosition
        tv_history_progress.text = "$mCurrentPosition" + "/" + history_progressbar.max
        tv_history_question.text = historyQuestion!!.question
        history_category_bottom_image.setImageResource(historyQuestion.categoryImage)

        //Add History Questions Options
        tv_history_option_one.text = historyQuestion.optionOne
        tv_history_option_two.text = historyQuestion.optionTwo
        tv_history_option_three.text = historyQuestion.optionThree

    }

    private fun defaultOptionsView() {

        var tv_history_option_one = findViewById<TextView>(R.id.tv_history_option_one)
        var tv_history_option_two = findViewById<TextView>(R.id.tv_history_option_two)
        var tv_history_option_three = findViewById<TextView>(R.id.tv_history_option_three)

        val options = ArrayList<TextView>()
        options.add(0, tv_history_option_one)
        options.add(1, tv_history_option_two)
        options.add(2, tv_history_option_three)

        for (option in options) {
            option.setTextColor(Color.parseColor("#131313"))
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.option_style
            )
        }

    }

    override fun onClick(v: View?) {

        var tv_history_option_one = findViewById<TextView>(R.id.tv_history_option_one)
        var tv_history_option_two = findViewById<TextView>(R.id.tv_history_option_two)
        var tv_history_option_three = findViewById<TextView>(R.id.tv_history_option_three)
        var btn_are_you_correct = findViewById<Button>(R.id.btn_are_you_correct)

        btn_are_you_correct.setEnabled(false)

        when(v?.id) {
            R.id.tv_history_option_one ->{
                selectedOptionsView(tv_history_option_one, 1)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.tv_history_option_two ->{
                selectedOptionsView(tv_history_option_two, 2)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.tv_history_option_three ->{
                selectedOptionsView(tv_history_option_three, 3)
                btn_are_you_correct.setEnabled(true)
            }
            R.id.btn_are_you_correct ->{
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition ++

                    when {
                        mCurrentPosition <= mHistoryQuestionsList!!.size -> {
                            tv_history_option_one.setClickable(true)
                            tv_history_option_two.setClickable(true)
                            tv_history_option_three.setClickable(true)
                            setHistoryQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.CATEGORY, mCategory)
                            intent.putExtra(Constants.USERNAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectOptions)
                            intent.putExtra(Constants.QUESTIONS_TOTAL, mHistoryQuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mHistoryQuestionsList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        tv_history_option_one.setClickable(false)
                        tv_history_option_two.setClickable(false)
                        tv_history_option_three.setClickable(false)
                        answerView(mSelectedOptionPosition, R.drawable.wrong_selected_option_style)
                    } else {
                        mCorrectOptions++
                        tv_history_option_one.setClickable(false)
                        tv_history_option_two.setClickable(false)
                        tv_history_option_three.setClickable(false)
                    }
                    answerView(question.correctAnswer, R.drawable.correct_selected_option_style)

                    if (mCurrentPosition == mHistoryQuestionsList!!.size) {
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

        var tv_history_option_one = findViewById<TextView>(R.id.tv_history_option_one)
        var tv_history_option_two = findViewById<TextView>(R.id.tv_history_option_two)
        var tv_history_option_three = findViewById<TextView>(R.id.tv_history_option_three)

        when(answer) {
            1 -> {
                tv_history_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_history_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_history_option_three.background = ContextCompat.getDrawable(
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