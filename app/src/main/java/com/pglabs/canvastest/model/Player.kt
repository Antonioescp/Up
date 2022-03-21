package com.pglabs.canvastest.model

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import com.pglabs.canvastest.R

class Player(ownerGame: Game, private val floor: Floor, private val enemy: Enemy) : Actor(ownerGame) {
    private val gravity = Vector2(0.0f, 9.81f)
    private val gravityScale = 250.0f

    private var acceleration = Vector2()
    private var velocity = Vector2()
    private var mass = 0.5f

    private var isGrounded = false
    private var isDead = false

    private var offset = -70.0f

    private var score = 0

    private enum class State {
        Alive,
        Dead
    }

    private var currentState = State.Alive

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

        when (currentState) {
            State.Alive -> {

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

                if (position.distanceTo(enemy.position) <= enemy.colliderRadius) {
                    currentState = State.Dead
                }
            }
        }
    }

    override fun draw() {
        super.draw()

        game.paint.style = Paint.Style.FILL_AND_STROKE
        game.paint.strokeWidth = 1.0f
        game.paint.textSize = 100.0f
        game.paint.typeface = Typeface.MONOSPACE
        game.paint.color = Color.DKGRAY

        game.canvas?.drawText(
            "Score: $score",
            100.0f,
            150.0f,
            game.paint
        )

        if (currentState == State.Dead) {
            game.canvas?.drawText(
                "Has perdido",
                225.0f,
                game.height / 2.0f,
                game.paint
            )
        }
    }

    private fun onTouchActionDown() {
        if (isGrounded && currentState == State.Alive) {
            jump()
            addForce(gravity * gravityScale)
            score++
        }
    }

    private fun jump() {
        velocity.y = -8.0f * gravityScale
    }

    private fun addForce(force: Vector2) {
        acceleration += force / mass
    }
}