package com.pglabs.canvastest.model

import kotlin.random.Random

class goombaRightMoving(ownerGame: Game, private val floor: Floor) : Actor(ownerGame) {
    val baseMovementSpeed = 1000.0f
    var movementSpeed = baseMovementSpeed

    override fun start() {
        super.start()

        position.x = 0.0f
        position.y = floor.position.y
    }

    override fun update() {
        super.update()

        if(position.x >= game.width.toFloat()){
            position.x = 0.0f

            movementSpeed = (Random.nextFloat() + 0.5f) * baseMovementSpeed
        }

        var direction = Vector2(game.width.toFloat(), 0.0f)
        position += direction.normalized() * movementSpeed * game.deltaTime
    }
}