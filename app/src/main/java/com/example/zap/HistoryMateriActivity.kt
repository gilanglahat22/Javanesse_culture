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

class HistoryMateriActivity: AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mHistoryMaterisList: ArrayList<Materi>? = null
    private var mUsername: String? = null
    private var mCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_materi)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUsername = intent.getStringExtra(Constants.USERNAME)
        mCategory = intent.getStringExtra(Constants.CATEGORY)

        mHistoryMaterisList = Constants.historyMateris()

        setHistoryMateri()

        var btn_lanjut = findViewById<Button>(R.id.btn_lanjut)
        var btn_kembali = findViewById<Button>(R.id.btn_kembali)
        btn_lanjut.setOnClickListener(this)
        btn_kembali.setOnClickListener(this)
        btn_kembali.setEnabled(true)
        btn_lanjut.setEnabled(true)
    }

    private fun setHistoryMateri() {

        val historyMateri = mHistoryMaterisList!![mCurrentPosition-1]

        var btn_lanjut = findViewById<Button>(R.id.btn_lanjut)
        var btn_kembali = findViewById<Button>(R.id.btn_kembali)

        if (mCurrentPosition == mHistoryMaterisList!!.size) {
            btn_lanjut.text = "Selesai"
        } else {
            btn_lanjut.text = "Lanjut"
        }

        btn_kembali.text = "Kembali"

        var history_progressbar = findViewById<ProgressBar>(R.id.history_progressbar)
        var tv_history_progress = findViewById<TextView>(R.id.tv_history_progress)
        var tv_history_materi = findViewById<TextView>(R.id.tv_history_materi)
        var history_category_bottom_image = findViewById<ImageView>(R.id.history_category_bottom_image)

        history_progressbar.progress = mCurrentPosition
        tv_history_progress.text = "$mCurrentPosition" + "/" + 8
        tv_history_materi.text = historyMateri!!.materi
        history_category_bottom_image.setImageResource(historyMateri.categoryImage)

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
                    mCurrentPosition <= mHistoryMaterisList!!.size -> {
                        setHistoryMateri()
                    }
                    else -> {
                        val intent = Intent(this, DashboardMateriActivity::class.java)
                        intent.putExtra(Constants.CATEGORY, mCategory)
                        intent.putExtra(Constants.USERNAME, mUsername)
                        intent.putExtra("materi_total", mHistoryMaterisList!!.size)
                        startActivity(intent);
                        finish();
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
                        intent.putExtra("materi_total", mHistoryMaterisList!!.size)
                        startActivity(intent);
                        finish();
                    }
                    else -> {
                        setHistoryMateri()
                    }
                }
            }
        }
    }
}