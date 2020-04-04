package com.example.razikgames_dndgame.Stage

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.Timer
import com.example.razikgames_dndgame.ScreenManager
import com.example.razikgames_dndgame.currentScreen
import com.example.razikgames_dndgame.viewport

class LoadingStage: Stage(viewport) {
    init {
        val backgroundImage = Image(Texture("picture/games_logo.png"))
        addActor(backgroundImage.apply {
            setFillParent(true)
            setScaling(Scaling.fit)

            Timer.schedule(object: Timer.Task() {
                override fun run() {
                    currentScreen = ScreenManager("menu")
                }
            }, 0.5f)
        })
    }
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