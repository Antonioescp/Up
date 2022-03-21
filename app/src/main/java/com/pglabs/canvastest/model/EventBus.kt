package com.pglabs.canvastest.model

object EventBus {

    private val handlers = mutableListOf<() -> Unit>()

    fun addListener(listener: () -> Unit) {
        handlers.add(listener)
    }

    fun removeListener(listener: () -> Unit) {
        handlers.remove(listener)
    }

    fun raise() {
        handlers.forEach {
            it()
        }
    }
}