package com.example.groupproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pref = getSharedPreferences("SnakeGame", Context.MODE_PRIVATE)
        findViewById<TextView>(R.id.highscore).text = "High Score: ${pref.getInt("hiscore",0)}"
    }

    fun changeScreen(v: View){
        val snakeIntent = Intent(this, SnakeActivity::class.java)
        this.startActivity(snakeIntent)
    }
}