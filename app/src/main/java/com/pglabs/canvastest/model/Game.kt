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

    private var hasInitializedActors = false

    private var skyStars = Sprite(context)
    private var skyStarsPosition = Vector2()

    fun initialize() {
        paint = Paint()
        setBackgroundResource(R.drawable.background)

        skyStars.set(R.drawable.sky_stars)

        val floor = Floor(this)
        val player = Player(this, floor)

        gameActors.add(floor)
        gameActors.add(player)
    }

    override fun onDraw(canvas: Canvas) {
        this.canvas = canvas

        if (!hasInitializedActors) {
            gameActors.forEach {
                it.start()
            }

            skyStarsPosition.x = canvas.width.toFloat() / 2.0f / 0.05f
            skyStarsPosition.y = canvas.height.toFloat() / 4.0f / 0.1f
            hasInitializedActors = true
        }

        update()

        canvas.save()
        canvas.scale(0.1f, 0.1f)
        skyStars.draw(skyStarsPosition, canvas)
        canvas.restore()

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
}