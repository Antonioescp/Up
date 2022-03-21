package com.pglabs.canvastest.model

open class Actor(val game: Game) {
    var position = Vector2()

    private var drawable = Sprite(game.context)

    var sprite: Int = 0
        get() {
            return field
        }
        set(value) {
            drawable.set(value)
            field = value
        }

    open fun start() { }
    open fun update() {}
    open fun draw() {
        drawable.draw(position, game.canvas)
    }
}