package com.pglabs.canvastest.model

import android.graphics.Canvas

open class Actor(val game: Game) {
    var position = Vector2()
    var scale = Vector2()
    var rotation = Vector2()

    open fun update() {}
    open fun draw() {}
}