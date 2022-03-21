package com.pglabs.canvastest.model

import android.graphics.Color
import android.graphics.Path
import androidx.core.content.ContextCompat
import com.pglabs.canvastest.R
import android.graphics.Paint.*
import android.graphics.Typeface
import android.graphics.Path.*

class RemainingPrimitives(ownerGame: Game) : Actor(ownerGame) {
    private val path = Path()
    private val cloudPath = Path()

    private var elapsedTime = 0.0f
    private var targetTime = 5.0f

    override fun update() {
        super.update()

        if (elapsedTime <= targetTime) {
            elapsedTime += game.deltaTime
        }
    }

    override fun draw() {
        super.draw()

        if (elapsedTime < targetTime) {


            game.paint.color = ContextCompat.getColor(game.context, R.color.primitives)

            drawRoundRect()

            game.canvas?.save()
            game.canvas?.translate(25.0f, 100.0f)
            game.canvas?.rotate(45.0f)
            game.canvas?.scale(0.5f, 0.5f)

            drawRoundRect()

            game.canvas?.restore()

            game.canvas?.save()
            game.canvas?.translate(40.0f, 200.0f)
            game.canvas?.rotate(90.0f)
            game.canvas?.scale(0.45f, 0.45f)

            drawRoundRect()

            game.canvas?.restore()

            game.paint.color = Color.BLACK
            game.paint.strokeWidth = 10.0f
            drawPoints()
            drawLine()

            game.paint.color = Color.WHITE
            game.paint.style = Style.FILL_AND_STROKE
            game.paint.textSize = 50.0f
            game.paint.typeface = Typeface.MONOSPACE

            drawPath()

            game.paint.color = Color.WHITE
            game.paint.style = Style.FILL
            game.paint.strokeWidth = 0.0f

            game.canvas?.save()

            game.canvas?.translate(game.width / 2.0f, game.height / 4.0f)
            drawCloud()

            game.canvas?.restore()
        }
    }

    private fun drawRoundRect() {
        game.canvas?.drawRoundRect(
            15.0f,
            15.0f,
            115.0f,
            75.0f,
            10.0f,
            10.0f,
            game.paint
        )
    }

    private fun drawPoints() {
        game.canvas?.drawPoints(floatArrayOf(
            40.0f,
            300.0f,
            40.0f,
            400.0f,
            40.0f,
            500.0f
        ), game.paint)
    }

    private fun drawLine() {
        game.canvas?.drawLine(
            40.0f,
            550.0f,
            40.0f,
            600.0f,
            game.paint
        )
    }

    private fun drawPath() {
        path.moveTo(40.0f, 625.0f)
        path.cubicTo(
            95.0f,
            675.0f,
            95.0f,
            675.0f,
            400.0f,
            625.0f
        )
        game.canvas?.drawTextOnPath(
            "Salta!",
            path,
            0.0f,
            0.0f,
            game.paint
        )
    }

    private fun drawCloud() {
        cloudPath.addCircle(
            0.0f,
            0.0f,
            75.0f,
            Direction.CW
        )

        cloudPath.addCircle(
            75.0f,
            0.0f,
            75.0f,
            Direction.CW
        )

        cloudPath.addCircle(
            37.5f,
            -75.0f,
            75.0f,
            Direction.CW
        )

        game.canvas?.drawPath(cloudPath, game.paint)
    }
}