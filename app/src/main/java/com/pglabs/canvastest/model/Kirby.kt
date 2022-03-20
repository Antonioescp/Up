package com.pglabs.canvastest.model

import android.graphics.Canvas
import android.graphics.Color

class Kirby(ownerGame: Game) : Actor(ownerGame) {

    var move = 1.0f

    override fun update() {

    }

    override fun draw() {
        game.paint.color = Color.BLUE
        game.canvas?.drawLine(0.0f, 0.0f, 100.0f, 100.0f + move, game.paint)
        move += 100.0f * game.deltaTime
    }
}