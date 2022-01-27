package osukt.helpers

import osukt.enums.Mod

/**
 * Based on Vinxis' maquiaBot.
 *
 * @see <a href="https://github.com/VINXIS/maquiaBot/blob/master/osu-api/mods.go">maquiaBot</a>
 */
object ModUtils {

    private val mods: Array<Mod> = Mod.values()

    fun parseModString(modStr: String): Int {
        if (modStr.isEmpty() || modStr.length % 2 != 0) {
            return -1
        }
        val modsCh = modStr.chunked(2)
        var res = 0
        modsCh.forEach { mod ->
            mods.forEachIndexed { i, availMod ->
                if (availMod.shortName == mod) {
                    (res or (1 shl i)).also { res = it }
                    return@forEachIndexed
                }
            }
        }
        return res
    }

    fun toBitValue(modList: List<Mod>): Int = modList.sumOf { it.bitValue }

    fun toModString(mods: List<Mod>): String = mods.joinToString(", ") { it.shortName }

    fun toModList(bitValue: Int): List<Mod> {
        val res = ArrayList<Mod>()

        if (bitValue == 0) {
            return res
        }

        var temp = bitValue
        mods.indices.forEach { i ->
            if (1 and temp == 1) res.add(mods[i])
            (temp shr 1).also { temp = it }
        }

        return res
    }
}