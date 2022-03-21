package com.pglabs.canvastest.model

import android.graphics.Paint
import androidx.core.content.ContextCompat
import com.pglabs.canvastest.R

class Floor(ownerGame: Game) : Actor(ownerGame) {

    override fun start() {
        super.start()
        
    }

    override fun draw() {
        game.paint.strokeWidth = 0.0f
        game.paint.style = Paint.Style.FILL
        game.paint.color = ContextCompat.getColor(game.context, R.color.sand_block)
    }
}