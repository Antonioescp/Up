package com.pglabs.canvastest.model

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap

class Sprite(private var ctx: Context) {
    private var image: Drawable? = null

    val height
    get() = image?.intrinsicHeight

    val width
    get() = image?.intrinsicWidth

    fun set(id: Int) {
        image = ContextCompat.getDrawable(ctx, id)

        if (image == null) {
            println("Couldn't set sprite")
        }
    }

    fun draw(position: Vector2, canvas: Canvas?) {
        image?.setBounds(
            position.x.toInt() - width!!.toInt(),
            position.y.toInt() - height!!.toInt(),
            position.x.toInt() + width!!.toInt(),
            position.y.toInt() + height!!.toInt(),
        )
        image?.draw(canvas!!)
    }
}