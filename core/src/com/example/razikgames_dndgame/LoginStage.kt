package com.example.razikgames_dndgame

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Container
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable

class LoginStage: Stage(viewport) {
    init {
        val stageLayout = Table()
        addActor(stageLayout.apply {
            setFillParent(true)

            row().let {
                val centralPanel = Container<WidgetGroup>()
                add(centralPanel.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("icon_jpg.jpg")))
                    fill()
                    pad(AppConstants.PADDING * 2)
                }).expand()
            }
        })
    }
}