package com.pglabs.canvastest.model

import com.pglabs.canvastest.R

class Player(ownerGame: Game, private val floor: Floor) : Actor(ownerGame) {
    private val gravity = Vector2(0.0f, 9.81f)
    private val gravityScale = 250.0f

    private var acceleration = Vector2()
    private var velocity = Vector2()
    private var mass = 0.5f

    private var isGrounded = false

    private var offset = -70.0f

    override fun start() {
        super.start()

        EventBus.addListener(::onTouchActionDown)

        sprite = R.drawable.player

        position.y = game.height / 2.0f
        position.x = game.width / 2.0f

        addForce(gravity * gravityScale)
    }

    override fun update() {
        super.update()

        velocity += acceleration * game.deltaTime
        position += velocity * game.deltaTime

        if (position.y >= floor.position.y + offset) {
            isGrounded = true
            acceleration = Vector2()
            velocity = Vector2()

            position.y = floor.position.y + offset

            sprite = R.drawable.player
        } else {
            sprite = R.drawable.player_jump
            isGrounded = false
        }
    }

    private fun onTouchActionDown() {
        if (isGrounded) {
            jump()
            addForce(gravity * gravityScale)
        }
    }

    private fun jump() {
        velocity.y = -8.0f * gravityScale
    }

    private fun addForce(force: Vector2) {
        acceleration += force / mass
    }
}