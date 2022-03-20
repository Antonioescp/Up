package com.pglabs.canvastest

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pglabs.canvastest.model.Game

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val gameView = Game(this)
        gameView.initialize()

        super.onCreate(savedInstanceState)
        setContentView(gameView)
    }
}