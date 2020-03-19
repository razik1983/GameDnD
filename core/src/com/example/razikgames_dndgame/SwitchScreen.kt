package com.example.razikgames_dndgame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage

class SwitchScreen (param: String): ScreenAdapter() {
    lateinit var mainStage: Stage
    init {
        when (param) {
            "menu" -> mainStage = MenuStage()
            "login" -> mainStage = LoginStage()
            else -> LoginStage()
        }
    }
    //lateinit var mainStage: Stage


    //val mainStage = MenuStage()

    override fun hide() {
        Gdx.input.inputProcessor = null
    }
    override fun show() {
        Gdx.input.inputProcessor = mainStage
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        mainStage.act(delta)
        mainStage.draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    /*fun switch (s: String) {
        when (s) {
            "menu" -> mainStage = MenuStage()
            "login" -> mainStage = LoginStage()
            else -> LoginStage()
        }
    }*/

}