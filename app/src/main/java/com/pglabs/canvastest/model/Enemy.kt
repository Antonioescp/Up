package com.pglabs.canvastest.model

import com.pglabs.canvastest.R
import kotlin.random.Random

class Enemy(ownerGame: Game, private val floor: Floor) : Actor(ownerGame) {
    var movementSpeed = 0.0f
    var direction = 1.0f
    val baseMovementSpeed = 800.0f

    var elapsedTime = 0.0f
    var targetTime = 5.0f

    val colliderRadius = 140.0f

    var animationElapsedTime = 0.0f
    var animationTargetTime = 0.25f
    var targetSprite = 0
    var sprites = listOf(R.drawable.goombaderecha, R.drawable.goombaizquierda)

    override fun start() {
        super.start()
        sprite = sprites[targetSprite]

        movementSpeed = baseMovementSpeed

        position.y = floor.position.y - 50.0f
        position.x = 0.0f
    }

    override fun update() {
        super.update()

        animationElapsedTime += game.deltaTime
        if (animationElapsedTime >= animationTargetTime) {
            sprite = sprites[targetSprite]
            targetSprite = if (targetSprite == 0) 1 else 0
            animationElapsedTime = 0.0f
        }

        if (elapsedTime >= targetTime) {

            if (position.x > game.canvas!!.width || position.x < 0.0f) {
                var rol = Random.nextFloat()

                movementSpeed = (rol + 0.5f) * baseMovementSpeed

                if (rol > 0.5f) {
                    position.x = 0.0f
                    direction = 1.0f
                } else {
                    position.x = game.canvas!!.width.toFloat()
                    direction = -1.0f
                }
            }

            position.x += direction * movementSpeed * game.deltaTime

        } else {
            elapsedTime += game.deltaTime
        }
    }
}