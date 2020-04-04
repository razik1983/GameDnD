package com.example.razikgames_dndgame.desktop

import com.badlogic.gdx.tools.texturepacker.TexturePacker


object MyPacker {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        TexturePacker.process("d\\LibGDXProject\\RazikGamesDnDgame\\android\\assets\\picture\\to_atlas", "D:\\Android\\LibGDXProject\\RazikGamesDnDgame\\android\\assets\\atlas", "PortraitBtn")
    }
}