package com.example.razikgames_dndgame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.example.razikgames_dndgame.AppConstants.ScreenHeight
import com.example.razikgames_dndgame.AppConstants.ScreenWidth
import com.example.razikgames_dndgame.Stage.createPerson.CreatePersonStage
import com.example.razikgames_dndgame.Stage.LoadingStage
import com.example.razikgames_dndgame.Stage.LoginStage
import com.example.razikgames_dndgame.Stage.MenuStage
import com.example.razikgames_dndgame.Stage.createPerson.GenderStage

class ScreenManager (param: String): ScreenAdapter() {
    lateinit var mainStage: Stage
    init {
        when (param) {
            "menu" -> mainStage = MenuStage()
            "login" -> mainStage = LoginStage()
            "load" -> mainStage = LoadingStage()
            "new" -> mainStage = CreatePersonStage()
            "gender" -> mainStage = GenderStage()

            else -> MenuStage()
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
        viewport.update(ScreenWidth, ScreenHeight)//(width, height)
    }
}