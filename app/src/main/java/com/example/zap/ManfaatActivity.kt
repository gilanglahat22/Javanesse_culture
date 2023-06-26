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

class ManfaatActivity : AppCompatActivity(), View.OnClickListener {
    private var mUsername: String? = null
    private var mCategory: String? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manfaat)

        //Make the View FullScreen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mUsername = intent.getStringExtra(Constants.USERNAME)
        mCategory = intent.getStringExtra(Constants.CATEGORY)
        var text1 = findViewById<TextView>(R.id.manfaat_text1)
        var text2 = findViewById<TextView>(R.id.manfaat_text2)
        var text3 = findViewById<TextView>(R.id.manfaat_text3)
        var text4 = findViewById<TextView>(R.id.manfaat_text4)
        var text5 = findViewById<TextView>(R.id.manfaat_text5)
        var text6 = findViewById<TextView>(R.id.manfaat_text6)
        var text7 = findViewById<TextView>(R.id.manfaat_text7)
        text1.text = "Manfaat menjaga keberagaman suku dan budaya:";
        text2.text = "1. Sebagai identitas bangsa kepada dunia internasional ";
        text3.text = "2. Sebagai simbol pariwisata yang menarik";
        text4.text = "3. Sebagai mata pencaharian warga setempat";
        text5.text = "4. Menambah pendapatan negara";
        text6.text = "5. Menambah sikap toleransi          ";
        text7.text = "6. Menambah wawasan                  ";

        var btn_back = findViewById<Button>(R.id.btn_back)
        btn_back.setOnClickListener(this)
        btn_back.setEnabled(true)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_back ->{
                val intent = Intent(this,DashboardMateriActivity::class.java)
                intent.putExtra(Constants.CATEGORY, "Manfaat")
                intent.putExtra(Constants.USERNAME, mUsername)
                startActivity(intent);
                finish();
            }
        }
    }
}