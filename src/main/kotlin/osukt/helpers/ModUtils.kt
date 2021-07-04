package osukt.helpers

import osukt.enums.Mod

/**
 * Based on Vinxis' maquiaBot.
 *
 * Source: https://github.com/VINXIS/maquiaBot/blob/master/osu-api/mods.go
 */

object ModUtils {

    private val mods: List<String> = listOf(
        "NF", // No Fail
        "EZ", // Easy
        "TD", // Touch Device
        "HD", // Hidden
        "HR", // Hard Rock
        "SD", // Sudden Death
        "DT", // Double Time
        "RX", // Relax
        "HT", // Half Time
        "NC", // Nightcore
        "FL", // Flashlight
        "AT", // Auto
        "SO", // Spun Out
        "AP", // Autopilot
        "PF", // Perfect
        "K4", // 4 Key
        "K5", // 5 Key
        "K6", // 6 Key
        "K7", // 7 Key
        "K8", // 8 Key
        "FI", // Fade In
        "RN", // Random
        "CN", // Cinema
        "TR", // Target
        "K9", // 9 Key
        "KC", // Coop Key
        "K1", // 1 Key
        "K3", // 3 Key
        "K2", // 2 Key
        "V2", // Score V2
    )

    fun parseMods(modStr: String): Int {
        if (modStr.isEmpty() || modStr.length % 2 != 0) {
            return -1
        }
        val modsCh = modStr.chunked(2)
        var res = 0
        modsCh.forEach { mod ->
            mods.forEachIndexed { i, availMod ->
                if (availMod == mod) {
                    (res or (1 shl i)).also { res = it }
                    return@forEachIndexed
                }
            }
        }
        return res
    }

    fun parseMods(modList: List<Mod>): Int {
        return modList.sumOf { it.bitValue }
    }



    fun modsToString(bitValue: Int): String {
        if (bitValue == 0) {
            return "NM"
        }
        var res = ""
        var temp = bitValue
        mods.indices.forEach { i ->
            if (1 and temp == 1) res += mods[i]
            (temp shr 1).also { temp = it }
        }
        return res
    }
}