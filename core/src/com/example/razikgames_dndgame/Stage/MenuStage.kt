package com.example.razikgames_dndgame.Stage

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.example.razikgames_dndgame.*
import com.example.razikgames_dndgame.AppConstants.ScreenHeight
import com.example.razikgames_dndgame.AppConstants.ScreenWidth
import com.example.razikgames_dndgame.AppConstants.char1
import com.example.razikgames_dndgame.AppConstants.char2
import com.example.razikgames_dndgame.AppConstants.char3
import com.example.razikgames_dndgame.AppConstants.char4
import com.example.razikgames_dndgame.AppConstants.char5
import com.example.razikgames_dndgame.CreatePersonMenuVariables.resetCPVars
import com.example.razikgames_dndgame.MenuGenderVariables.resetMGVars
import com.example.razikgames_dndgame.Person

class MenuStage private constructor(): Stage(viewport) {
    private object SingletonHolder {
        val HOLDER_INSTANCE = MenuStage()
    }
    companion object {
        val instance: MenuStage
            get() {
                return SingletonHolder.HOLDER_INSTANCE
            }
        val test: ITest = TODO()
    }
    //val test = ITest
    //val game = MyGame(test)
    val text: String = MyGame(test).test2()

    init {
        val stageLayout = Table()
        addActor(stageLayout.apply {
            debugAll()
            setFillParent(true)
//--------------TOP---------------------------------------------------------------------------------
            row().let {
                val topPanel = Container<Widget>()
                val labelStyle = LabelStyle()
                labelStyle.font = Fonts.getFont1(ScreenWidth*0.06f)

                add(topPanel.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("picture/main_menu/main_frame_top.png")))
                    //fill()
                    pad(AppConstants.PADDING * 1)
                    actor = Label("Выбор персонажа", labelStyle)
                }).height(ScreenHeight*0.0888f).width(ScreenWidth*1f).expandX()
            }
//--------------CENTER------------------------------------------------------------------------------
            row().let {
                val center = Container<WidgetGroup>()
                add(center.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("picture/main_menu/main_frame_center.png")))
                    actor = Table().apply {
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val portrait_1 = Container<WidgetGroup>()
                            val description_1 = Container<WidgetGroup>()
                            if(char1 == 0) {
                                add(portrait_1.apply {
                                    val portraitBtn_1 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_1
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_1.apply {
                                    val descriptionBtn_1 = ImageTextButton("Создать нового героя", menuPortraitRightBtnStyle())
                                    descriptionBtn_1.addListener(object : ChangeListener() {
                                        override fun changed(event: ChangeEvent?, actor: Actor?) {
                                            MyGame(test).character1 = Person()
                                            resetCPVars()
                                            resetMGVars()
                                            currentScreen = ScreenManager("new")
                                        }
                                    })
                                    actor = descriptionBtn_1
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            } else {
                                add(portrait_1.apply {
                                    val portraitBtn_1 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_1
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_1.apply {
                                    val descriptionBtn_1 = ImageTextButton("Создать нового героя", menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_1
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            }
                        }.height(ScreenHeight * 0.15f)
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val portrait_2 = Container<WidgetGroup>()
                            val description_2 = Container<WidgetGroup>()
                            if(char2 == 0) {
                                add(portrait_2.apply {
                                    val portraitBtn_2 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_2
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_2.apply {
                                    val descriptionBtn_2 = ImageTextButton("Создать нового героя", menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_2
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            } else {
                                add(portrait_2.apply {
                                    val portraitBtn_2 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_2
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_2.apply {
                                    val descriptionBtn_2 = ImageTextButton("Создать нового героя", menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_2
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            }
                        }.height(ScreenHeight * 0.15f)
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val portrait_3 = Container<WidgetGroup>()
                            val description_3 = Container<WidgetGroup>()
                            if(char3 == 0) {
                                add(portrait_3.apply {
                                    val portraitBtn_3 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_3
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_3.apply {
                                    val descriptionBtn_3 = ImageTextButton("Создать нового героя", menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_3
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            } else {
                                add(portrait_3.apply {
                                    val portraitBtn_3 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_3
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_3.apply {
                                    val descriptionBtn_3 = ImageTextButton("Создать нового героя", menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_3
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            }
                        }.height(ScreenHeight * 0.15f)
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val portrait_4 = Container<WidgetGroup>()
                            val description_4 = Container<WidgetGroup>()
                            if(char4 == 0) {
                                add(portrait_4.apply {
                                    val portraitBtn_4 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_4
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_4.apply {
                                    val descriptionBtn_4 = ImageTextButton("Создать нового героя", menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_4
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            } else {
                                add(portrait_4.apply {
                                    val portraitBtn_4 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_4
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_4.apply {
                                    val descriptionBtn_4 = ImageTextButton("Создать нового героя", menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_4
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            }
                        }.height(ScreenHeight * 0.15f)
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val portrait_5 = Container<WidgetGroup>()
                            val description_5 = Container<WidgetGroup>()
                            if(char5 == 0) {
                                add(portrait_5.apply {
                                    val portraitBtn_5 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_5
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_5.apply {
                                    val descriptionBtn_5 = ImageTextButton(text, menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_5
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            } else {
                                add(portrait_5.apply {
                                    val portraitBtn_5 = ImageButton(menuPortraitLeftBtnStyle())
                                    actor = portraitBtn_5
                                }).padLeft(ScreenWidth * 0.03f)
                                add(description_5.apply {
                                    val descriptionBtn_5 = ImageTextButton(text, menuPortraitRightBtnStyle())
                                    actor = descriptionBtn_5
                                }).padRight(ScreenWidth * 0.03f).padLeft(ScreenWidth * 0.02f)
                            }
                        }.height(ScreenHeight * 0.15f)

                    }
//--------------------------------------------------------------------------------------------------
                }).height(ScreenHeight * 0.807f).width(ScreenWidth * 1f).expandX()
            }
//----------BOTTOM----------------------------------------------------------------------------------
            row().let {
                val bottomPanel = Container<WidgetGroup>()
                add(bottomPanel.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("picture/main_menu/main_frame_bottom.png")))

                    pad(AppConstants.PADDING * 1)
                }).height(ScreenHeight*0.104f).width(ScreenWidth*1f).expandX()
            }
        })
    }
}

/*object Buttons {
    var atlas = TextureAtlas("atlas/plus.atlas")
    var buttonsSkin = Skin(atlas)
    var charSelectButton = ImageButton(buttonsSkin).apply {
        setSize(ScreenHeight*0.13f, ScreenWidth*0.13f)
    }

}*/

