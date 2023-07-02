package com.example.zap

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.util.Log
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class VideoPembelajaranActivity : AppCompatActivity() {
    private var mUsername: String? = null
    private var mCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembelajaran)
        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mUsername = intent.getStringExtra(Constants.USERNAME)
        mCategory = intent.getStringExtra(Constants.CATEGORY)
        val videoView = findViewById<VideoView>(R.id.video)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        val urlOffline = Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.video_pembelajaran)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(urlOffline)
        videoView.requestFocus()
        videoView.start()
        findViewById<BottomNavigationView>(R.id.bottomNavigationViewBelajar).setOnNavigationItemSelectedListener  {
            when(it.itemId) {
                R.id.back -> {
                    val intent = Intent(this, DashboardActivity::class.java)
                    intent.putExtra(Constants.USERNAME, mUsername)
                    intent.putExtra(Constants.CATEGORY, mCategory)
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

//    override fun onClick(v: View?) {
//        findViewById<BottomNavigationView>(R.id.bottomNavigationViewBelajar).setOnNavigationItemSelectedListener  {
//            when(it.itemId) {
//                R.id.quiz -> {
//                    val intent = Intent(this, DashboardMateriActivity::class.java)
//                    intent.putExtra(Constants.USERNAME, mUsername)
//                    intent.putExtra(Constants.CATEGORY, mCategory)
//                    startActivity(intent);
//                    finish();
//                    true
//                }
//                else ->{
//                    false
//                }
//            }
//        }
//    }
}