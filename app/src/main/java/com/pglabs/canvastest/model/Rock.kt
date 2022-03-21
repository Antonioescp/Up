package com.pglabs.canvastest.model

import com.pglabs.canvastest.R

class Rock(ownerGame: Game, private val floor: Floor) : Actor(ownerGame) {

    private var backgroundRock = Sprite(game.context)
    private var backgroundRockPosition = Vector2()
    private var rockScaleFactor = 0.10f

    override fun start() {
        super.start()

        backgroundRock.set(R.drawable.rockbg)
        backgroundRockPosition.x = floor.position.x / rockScaleFactor
        backgroundRockPosition.y = floor.position.y / rockScaleFactor
    }

    override fun draw() {
        // Piedras en el suelo
        game.canvas?.save()
        game.canvas?.scale(rockScaleFactor, rockScaleFactor)

        backgroundRock.draw(backgroundRockPosition, game.canvas)
        backgroundRock.draw(
            backgroundRockPosition + Vector2(game.width.toFloat(), 0.0f) / rockScaleFactor,
            game.canvas
        )

        game.canvas?.restore()
    }
}