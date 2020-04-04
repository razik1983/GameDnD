package com.example.razikgames_dndgame


import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton.ImageTextButtonStyle
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.utils.Drawable
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable



fun menuPortraitLeftBtnStyle(): ImageButton.ImageButtonStyle {
    val AtlasBtn = TextureAtlas("atlas/PortraitBtn.atlas")
    val skinBtn = Skin (AtlasBtn)
    val portraitButtonStyle = ImageButton.ImageButtonStyle() /*Instaciate*/.apply {
        up = skinBtn.getDrawable("portraitButton_off") //Set image for not pressed button
        down = skinBtn.getDrawable("portraitButton_off") //Set image for pressed
        over = skinBtn.getDrawable("portraitButton_off") //set image for mouse over
        pressedOffsetX = -1f
        pressedOffsetY = -1f
    }
    return portraitButtonStyle
}
fun menuPortraitRightBtnStyle(): ImageTextButton.ImageTextButtonStyle {
    val drawable: Drawable = TextureRegionDrawable(TextureRegion(Texture(
            Gdx.files.internal("picture/main_menu/portrait_button_right_off.png"))))
    //val gen = FreeTypeFontGenerator(
            //Gdx.files.internal("Segoe.ttf"))
    //val frontParam = FreeTypeFontParameter()
    //frontParam.size = (AppConstants.ScreenWidth *0.06).toInt()
    //val b = gen.generateFont(frontParam)
    //gen.dispose()
    val portraitFrameButtonStyle = ImageTextButtonStyle().apply {
        down = drawable
        up = drawable
        font = Fonts.getFont1(AppConstants.ScreenWidth *0.04f)
        fontColor = Color(255f, 255f, 220f, 1f)
        //fontColor = Color.valueOf("877E6A")
    }
    //textContent = ImageTextButton("Lade... : ", imageButtonStyle)
    return portraitFrameButtonStyle
}

fun menuBtnStyle_700_160(color: String, isFocus: Int): ImageTextButton.ImageTextButtonStyle {
    val drawable: Drawable = when (isFocus) {
        0 -> TextureRegionDrawable(TextureRegion(Texture(Gdx.files.internal("picture/create_character_menu/menu_button_frame_700x160.png"))))
        1 -> TextureRegionDrawable(TextureRegion(Texture(Gdx.files.internal("picture/create_character_menu/menu_button_frame_700x160_Focused.png"))))
        else -> TextureRegionDrawable(TextureRegion(Texture(Gdx.files.internal("picture/create_character_menu/menu_button_frame_700x160.png"))))
    }
    val menuFrameButtonStyle = ImageTextButtonStyle().apply {
        down = drawable
        up = drawable
        font = Fonts.getFont1(AppConstants.ScreenWidth *0.04f)
        fontColor = when (color) {
            "gold" -> Color.valueOf("ffffdc")
            "dark_grey" -> Color.valueOf("646464")
            "light_grey" -> Color.valueOf("b4b4b4")
            "red" -> Color.valueOf("ff0000")
            else -> Color.valueOf("ffffff")
        }
        //fontColor = Color(255f, 255f, 220f, 1f)
        //fontColor = Color.valueOf("877E6A")
    }
    return menuFrameButtonStyle
}
fun menuBtnStyle_470_160(color: String, isFocus: Int): ImageTextButton.ImageTextButtonStyle {
    val drawable: Drawable = when (isFocus) {
        0 -> TextureRegionDrawable(TextureRegion(Texture(Gdx.files.internal("picture/create_character_menu/menu_button_frame_470x160.png"))))
        1 -> TextureRegionDrawable(TextureRegion(Texture(Gdx.files.internal("picture/create_character_menu/menu_button_frame_470x160_Focused.png"))))
        else -> TextureRegionDrawable(TextureRegion(Texture(Gdx.files.internal("picture/create_character_menu/menu_button_frame_470x160.png"))))
    }
    val menuFrameButtonStyle = ImageTextButtonStyle().apply {
        down = drawable
        up = drawable
        font = Fonts.getFont1(AppConstants.ScreenWidth *0.04f)
        fontColor = when (color) {
            "gold" -> Color.valueOf("ffffdc")
            "dark_grey" -> Color.valueOf("646464")
            "light_grey" -> Color.valueOf("b4b4b4")
            "red" -> Color.valueOf("ff0000")
            else -> Color.valueOf("ffffff")
        }
        //fontColor = Color.valueOf("877E6A")
    }
    return menuFrameButtonStyle
}
fun menuBtnStyle_300_160(color: String): ImageTextButton.ImageTextButtonStyle {
    val drawable: Drawable = TextureRegionDrawable(TextureRegion(Texture(
            Gdx.files.internal("picture/create_character_menu/menu_button_frame_300x160.png"))))
    val menuFrameButtonStyle = ImageTextButtonStyle().apply {
        down = drawable
        up = drawable
        font = Fonts.getFont1(AppConstants.ScreenWidth *0.035f)
        fontColor = when (color) {
            "gold" -> Color.valueOf("ffffdc")
            "dark_grey" -> Color.valueOf("646464")
            "light_grey" -> Color.valueOf("b4b4b4")
            "red" -> Color.valueOf("ff0000")
            else -> Color.valueOf("ffffff")
        }
        //fontColor = Color(255f, 255f, 220f, 1f)
        //fontColor = Color.valueOf("877E6A")
    }
    return menuFrameButtonStyle
}