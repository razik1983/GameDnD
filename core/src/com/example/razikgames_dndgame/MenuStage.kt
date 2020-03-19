package com.example.razikgames_dndgame


import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.example.razikgames_dndgame.AppConstants.ScreenHeight


class MenuStage : Stage(viewport) {

    init {

        val stageLayout = Table()
        addActor(stageLayout.apply {
            debugAll()
            setFillParent(true)

            //defaults().fill()
            //pad(AppConstants.PADDING)
            //defaults().expand().space(AppConstants.PADDING)

            row().let {
                val topPanel = Container<Widget>()
                add(topPanel.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("frame.png")))
                    fill()
                    pad(AppConstants.PADDING * 15)
                    //actor = Label("MENU", Skin(TextureAtlas("frame.png")))
                }).height(ScreenHeight*0.4f).expandX()
            }
            row().let {
                val centralPanel = Container<WidgetGroup>()
                add(centralPanel.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("icon_jpg.jpg")))
                    fill()
                    pad(AppConstants.PADDING * 2)
                }).expand()
            }
            row().let {
                val footerPanel = Container<WidgetGroup>()
                add(footerPanel.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("icon_jpg.jpg")))
                    fill()
                    pad(AppConstants.PADDING * 2)
                    //actor = CommandPanel(centralPanel)

                }).height(160f).expandX()
            }


            /*row().let {
                val headerContainer = Container<WidgetGroup>()
                add(headerContainer.apply {

            }

            val centralPanel = Container<WidgetGroup>()
            row().let {
                add(centralPanel.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("backgrounds/main-screen-background.png")))
                    fill()
                    pad(AppConstants.PADDING * 2)
                }).expand()
            }

            row().let {
                val footerContainer = Container<WidgetGroup>()
                add(footerContainer.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("images/status-bar-background.png")))
                    fill()

                    actor = CommandPanel(centralPanel)
                }).height(160f).expandX()
            }*/
        })
    }
}