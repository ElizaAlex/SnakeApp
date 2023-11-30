package com.example.groupproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

public val ROWS = 10
public val COLS = 10
class CanvasView(context: Context,rows: Int, cols: Int): View(context) {
    var paint = Paint()
    var grid: SnakeGrid = SnakeGrid(ROWS,COLS)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.BLACK
        canvas.drawRect(0f,0f, super.getWidth().toFloat(),super.getHeight().toFloat(),paint)
        grid.update()
        var tail: Snake.Segment = grid.getSnake()
        var (appleX,appleY) = grid.getApple()

        //TODO - Draw the apple
        while(tail.prev != null){
            //TODO - Draw the snake
        }


    }
}