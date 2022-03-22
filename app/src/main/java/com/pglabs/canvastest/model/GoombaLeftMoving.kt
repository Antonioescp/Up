package com.pglabs.canvastest.model

<<<<<<< HEAD:app/src/main/java/com/pglabs/canvastest/model/GoombaLeftMoving.kt
class GoombaLeftMoving(ownerGame: Game) : Actor(ownerGame) {
    var movementSpeed = 100.0f
=======
import kotlin.random.Random

class goombaLeftMoving(ownerGame: Game, private val floor: Floor) : Actor(ownerGame) {
    val baseMovementSpeed = 1000.0f
    private var movementSpeed = baseMovementSpeed
>>>>>>> 69e20601350aa98916e5538bb92f3d4076bea07a:app/src/main/java/com/pglabs/canvastest/model/goombaLeftMoving.kt

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