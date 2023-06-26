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
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    private var mUsername: String? = null
    private var mCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mUsername = intent.getStringExtra(Constants.USERNAME)
        mCategory = intent.getStringExtra(Constants.CATEGORY)

        var btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener(this)
        btn_back.setEnabled(true)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_back ->{
                val intent = Intent(this,DashboardMateriActivity::class.java)
                intent.putExtra(Constants.CATEGORY, "Profile Pengembang")
                intent.putExtra(Constants.USERNAME, mUsername)
                startActivity(intent);
                finish();
            }
        }
    }
}