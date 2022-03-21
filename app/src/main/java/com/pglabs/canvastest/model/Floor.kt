package com.pglabs.canvastest.model

import android.graphics.Paint
import androidx.core.content.ContextCompat
import com.pglabs.canvastest.R

class Floor(ownerGame: Game) : Actor(ownerGame) {

    private var width: Float = 0.0f
    private var height: Float = 0.0f

    private var frontGrass = Sprite(game.context)
    private var frontGrassPosition = Vector2()
    private var frontGrassScaleFactor = 0.6f

    override fun start() {
        super.start()
        position.x = 0.0f
        position.y = game.height - game.height / 4.0f

        width = game.width.toFloat()
        height = game.height / 4.0f

        frontGrass.set(R.drawable.grass)
        frontGrassPosition.x = game.width / 2.0f / frontGrassScaleFactor
        frontGrassPosition.y = (game.height.toFloat() - 50.0f) / frontGrassScaleFactor
    }

    override fun draw() {
        // Parte principal del suelo
        game.paint.strokeWidth = 0.0f
        game.paint.style = Paint.Style.FILL
        game.paint.color = ContextCompat.getColor(game.context, R.color.sand_block)

        game.canvas?.drawRect(
            position.x,
            position.y,
            game.width.toFloat(),
            game.height.toFloat(),
            game.paint
        )

        // Pasto en el suelo
        game.canvas?.save()
        game.canvas?.scale(frontGrassScaleFactor, frontGrassScaleFactor)

        frontGrass.draw(frontGrassPosition, game.canvas)

        game.canvas?.restore()
    }
}