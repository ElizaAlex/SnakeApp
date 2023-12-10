package com.example.groupproject

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlin.math.pow
import kotlin.math.sqrt

class CanvasView(context: Context, private val rows: Int, private val cols: Int, private val width: Float, private val height: Float): View(context), View.OnTouchListener {

    init {
        this.setOnTouchListener(this)
    }

    val grid: SnakeGrid = SnakeGrid(rows, cols)
    val snakeColor = Color.GREEN

    private val paint = Paint()
    private val controlHeight = height * 0.7f
    private val controlRadius = 100f
    private val leftCenter = Pair(width * 0.25f, (controlHeight + height) / 2f)
    private val upCenter = Pair(width / 2f, (controlHeight + height - 250f) / 2f)
    private val rightCenter = Pair(width * 0.75f, (controlHeight + height) / 2f)
    private val downCenter = Pair(width / 2f, (controlHeight + height + 250f) / 2f)
    private val cellWidth = width / cols
    private val cellHeight = controlHeight / rows

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.BLACK
        canvas.drawRect(0f,0f,  width, height, paint)
        paint.color = Color.parseColor("#2b2b2b")
        canvas.drawRect(0f, controlHeight, width, height, paint)
        val drawGrid = grid.update()
        for (i in 0..< rows) {
            for (j in 0 ..< cols) {
                paint.color = if (drawGrid[i][j] == 2) Color.RED else snakeColor
                if (drawGrid[i][j] != 0) {
                    canvas.drawRect(cellWidth * j, cellHeight * i, cellWidth * (j+1), cellHeight * (i+1), paint)
                }
            }
        }

        paint.color = Color.MAGENTA
        canvas.drawCircle(leftCenter.first, leftCenter.second, controlRadius, paint)
        canvas.drawCircle(upCenter.first, upCenter.second, controlRadius, paint)
        canvas.drawCircle(rightCenter.first, rightCenter.second, controlRadius, paint)
        canvas.drawCircle(downCenter.first, downCenter.second, controlRadius, paint)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        if (event?.action != MotionEvent.ACTION_DOWN) {
            return false
        }
        val x = event.x
        val y = event.y

        if (sqrt((x - leftCenter.first).pow(2) + (y - leftCenter.second).pow(2)) < controlRadius) {
            this.grid.currDirection = SnakeGrid.Companion.Direction.Left
        } else if (sqrt((x - upCenter.first).pow(2) + (y - upCenter.second).pow(2)) < controlRadius) {
            this.grid.currDirection = SnakeGrid.Companion.Direction.Up
        } else if (sqrt((x - rightCenter.first).pow(2) + (y - rightCenter.second).pow(2)) < controlRadius) {
            this.grid.currDirection = SnakeGrid.Companion.Direction.Right
        } else if (sqrt((x - downCenter.first).pow(2) + (y - downCenter.second).pow(2)) < controlRadius) {
            this.grid.currDirection = SnakeGrid.Companion.Direction.Down
        }

        return false
    }
}