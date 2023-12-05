package com.example.groupproject

import java.util.TimerTask

class GameTimerTask: TimerTask {
    private val activity: SnakeActivity
    constructor(activity: SnakeActivity) {
        this.activity = activity
    }

    override fun run() {
        this.activity.updateGame()
    }
}