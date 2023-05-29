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

class GeneralMateriActivity: AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mGeneralMaterisList: ArrayList<Materi>? = null
    private var mUsername: String? = null
    private var mCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_materi)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUsername = intent.getStringExtra(Constants.USERNAME)
        mCategory = intent.getStringExtra(Constants.CATEGORY)

        mGeneralMaterisList = Constants.generalMateris()

        setGeneralMateri()

        var btn_lanjut = findViewById<Button>(R.id.btn_lanjut)
        var btn_kembali = findViewById<Button>(R.id.btn_kembali)
        btn_lanjut.setOnClickListener(this)
        btn_kembali.setOnClickListener(this)
        btn_kembali.setEnabled(true)
        btn_lanjut.setEnabled(true)
    }

    private fun setGeneralMateri() {

        val generalMateri = mGeneralMaterisList!![mCurrentPosition-1]

        var btn_lanjut = findViewById<Button>(R.id.btn_lanjut)
        var btn_kembali = findViewById<Button>(R.id.btn_kembali)

        if (mCurrentPosition == mGeneralMaterisList!!.size) {
            btn_lanjut.text = "Selesai"
        } else {
            btn_lanjut.text = "Lanjut"
        }

        btn_kembali.text = "Kembali"

        var general_progressbar = findViewById<ProgressBar>(R.id.general_progressbar)
        var tv_general_progress = findViewById<TextView>(R.id.tv_general_progress)
        var tv_general_materi = findViewById<TextView>(R.id.tv_general_materi)
        var general_category_bottom_image = findViewById<ImageView>(R.id.general_category_bottom_image)

        general_progressbar.progress = mCurrentPosition
        tv_general_progress.text = "$mCurrentPosition" + "/" + 5
        tv_general_materi.text = generalMateri!!.materi
        general_category_bottom_image.setImageResource(generalMateri.categoryImage)

    }

    override fun onClick(v: View?) {
        var btn_lanjut = findViewById<Button>(R.id.btn_lanjut)
        var btn_kembali = findViewById<Button>(R.id.btn_kembali)
        btn_lanjut.setEnabled(true)
        btn_kembali.setEnabled(true)

        when(v?.id) {
            R.id.btn_lanjut ->{
                mCurrentPosition ++
                when {
                    mCurrentPosition <= mGeneralMaterisList!!.size -> {
                        setGeneralMateri()
                    }
                    else -> {
                        val intent = Intent(this, DashboardMateriActivity::class.java)
                        intent.putExtra(Constants.CATEGORY, mCategory)
                        intent.putExtra(Constants.USERNAME, mUsername)
                        intent.putExtra("materi_total", mGeneralMaterisList!!.size)
                        startActivity(intent)
                    }
                }
            }
            R.id.btn_kembali ->{
                mCurrentPosition --
                when {
                    mCurrentPosition <= 0 -> {
                        val intent = Intent(this, DashboardMateriActivity::class.java)
                        intent.putExtra(Constants.CATEGORY, mCategory)
                        intent.putExtra(Constants.USERNAME, mUsername)
                        intent.putExtra("materi_total", mGeneralMaterisList!!.size)
                        startActivity(intent)
                    }
                    else -> {
                        setGeneralMateri()
                    }
                }
            }
        }
    }
}