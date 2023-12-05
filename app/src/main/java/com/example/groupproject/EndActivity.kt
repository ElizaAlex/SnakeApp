package com.example.groupproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        val pref = getSharedPreferences("SnakeGame", Context.MODE_PRIVATE)
        val score = pref.getInt("score", 0)

        findViewById<TextView>(R.id.end_score_text).text = "Score: $score"
    }
}