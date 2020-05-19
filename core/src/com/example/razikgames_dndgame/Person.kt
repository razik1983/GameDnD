package com.example.razikgames_dndgame

class Person {
    private var name: String = "Vasya"
    private var experience: Int = 0
    private var maxLvl: Int = calcLvl(experience)
    private var currentLvl: Int = 1

    private var gender: String = "Man"
    private var race = "Human"
    private var icon = ""
    private var clas: String = "Warrior"
    private var ideology: String = "Neutral"    // "Lawful" "Neutral" "Chaotic"
    private var kindness: String = "Neutral"    // "Good" "Neutral" "Evil"

    private var baseSTR: Int = 8
    private var baseDEX: Int = 8
    private var baseCON: Int = 8
    private var baseWIS: Int = 8
    private var baseINT: Int = 8
    private var baseCHA: Int = 8

    private var currentSTR: Int = baseSTR + 0
    private var currentDEX: Int = baseDEX + 0
    private var currentCON: Int = baseCON + 0
    private var currentWIS: Int = baseWIS + 0
    private var currentINT: Int = baseINT + 0
    private var currentCHA: Int = baseCHA + 0

    /*private var modSTR: Int = mp.getModParam(currentSTR)
    private var modDEX: Int = mp.getModParam(currentDEX)
    private var modCON: Int = mp.getModParam(currentCON)
    private var modWIS: Int = mp.getModParam(currentWIS)
    private var modINT: Int = mp.getModParam(currentINT)
    private var modCHA: Int = mp.getModParam(currentCHA)*/

    private var maxHitPoints: Int = 1
    private var currentHitPoints: Int = 1

    private var baseAttackBonus: Int = 0
    private var currentAttackBonus: Int = baseAttackBonus + 0
    private var baseArmorBonus: Int = 10
    private var currentArmorBonus: Int = baseArmorBonus + 0

    private var baseReflex: Int = 0
    private var baseFortitude: Int = 0
    private var baseWill: Int = 0

    private var currentReflex: Int = baseReflex + 0
    private var currentFortitude: Int = baseFortitude + 0
    private var currentWill: Int = baseWill + 0

    private var skill_AnimalEmpathy = 0
    private var skill_Concentration = 0
    private var skill_DisableTrap = 0
    private var skill_Discipline = 0
    private var skill_Heal = 0
    private var skill_Hide = 0
    private var skill_Listen = 0
    private var skill_Lore = 0
    private var skill_MoveSilently = 0
    private var skill_OpenLock = 0
    private var skill_Parry = 0
    private var skill_Perform = 0
    private var skill_Persuade = 0
    private var skill_PickPocket = 0
    private var skill_Search = 0
    private var skill_SetTrap = 0
    private var skill_Spellcraft = 0
    private var skill_Spot = 0
    private var skill_UseMagicDevice = 0
    private var skill_Appraise = 0
    private var skill_Tumble = 0
    private var skill_CraftTrap = 0
    private var skill_Bluff = 0
    private var skill_Intimidate = 0
    private var skill_CraftArmor = 0
    private var skill_CraftWeapon = 0
    private var skill_Ride = 0





    fun getName(): String = name
    fun setName(n: String) { name = n }

    fun getExp(): Int = experience
    fun getLvl(): Int = currentLvl

    fun getCurrentLvl(): Int = currentLvl
    fun getMaxLvl(): Int = maxLvl

    fun getGender(): String = gender
    fun setGender(g: String) { gender = g }

    fun getAttribute(a: String): Int {
        return when (a) {
            "STR" -> currentSTR
            "DEX" -> currentDEX
            "CON" -> currentCON
            "WIS" -> currentWIS
            "INT" -> currentINT
            "CHA" -> currentCHA
            else -> 0
        }
    }
    /*fun getModArrribute(a: String): Int {
        return when (a) {
            "STR" -> modSTR
            "DEX" -> modDEX
            "CON" -> modCON
            "WIS" -> modWIS
            "INT" -> modINT
            "CHA" -> modCHA
            else -> 0
        }
    }*/







    fun calcLvl(e: Int): Int {
        var lev = 1
        for (i in 1..40) {
            var a = 0
            for (x in 1..i) {
                a += x * 1000
            }
            lev = i
            if (e < a) break
        }
        return lev
    }
}



interface ITest {
    fun submitVar ()
}

