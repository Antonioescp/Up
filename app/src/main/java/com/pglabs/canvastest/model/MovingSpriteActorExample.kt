package com.pglabs.canvastest.model

import android.content.Context

class MovingSpriteActorExample(ownerGame: Game) : Actor(ownerGame) {
    var movementSpeed = 100.0f

    override fun update() {
        super.update()

        var direction = Vector2(game.width.toFloat(), game.height.toFloat())
        position = position + direction.normalized() * movementSpeed * game.deltaTime
    }
}