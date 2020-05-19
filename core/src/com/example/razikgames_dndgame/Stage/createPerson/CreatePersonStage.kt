package com.example.razikgames_dndgame.Stage.createPerson

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.example.razikgames_dndgame.*
import com.example.razikgames_dndgame.AppConstants.ScreenHeight
import com.example.razikgames_dndgame.AppConstants.ScreenWidth
import com.example.razikgames_dndgame.CreatePersonMenuVariables.genderCompletion
import com.example.razikgames_dndgame.CreatePersonMenuVariables.raceCompletion

class CreatePersonStage private constructor() : Stage(viewport) {
    private object SingletonHolder {
        val HOLDER_INSTANCE = CreatePersonStage()
    }
    companion object {
        val instance: CreatePersonStage
            get() {
                return SingletonHolder.HOLDER_INSTANCE
            }
    }
//--------------------------------------------------------------------------------------------------
    //---создание кнопок
    val genderBtn = ImageTextButton("Пол", menuBtnStyle_700_160("gold", 0))
    val raceBtn = ImageTextButton("Раса", menuBtnStyle_700_160(if (genderCompletion == 1) "gold" else "dark_grey", 0))


//--------------------------------------------------------------------------------------------------
    init {
        val stageLayout = Table()
        addActor(stageLayout.apply {
            debugAll()
            setFillParent(true)
//--------------TOP---------------------------------------------------------------------------------
            row().let {
                val topPanel = Container<Widget>()
            val labelStyle = Label.LabelStyle()
            labelStyle.font = Fonts.getFont1(ScreenWidth *0.06f)

            add(topPanel.apply {
                background = TextureRegionDrawable(TextureRegion(Texture("picture/main_menu/main_frame_top.png")))
                //fill()
                pad(AppConstants.PADDING * 1)
                actor = Label("Создание героя", labelStyle)
            }).height(ScreenHeight *0.0888f).width(ScreenWidth *1f).expandX()
        }.colspan(3)
//--------------CENTER------------------------------------------------------------------------------
            row().let {
                val center = Container<WidgetGroup>()
                add(center.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("picture/main_menu/main_frame_center.png")))
                    actor = Table().apply {
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val genderMenu = Container<WidgetGroup>()
                            add(genderMenu.apply {
                                //---ПОЛ
                                genderBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        currentScreen = ScreenManager("gender")
                                    }
                                })
                                actor = genderBtn
                            }).padBottom(ScreenHeight *0.01f).expandX
                        }
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val raceMenu = Container<WidgetGroup>()
                            add(raceMenu.apply {
                                //---РАСА
                                raceBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        if(genderCompletion == 1) currentScreen = ScreenManager("gender")
                                    }
                                })
                                actor = raceBtn
                            }).padBottom(ScreenHeight *0.01f).expandX
                        }
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val portraitMenu = Container<WidgetGroup>()
                            add(portraitMenu.apply {
                                var portraitColor : String = if (raceCompletion == 1) "gold" else "dark_grey"
                                val portraitBtn = ImageTextButton("Портрет", menuBtnStyle_700_160(portraitColor, 0))
                                //portraitBtn.isDisabled = if (raceCompletion == 1) false else true
                                /*portraitBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        //currentScreen = ScreenManager("new")
                                    }
                                })*/
                                actor = portraitBtn
                            }).padBottom(ScreenHeight *0.01f).expandX
                        }
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val classMenu = Container<WidgetGroup>()
                            add(classMenu.apply {
                                val classBtn = ImageTextButton("Класс", menuBtnStyle_700_160("dark_grey", 0))
                                /*classBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        //currentScreen = ScreenManager("new")
                                    }
                                })*/
                                actor = classBtn
                            }).padBottom(ScreenHeight *0.01f).expandX
                        }
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val alignmentMenu = Container<WidgetGroup>()
                            add(alignmentMenu.apply {
                                val alignmentBtn = ImageTextButton("Характер", menuBtnStyle_700_160("dark_grey", 0))
                                /*alignmentBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        //currentScreen = ScreenManager("new")
                                    }
                                })*/
                                actor = alignmentBtn
                            }).padBottom(ScreenHeight *0.01f).expandX
                        }
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val atributeMenu = Container<WidgetGroup>()
                            add(atributeMenu.apply {
                                val atributeBtn = ImageTextButton("Характеристики", menuBtnStyle_700_160("dark_grey", 0))
                                /*atributeBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        //currentScreen = ScreenManager("new")
                                    }
                                })*/
                                actor = atributeBtn
                            }).padBottom(ScreenHeight *0.01f).expandX
                        }
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val skillsMenu = Container<WidgetGroup>()
                            add(skillsMenu.apply {
                                val skillsBtn = ImageTextButton("Навыки и Умения", menuBtnStyle_700_160("dark_grey", 0))
                                /*skillsBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        //currentScreen = ScreenManager("new")
                                    }
                                })*/
                                actor = skillsBtn
                            }).padBottom(ScreenHeight *0.01f).expandX
                        }
//--------------------------------------------------------------------------------------------------
                        row().let {
                            val customizationMenu = Container<WidgetGroup>()
                            add(customizationMenu.apply {
                                val customizationBtn = ImageTextButton("Настройка", menuBtnStyle_700_160("dark_grey", 0))
                                /*customizationBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        //currentScreen = ScreenManager("new")
                                    }
                                })*/
                                actor = customizationBtn
                            }).padBottom(ScreenHeight *0.01f).expandX
                        }
//--------------------------------------------------------------------------------------------------
                    }
                }).colspan(3).height(ScreenHeight * 0.807f).width(ScreenWidth * 1f).expandX()
            }
//----------BOTTOM----------------------------------------------------------------------------------
            row().let {
                val bottomPanel = Container<WidgetGroup>()
                add(bottomPanel.apply {
                    background = TextureRegionDrawable(TextureRegion(Texture("picture/main_menu/main_frame_bottom.png")))
                    actor = Table().apply {
                        row().let {
                            val bottomPanel1 = Container<WidgetGroup>()
                            val bottomPanel2 = Container<WidgetGroup>()
                            val bottomPanel3 = Container<WidgetGroup>()

                            add(bottomPanel1.apply {
                                val gameBtn = ImageTextButton("Играть", menuBtnStyle_300_160("gold"))
                                /*gameBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        //currentScreen = ScreenManager("new")
                                    }
                                })*/
                                actor = gameBtn
                            }).padLeft(ScreenWidth * 0.01f)

                            add(bottomPanel2.apply {
                                val resetBtn = ImageTextButton("Сбросить", menuBtnStyle_300_160("gold"))
                                /*resetBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        //currentScreen = ScreenManager("new")
                                    }
                                })*/
                                actor = resetBtn
                            }).padLeft(ScreenWidth * 0.025f).padRight(ScreenWidth * 0.025f).expandX

                            add(bottomPanel3.apply {
                                val cancelBtn = ImageTextButton("Отмена", menuBtnStyle_300_160("gold"))
                                cancelBtn.addListener(object : ChangeListener() {
                                    override fun changed(event: ChangeEvent?, actor: Actor?) {
                                        currentScreen = ScreenManager("menu")
                                    }
                                })
                                actor = cancelBtn
                            }).padRight(ScreenWidth * 0.01f)
                        }.height(ScreenHeight *0.104f)
                    }
                }).colspan(3)
            }
        })
    }
    fun changeBtn() {
        raceBtn.style = menuBtnStyle_700_160(if(genderCompletion == 1) "gold" else "dark_grey", 0)
    }

}

