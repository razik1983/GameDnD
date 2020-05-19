package com.example.razikgames_dndgame

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.util.*



class DbRepository(context: Context) {
    private val db: SQLiteDatabase
    private val cont: Context
    val data: ArrayList<String>
        get() {
            val field: Class = Class.Label
            val list = ArrayList<String>()
            val cursor = db.query("Class", null, null, null, null, null, null)
            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()
                do {
                    list.add(cursor.getString(field.fieldCode))
                } while (cursor.moveToNext())
            }
            return list
        }

    init { //Подключение к базе данных
        db = DataBaseHelper(context).getWritableDatabase()
        cont = context
    }
}

enum class Class(val fieldCode: kotlin.Int) {
    _id(1),
    Label(2),
    Name(3),
    Plural(4),
    Lower(5),
    Description(6),
    Icon(7),
    HitDie(8),
    AttackBonusTable(9),
    FeatsTable(10),
    SavingThrowTable(11),
    SkillsTable(12),
    BonusFeatsTable(13),
    SkillPointBase(14),
    SpellGainTable(15),
    SpellKnownTable(16),
    PlayerClass(17),
    SpellCaster(18),
    Str(19), Dex(20), Con(21), Wis(22), Int(23), Cha(24),
    PrimaryAbil(25),
    AlignRestrict(26),
    AlignRestrictType(27),
    InvertRestrict(28),
    Constant(29),
    EffCRLvl01(30), EffCRLvl02(31), EffCRLvl03(32), EffCRLvl04(33), EffCRLvl05(34),
    EffCRLvl06(35), EffCRLvl07(36), EffCRLvl08(37), EffCRLvl09(38), EffCRLvl10(39),
    EffCRLvl11(40), EffCRLvl12(41), EffCRLvl13(42), EffCRLvl14(43), EffCRLvl15(44),
    EffCRLvl16(45), EffCRLvl17(46), EffCRLvl18(47), EffCRLvl19(48), EffCRLvl20(49),
    PreReqTable(50),
    MaxLevel(51),
    XPPenalty(52),
    ArcSpellLvlMod(53),
    DivSpellLvlMod(54),
    EpicLevel(55),
    Package(56)
}