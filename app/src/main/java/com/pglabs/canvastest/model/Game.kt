package com.pglabs.canvastest.model

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import android.widget.Toast
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

    private var hasInitializedActors = false

    fun initialize() {
        EventBus.addListener(::handleInput)

        paint = Paint()
        setBackgroundResource(R.drawable.background)

        val floor = Floor(this)

        gameActors.add(floor)
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

    private fun handleInput() {
        Toast.makeText(context, "ActionWasMoved", Toast.LENGTH_SHORT).show()
    }
}