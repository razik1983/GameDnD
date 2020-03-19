package com.example.razikgames_dndgame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.Timer
import com.badlogic.gdx.utils.viewport.Viewport


class LoadingScreen(val viewport: Viewport) : ScreenAdapter() {

    private val loadingStage = LoadingStage(viewport)

    override fun hide() {
        Gdx.input.inputProcessor = null
    }
    override fun show() {
        Gdx.input.inputProcessor = loadingStage
    }


    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        loadingStage.act(delta)
        loadingStage.draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }
}

class LoadingStage(viewport: Viewport) : Stage(viewport) {
    init {
        val backgroundImage = Image(Texture("games_logo.png"))
        addActor(backgroundImage.apply {
            setFillParent(true)
            setScaling(Scaling.fit)

            Timer.schedule(object: Timer.Task() {
                override fun run() {
                    currentScreen = SwitchScreen("menu")
                }
            }, 1f)
        })
    }

    /*init {
        val backgroundImage = Image(Texture("games_logo.png"))
        addActor(backgroundImage.apply {
            setFillParent(true)
            setScaling(Scaling.fill)
        })

        val stageLayout = Table()
        addActor(stageLayout.apply {
            setFillParent(true)

            row().let {
                add().width(Value.percentWidth(.6f, stageLayout)).height(Value.percentHeight(.8f, stageLayout))
            }

            row().let {
                add(progressBar).height(40f).fill() // про progressBar будет в следующих частях
            }
        })
    }*/
}
