package com.example.groupproject

import java.util.LinkedList
import kotlin.random.Random

class SnakeGrid(private val rows: Int, private val cols: Int) {
    private val grid = Array(rows) { _ -> Array(cols) { _ -> 0 } }
    private val snake = LinkedList<Pair<Int, Int>>()

    init {
        snake.addFirst(Pair(0, 0))
        makeApple()
    }

    var currDirection = Direction.Right
    var gameOver = false

    fun update(): Array<Array<Int>> {
        val snakeHead = snake.first
        val newHead = when (currDirection) {
            Direction.Left -> Pair(snakeHead.first - 1, snakeHead.second)
            Direction.Up -> Pair(snakeHead.first, snakeHead.second - 1)
            Direction.Right -> Pair(snakeHead.first + 1, snakeHead.second)
            Direction.Down -> Pair(snakeHead.first, snakeHead.second + 1)
        }
        snake.addFirst(newHead)

        if (headCrashed()) {
            gameOver = true
            return grid
        }

        if (eatenApple()) {
            makeApple()
        } else {
            val tail = snake.removeLast()
            grid[tail.second][tail.first] = 0
        }

        grid[newHead.second][newHead.first] = 1
        return grid
    }

    private fun headCrashed(): Boolean {
        val head = snake.first
        return head.first !in 0 ..< cols || head.second !in 0 ..< rows || grid[head.second][head.first] == 1
    }

    private fun eatenApple(): Boolean {
        val head = snake.first
        if (grid[head.second][head.first] == 2) {
            grid[head.second][head.first] == 1
            return true
        }
        return false
    }

    private fun makeApple(){
        var ap = Apple()
        while (grid[ap.y][ap.x] != 0) {
            ap = Apple()
        }
        grid[ap.y][ap.x] = 2
    }

    inner class Apple{
        val x: Int = Random.nextInt(0, cols)
        var y: Int = Random.nextInt(0, rows)
    }

    companion object {
        enum class Direction {
            Left, Up, Right, Down
        }
    }
}