package com.example.zap

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class SplashActivity : AppCompatActivity() {
    var videoView: VideoView? = null
    var btnNextActivity: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(1)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_splash)

        videoView = findViewById(R.id.videoView)

        val path = "android.resource://" + packageName + "/" + R.raw.opening_video
        val uri = Uri.parse(path)
        videoView!!.setVideoURI(uri)
        videoView!!.start()

        videoView!!.setOnCompletionListener {
            if (isFinishing) {
                true
            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}