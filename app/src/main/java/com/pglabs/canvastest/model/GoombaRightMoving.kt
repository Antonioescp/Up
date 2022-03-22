package com.pglabs.canvastest.model

<<<<<<< HEAD:app/src/main/java/com/pglabs/canvastest/model/GoombaRightMoving.kt
class GoombaRightMoving(ownerGame: Game) : Actor(ownerGame) {
    var movementSpeed = 100.0f
=======
import kotlin.random.Random

class goombaRightMoving(ownerGame: Game, private val floor: Floor) : Actor(ownerGame) {
    val baseMovementSpeed = 1000.0f
    var movementSpeed = baseMovementSpeed
>>>>>>> 69e20601350aa98916e5538bb92f3d4076bea07a:app/src/main/java/com/pglabs/canvastest/model/goombaRightMoving.kt

    override fun start() {
        super.start()

        position.x = 0.0f
        position.y = floor.position.y
    }

    override fun update() {
        super.update()

<<<<<<< HEAD:app/src/main/java/com/pglabs/canvastest/model/GoombaRightMoving.kt
        if(position.x == game.width.toFloat()) position.x = 0.0f
=======
        if(position.x >= game.width.toFloat()){
            position.x = 0.0f

            movementSpeed = (Random.nextFloat() + 0.5f) * baseMovementSpeed
        }
>>>>>>> 69e20601350aa98916e5538bb92f3d4076bea07a:app/src/main/java/com/pglabs/canvastest/model/goombaRightMoving.kt

        var direction = Vector2(game.width.toFloat(), 0.0f)
        position += direction.normalized() * movementSpeed * game.deltaTime
    }
}