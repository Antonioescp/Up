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
        gameActors.add(floor)

        val enemy = Enemy(this, floor)
        val player = Player(this, floor, enemy)

        gameActors.add(player)
<<<<<<< HEAD

        var goombaLeft = GoombaLeftMoving(this)
        goombaLeft.sprite = R.drawable.goombaizquierda

        var goombaRight = GoombaRightMoving(this)
        goombaRight.sprite = R.drawable.goombaderecha

        gameActors.add(goombaLeft)
        gameActors.add(goombaRight)

=======
        gameActors.add(enemy)

        val rocks = Rock(this, floor)
        gameActors.add(rocks)

        val otherPrimitives = RemainingPrimitives(this)
        gameActors.add(otherPrimitives)
>>>>>>> 69e20601350aa98916e5538bb92f3d4076bea07a
    }

    override fun onDraw(canvas: Canvas) {
        this.canvas = canvas

        if (!hasInitializedActors) {
            gameActors.forEach {
                it.start()
            }

            skyStarsPosition.x = width.toFloat() / 2.0f / 0.05f
            skyStarsPosition.y = height.toFloat() / 4.0f / 0.1f
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