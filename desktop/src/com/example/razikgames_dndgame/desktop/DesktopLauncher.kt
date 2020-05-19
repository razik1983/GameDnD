package com.example.razikgames_dndgame.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.example.razikgames_dndgame.MyGame


object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.title = "DnD Game"
        config.width = 1080
        config.height = 800
        config.resizable = false
        config.vSyncEnabled = false
        //LwjglApplication(MyGame(), config)
    }
}

