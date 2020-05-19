package com.example.razikgames_dndgame


import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.utils.viewport.FitViewport
import com.example.razikgames_dndgame.AppConstants.ScreenHeight
import com.example.razikgames_dndgame.AppConstants.ScreenWidth


object viewport : FitViewport(ScreenWidth *1f, ScreenHeight *1f)
var currentScreen: Screen
    get() = (Gdx.app.applicationListener as Game).screen
    set(value) {
        (Gdx.app.applicationListener as Game).screen = value
    }


object AppConstants {
    const val APP_WIDTH = 1080f
    const val APP_HEIGHT = 1920f
    const val PADDING = 20f
    var ScreenWidth = Gdx.graphics.getWidth()
    var ScreenHeight = Gdx.graphics.getHeight()
    var char1 = 0
    var char2 = 0
    var char3 = 0
    var char4 = 0
    var char5 = 0
}


object Fonts {
    val FONT_CHARS = "абвгдежзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>"
    fun getFont1(width: Float): BitmapFont {
        lateinit var font1:BitmapFont
        val FONT_PATH = "Segoe.ttf"
        val generator = FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH))
        val parameter = FreeTypeFontParameter()
        parameter.characters = FONT_CHARS
        parameter.size = width.toInt()
        parameter.color = Color.valueOf("ffffdc")
        font1 = generator.generateFont(parameter)
        generator.dispose()
        return font1
    }
    fun getFont1_grey(width: Float): BitmapFont {
        lateinit var font1:BitmapFont
        val FONT_PATH = "Segoe.ttf"
        val generator = FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH))
        val parameter = FreeTypeFontParameter()
        parameter.characters = FONT_CHARS
        parameter.size = width.toInt()
        //parameter.color = Color(125f, 125f, 125f, 1f)
        font1 = generator.generateFont(parameter)
        generator.dispose()
        return font1
    }
}

open class MyGame(test: ITest) : Game(), ApplicationListener {
    private val test: ITest
    init {
        this.test = test
    }

    var character1: Person? = null
    var character2: Person? = null
    var character3: Person? = null
    var character4: Person? = null
    var character5: Person? = null

    fun test2(): String {
        val a = MyGame(test)
        return a.test.submitVar().toString()

    }

    override fun create() {
        //assets = Assets()
        currentScreen = ScreenManager("load")
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






