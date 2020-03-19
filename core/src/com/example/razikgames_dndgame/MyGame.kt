package com.example.razikgames_dndgame

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.utils.viewport.FitViewport








object viewport : FitViewport(AppConstants.APP_WIDTH, AppConstants.APP_HEIGHT)
var currentScreen: Screen
    get() = (Gdx.app.applicationListener as Game).screen
    set(value) {
        (Gdx.app.applicationListener as Game).screen = value
    }


object AppConstants {
    const val APP_WIDTH = 1080f
    const val APP_HEIGHT = 1920f
    const val PADDING = 20f
    val ScreenWidth = Gdx.graphics.getWidth()
    val ScreenHeight = Gdx.graphics.getHeight()
}

open class MyGame : Game(), ApplicationListener {

    override fun create() {
        //assets = Assets()
        currentScreen = LoadingScreen(viewport)
    }



    //val viewport: FitViewport = FitViewport(AppConstants.APP_WIDTH, AppConstants.APP_HEIGHT)

    /*private lateinit var batch: SpriteBatch
    private lateinit var img: Texture
    override fun create() {
        screen = LoadingScreen(viewport)
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(img, 0f, 0f)
        batch.end()
    }*/


    override fun dispose() {
        currentScreen.dispose()

    }
}




