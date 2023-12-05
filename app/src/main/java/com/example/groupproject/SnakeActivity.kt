package com.example.groupproject

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer

class SnakeActivity : AppCompatActivity() {

    private lateinit var canvasView: CanvasView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dispHeight = Resources.getSystem().displayMetrics.heightPixels.toFloat()
        val dispWidth = Resources.getSystem().displayMetrics.widthPixels.toFloat()
        this.canvasView = CanvasView(this, 10, 10, dispWidth, dispHeight)
        this.setContentView(this.canvasView)

        val timer = Timer()
        val timerTask = GameTimerTask(this)
        timer.schedule(timerTask, 100L, TIMER_TICK)
    }

    fun updateGame() {
        this.canvasView.postInvalidate()
    }

    companion object {
        const val TIMER_TICK = 250L
    }
}