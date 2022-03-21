package com.pglabs.canvastest

import android.content.Context
import android.graphics.*
import android.media.metrics.Event
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.core.view.MotionEventCompat
import com.pglabs.canvastest.model.EventBus
import com.pglabs.canvastest.model.Game

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val gameView = Game(this)
        gameView.initialize()

        super.onCreate(savedInstanceState)
        setContentView(gameView)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                EventBus.raise()
                true
            }
            else -> super.onTouchEvent(event)
        }
    }
}