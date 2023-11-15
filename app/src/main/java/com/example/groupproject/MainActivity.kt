package com.example.groupproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeScreen(v: View){
        lateinit var myIntent: Intent
        when(v.id){
            R.id.title->{
                myIntent = Intent(this,SnakeActivity::class.java)
                Log.w("MainActivity","Switching to SnakeActivity")
                this.startActivity(myIntent)
            }
            R.id.scoreboard->{
                throw Exception("Not Implemented")
            }
            else ->{
                throw Exception("Not Implemented")
            }
        }
    }
}