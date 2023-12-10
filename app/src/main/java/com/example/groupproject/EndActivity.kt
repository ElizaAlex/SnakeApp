package com.example.groupproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RatingBar
import android.view.View
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.LayerDrawable
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.interstitial.InterstitialAd

class EndActivity : AppCompatActivity() {

    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val pref = getSharedPreferences("SnakeGame", Context.MODE_PRIVATE)
        this.score = pref.getInt("score", 0)

        findViewById<TextView>(R.id.end_score_text).text = "SCORE: $score"

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.rating = 2.5f
        ratingBar.stepSize = .5f

        val changeColor = findViewById<Button>(R.id.changeColor)

        changeColor.setOnClickListener {

            val colorMenu = PopupMenu(this, changeColor)
            colorMenu.menuInflater.inflate(R.menu.color_menu, colorMenu.menu)

            colorMenu.setOnMenuItemClickListener { color ->
                val selected = color.title

                if (selected == "Green") {

                } else if (selected == "Blue") {

                } else if (selected == "Yellow") {

                } else if (selected == "Pink") {

                }

                true

            }

            colorMenu.show()

        }

        val adView = AdView(this)
        val adSize = AdSize(AdSize.FULL_WIDTH, AdSize.AUTO_HEIGHT)
        adView.setAdSize(adSize)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

        val adRequest = AdRequest.Builder().build()

        val adLayout = findViewById<LinearLayout>(R.id.ad_view)
        adLayout.addView(adView)

        adView.loadAd(adRequest)
    }

    fun replay(v: View) {
        val intent = Intent(this, SnakeActivity::class.java)
        this.finish()
        this.startActivity(intent)
        overridePendingTransition(R.anim.zoom_in, R.anim.static_animimation)
    }

    fun email(v: View) {
        val emailIntent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_SUBJECT, "I played Snake!")
            .putExtra(Intent.EXTRA_TEXT, "I got a score of $score!")
            .setType("message/rfc822")
        this.startActivity(Intent.createChooser(emailIntent, "Send score email"))
    }
}