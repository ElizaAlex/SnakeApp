package com.example.groupproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.interstitial.InterstitialAd

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val pref = getSharedPreferences("SnakeGame", Context.MODE_PRIVATE)
        val score = pref.getInt("score", 0)

        findViewById<TextView>(R.id.end_score_text).text = "Score: $score"

        val adView = AdView(this)
        val adSize = AdSize(AdSize.FULL_WIDTH, AdSize.AUTO_HEIGHT)
        adView.setAdSize(adSize)
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"

        val adRequest = AdRequest.Builder().build()

        val adLayout = findViewById<LinearLayout>(R.id.ad_view)
        adLayout.addView(adView)

        adView.loadAd(adRequest)
    }
}