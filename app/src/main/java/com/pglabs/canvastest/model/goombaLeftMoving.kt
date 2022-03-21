package com.pglabs.canvastest.model

import kotlin.random.Random

class goombaLeftMoving(ownerGame: Game, private val floor: Floor) : Actor(ownerGame) {
    val baseMovementSpeed = 1000.0f
    private var movementSpeed = baseMovementSpeed

    override fun start() {
        super.start()

        position.x = game.width.toFloat()
        position.y = floor.position.y
    }

    override fun update() {
        super.update()

        if(position.x <= 0.0f){
            position.x = game.width.toFloat()

            movementSpeed = (Random.nextFloat() + 0.5f) * baseMovementSpeed
        }

        var direction = Vector2(-game.width.toFloat(), 0.0f)
        position += direction.normalized() * movementSpeed * game.deltaTime
    }
}