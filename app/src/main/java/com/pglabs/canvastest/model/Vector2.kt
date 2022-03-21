package com.pglabs.canvastest.model

import kotlin.math.sqrt

class Vector2 {

    var x = 0.0f
    var y = 0.0f

    constructor(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

    constructor() {
        this.x = 0.0f
        this.y = 0.0f
    }

    fun magnitude() = sqrt(x * x + y * y)
    fun normalized() = Vector2(x, y) / magnitude()

    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)
    operator fun unaryMinus() = Vector2(-x, -y)
    operator fun minus(other: Vector2) = this + -other
    operator fun div(n: Number) = Vector2(x / n.toFloat(), y / n.toFloat())
    operator fun times(n: Number) = Vector2(x * n.toFloat(), y * n.toFloat())
}