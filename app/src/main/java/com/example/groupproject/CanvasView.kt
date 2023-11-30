package com.example.groupproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class CanvasView(context: Context,rows: Int, cols: Int): View(context) {
    var paint = Paint()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.BLACK
        canvas.drawRect(0f,0f, super.getWidth().toFloat(),super.getHeight().toFloat(),paint)
    }
}