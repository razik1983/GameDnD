package com.example.razikgames_dndgame.Stage.createPerson




import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Align
import com.example.razikgames_dndgame.*
import com.example.razikgames_dndgame.AppConstants.ScreenHeight
import com.example.razikgames_dndgame.AppConstants.ScreenWidth
import com.example.razikgames_dndgame.CreatePersonMenuVariables.genderCompletion
import com.example.razikgames_dndgame.MenuGenderVariables.infoGenderVisible
import com.example.razikgames_dndgame.MenuGenderVariables.infoTitleGender
import com.example.razikgames_dndgame.MenuGenderVariables.manFocus
import com.example.razikgames_dndgame.MenuGenderVariables.selectionGender
import com.example.razikgames_dndgame.MenuGenderVariables.womanFocus

class GenderStage private constructor() : Stage() {
    private object SingletonHolder {
        val HOLDER_INSTANCE = GenderStage()
    }
    companion object {
        val instance: GenderStage
            get() {
                return SingletonHolder.HOLDER_INSTANCE
            }
        val test: ITest = TODO()
    }
    init {
        val stageLayout = Stack()
        addActor(stageLayout.apply {
            debugAll()
            setFillParent(true)
            val genderMenu = Container<WidgetGroup>()
            val genderInfo = Container<WidgetGroup>()
            add(genderMenu.apply {
                actor = Table().apply {
                    fill()
//--------------TOP---------------------------------------------------------------------------------
                    row().let {
                        val topPanel = Container<Widget>()
                        val labelStyle = Label.LabelStyle()
                        labelStyle.font = Fonts.getFont1(ScreenWidth *0.06f)
                        add(topPanel.apply {
                            background = TextureRegionDrawable(TextureRegion(Texture("picture/main_menu/main_frame_top.png")))
                            //fill()
                            pad(AppConstants.PADDING * 1)
                            actor = Label("Выберите пол своего героя", labelStyle)
                        }).height(ScreenHeight *0.0888f).width(ScreenWidth *1f).expandX()
                    }.colspan(2)
//--------------CENTER------------------------------------------------------------------------------
                    row().let {
                        val center = Container<WidgetGroup>()
                        add(center.apply {
                            background = TextureRegionDrawable(TextureRegion(Texture("picture/main_menu/main_frame_center.png")))
                            val manBtn = ImageTextButton("Мужчина", menuBtnStyle_700_160("gold", manFocus))
                            val womanBtn = ImageTextButton("Женщина", menuBtnStyle_700_160("gold", womanFocus))
                            actor = Table().apply {
                                //--------------------------------------------------------------------------------------------------
                                row().let {
                                    val manMenu = Container<WidgetGroup>()
                                    add(manMenu.apply {
                                        manBtn.addListener(object : ActorGestureListener() {
                                            override fun tap(event: InputEvent?, x: Float, y: Float, count: Int, button: Int) {
                                                selectionGender = 1
                                                manFocus = 1
                                                womanFocus = 0
                                                manBtn.style = menuBtnStyle_700_160("gold", manFocus)
                                                womanBtn.style = menuBtnStyle_700_160("gold", womanFocus)
                                                return super.tap(event, x, y, count, button)
                                            }
                                            override fun longPress(actor: Actor?, x: Float, y: Float): Boolean {
                                                infoGenderVisible = true
                                                genderInfo.isVisible = infoGenderVisible
                                                return super.longPress(actor, x, y)
                                            }
                                        })
                                        actor = manBtn
                                        /*manBtn.addListener(object : ClickListener() {
                                            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                                                if (Gdx.input.isTouched) {
                                                    selectionGender = 1
                                                    manFocus = 1
                                                    womanFocus = 0
                                                    currentScreen = ScreenManager("gender")
                                                }
                                                return super.clicked(event, x, y)
                                            }
                                        })*/
                                    }).colspan(2).padBottom(ScreenHeight*0.01f)
                                }.expand()
//--------------------------------------------------------------------------------------------------
                                row().let {
                                    val womanMenu = Container<WidgetGroup>()
                                    add(womanMenu.apply {
                                        womanBtn.addListener(object : ActorGestureListener() {
                                            override fun tap(event: InputEvent?, x: Float, y: Float, count: Int, button: Int) {
                                                selectionGender = 2
                                                womanFocus = 1
                                                manFocus = 0
                                                manBtn.style = menuBtnStyle_700_160("gold", manFocus)
                                                womanBtn.style = menuBtnStyle_700_160("gold", womanFocus)
                                                return super.tap(event, x, y, count, button)
                                            }
                                            override fun longPress(actor: Actor?, x: Float, y: Float): Boolean {
                                                infoGenderVisible = true
                                                genderInfo.isVisible = infoGenderVisible
                                                return super.longPress(actor, x, y)
                                            }
                                        })
                                        actor = womanBtn
                                    }).colspan(2)
                                }
//--------------------------------------------------------------------------------------------------
                            }
                        }).height(ScreenHeight * 0.807f).width(ScreenWidth * 1f)
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

                                    add(bottomPanel1.apply {
                                        val okBtn = ImageTextButton("ОК", menuBtnStyle_300_160("gold"))
                                        okBtn.addListener(object: ChangeListener() {
                                            override fun changed(event: ChangeEvent?, actor: Actor?) {
                                                val g: String = when(selectionGender) {
                                                    1 -> "Man"
                                                    2 -> "Woman"
                                                    else -> "Man"
                                                }
                                                MyGame(test).character1?.setGender(g)
                                                genderCompletion = 1
                                                CreatePersonStage.instance.changeBtn()

                                                GenderStage().dispose()
                                                currentScreen = ScreenManager("new")
                                            }
                                        })
                                        actor = okBtn
                                    }).padLeft(ScreenWidth * 0.01f)
                                    add(bottomPanel2.apply {
                                        val cancelBtn = ImageTextButton("Отмена", menuBtnStyle_300_160("gold"))
                                        cancelBtn.addListener(object : ChangeListener() {
                                            override fun changed(event: ChangeEvent?, actor: Actor?) {
                                                currentScreen = ScreenManager("new")
                                            }
                                        })
                                        actor = cancelBtn
                                    }).padRight(ScreenWidth * 0.01f)
                                }.height(ScreenHeight *0.104f)
                            }
                        }).colspan(2)
                    }
                }
            })
            add(genderInfo.apply {
                isVisible = infoGenderVisible
                actor = Table().apply {
                    row().let {
                        val topInfoPanel = Container<Widget>()
                        val labelStyle = Label.LabelStyle()
                        labelStyle.font = Fonts.getFont1(ScreenWidth *0.06f)

                        add(topInfoPanel.apply {
                            background = TextureRegionDrawable(TextureRegion(Texture("picture/create_character_menu/info_top_background.png")))
                            //fill()
                            pad(AppConstants.PADDING * 1)
                            actor = Label(infoTitleGender, labelStyle)
                        }).height(ScreenHeight *0.1042f).width(ScreenWidth *0.850f).padBottom(ScreenHeight *0.01f).fill().expandX()
                    }
                    row().let {
                        val centerInfoPanel = Container<WidgetGroup>()
                        background = TextureRegionDrawable(TextureRegion(Texture("picture/create_character_menu/info_center_background.png")))
                        add(centerInfoPanel.apply {
                            actor = Table().apply {
                                row().let {
                                    val infoLabel = Container<Widget>()
                                    val labelStyle = Label.LabelStyle()
                                    labelStyle.font = Fonts.getFont1(ScreenWidth *0.04f)
                                    add(infoLabel.apply {
                                        fill()
                                        actor = Label("Пол героя зависит от вашего предпочтения и не влияет на игровую механику", labelStyle).apply {
                                            setWrap(true)
                                            pad(ScreenHeight *0.026f)
                                            setAlignment(Align.left)
                                        }
                                    }).height(ScreenHeight *0.7f).width(ScreenWidth *0.850f).expand()
                                }
                                row().let {
                                    val BottomInfoPanel = Container<WidgetGroup>()
                                    add(BottomInfoPanel.apply {
                                        val okInfoBtn = ImageTextButton("ОК", menuBtnStyle_300_160("gold"))
                                        okInfoBtn.addListener(object : ActorGestureListener() {
                                            override fun tap(event: InputEvent?, x: Float, y: Float, count: Int, button: Int) {
                                                infoGenderVisible = false
                                                genderInfo.isVisible = infoGenderVisible
                                                super.tap(event, x, y, count, button)
                                            }
                                        })
                                        actor = okInfoBtn
                                    }).height(ScreenHeight *0.1042f).width(ScreenWidth *0.815f)
                                }
                            }
                        }).fill().expandX()
                    }
                }
            })
        })
    }
}