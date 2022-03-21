package com.pglabs.canvastest.model

class goombaRightMoving(ownerGame: Game) : Actor(ownerGame) {
    var movementSpeed = 100.0f

    override fun start() {
        super.start()

        position.x = 0.0f
        position.y = game.height.toFloat() - 250.0f
    }

    override fun update() {
        super.update()

        if(position.x == game.width.toFloat()){
            position.x = 0.0f
        }

        var direction = Vector2(game.width.toFloat(), 0.0f)
        position += direction.normalized() * movementSpeed * game.deltaTime
    }
}