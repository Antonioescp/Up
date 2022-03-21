package com.pglabs.canvastest.model

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import com.pglabs.canvastest.R

class Game(context: Context): View(context) {

    private val gameActors = mutableListOf<Actor>()
    private var time: Long = System.currentTimeMillis()
    var deltaTime: Float = 0.0f
    private set

    var canvas: Canvas? = null
    private set

    lateinit var paint: Paint
    private set

    fun initialize() {
        paint = Paint()

        var movingRing = MovingSpriteActorExample(this)
        movingRing.sprite = R.drawable.anillitos

        gameActors.add(movingRing)
    }

    override fun onDraw(canvas: Canvas) {
        this.canvas = canvas

        update()
        draw()

        this.invalidate()
    }

    private fun handleInput(): Nothing = TODO()

    private fun update() {
        val currentTime: Long = System.currentTimeMillis()
        deltaTime = (currentTime - time) / 1000.0f
        time = currentTime

        gameActors.forEach {
            it.update()
        }
    }

    private fun draw() {
        gameActors.forEach {
            it.draw()
        }
    }
}