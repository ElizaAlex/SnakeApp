package com.example.groupproject

import kotlin.random.Random

class SnakeGrid(rows: Int, cols: Int) {
    var rows: Int = rows
    var cols: Int = cols
    var snake: Snake = Snake(rows,cols)
    var apple: Apple = makeApple()
    var lost: Boolean = false

    fun getApple(): Pair<Int,Int>{
        return Pair(apple.x,apple.y)
    }
    fun getSnake(): Snake.Segment {
        return snake.tail
    }
    fun update():Unit{
        if (lost) return

        var (x,y) = snake.nextLoc()
        if(x==apple.x && y==apple.y){
            snake.feed()
            apple = makeApple()
        }

        var selfCollide = snake.update()
        lost = selfCollide || snake.head.isOutOfBounds()
    }
    private fun makeApple(): Apple{
        var ap : Apple = Apple(rows,cols)
        while(snake.contains(Pair(ap.x,ap.y))){
            ap = Apple(rows,cols)
        }
        return ap
    }
    inner class Apple{
        var x: Int
        var y: Int
        constructor(rows: Int, cols: Int){
            x=Random.nextInt(0,cols)
            y=Random.nextInt(0,rows)
        }
    }
}