package com.pglabs.canvastest.model

class MovingSpriteActorExample(ownerGame: Game) : Actor(ownerGame) {
    var movementSpeed = 100.0f

    override fun start() {
        super.start()

        position.y = game.canvas?.height!!.toFloat()
    }

    override fun update() {
        super.update()

        var direction = Vector2(game.width.toFloat(), -game.height.toFloat())
        position += direction.normalized() * movementSpeed * game.deltaTime
    }
}