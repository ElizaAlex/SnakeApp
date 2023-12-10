package com.example.groupproject

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.sql.Time
import java.util.Timer

class SnakeActivity : AppCompatActivity() {

    private lateinit var canvasView: CanvasView
    private val timer: Timer = Timer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dispHeight = Resources.getSystem().displayMetrics.heightPixels.toFloat()
        val dispWidth = Resources.getSystem().displayMetrics.widthPixels.toFloat()
        this.canvasView = CanvasView(this, 13, 10, dispWidth, dispHeight)
        this.setContentView(this.canvasView)

        val timerTask = GameTimerTask(this)
        timer.schedule(timerTask, 100L, TIMER_TICK)
    }

    fun updateGame() {
        if (this.canvasView.grid.gameOver) {
            this.finish()
            this.timer.cancel()

            val pref = getSharedPreferences("SnakeGame", Context.MODE_PRIVATE).edit()
            pref.putInt("score", this.canvasView.grid.score())
            pref.commit()

            val intent = Intent(this, EndActivity::class.java)
            this.startActivity(intent)
            overridePendingTransition(R.anim.zoom_in, R.anim.static_animimation)
        }
        this.canvasView.postInvalidate()
    }

    companion object {
        const val TIMER_TICK = 250L
    }
}