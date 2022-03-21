package com.pglabs.canvastest.model

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.core.content.ContextCompat
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

    var hasInitializedActors = false

    fun initialize() {
        paint = Paint()

        var goombaLeft = goombaLeftMoving(this)
        goombaLeft.sprite = R.drawable.goombaizquierda

        var goombaRight = goombaRightMoving(this)
        goombaRight.sprite = R.drawable.goombaderecha

        gameActors.add(goombaLeft)
        gameActors.add(goombaRight)

        setBackgroundResource(R.drawable.background)
    }

    override fun onDraw(canvas: Canvas) {
        this.canvas = canvas

        if (!hasInitializedActors) {
            gameActors.forEach {
                it.start()
            }
            hasInitializedActors = true
        }

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