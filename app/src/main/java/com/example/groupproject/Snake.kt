package com.example.groupproject

class Snake(var rows: Int, var cols: Int) {
    var head: Segment = Segment(rows/2,cols/2)
    var tail = head
    var direction: Int = 0
    var set: HashSet<Pair<Int,Int>> = HashSet()
    private var fed: Boolean = false

    inner class Segment(var x: Int, var y: Int){
        var prev: Segment? = null
        fun isOutOfBounds(): Boolean{
            return (x !in 0..cols || y !in 0..rows)
        }
    }
    fun feed(){
        fed=true
    }

    fun update(): Boolean{

        var node : Segment = tail
        if (fed){
            var temp: Segment = Segment(tail.x,tail.y)
            temp.prev=tail
            tail=temp
            fed=false

        }
        while(node.prev != null){
            var prev = node.prev!!
            node.x = prev.x
            node.y = prev.y
            set.add(Pair(node.x,node.y))
        }

        when(direction){
            0->head.x-=1
            1->head.y-=1
            2->head.x+=1
            3->head.y+=1
            else -> throw Exception("Invalid Direction")
        }
        return set.contains(Pair(head.x,head.y)) || head.isOutOfBounds()
    }

    fun turn(dir: Int): Unit{
        if(dir !in 0..3){
            direction=dir
        } else{
            throw Exception("Invalid Direction")
        }
    }
    fun nextLoc(): Pair<Int,Int>{
        var x: Int=head.x
        var y: Int = head.y
        when(direction){
            0->x-=1
            1->y-=1
            2->x+=1
            3->y+=1
            else -> throw Exception("Invalid Direction")
        }
        return Pair(x,y)
    }
    fun contains(coords: Pair<Int,Int>): Boolean{
        return set.contains(coords)
    }
}