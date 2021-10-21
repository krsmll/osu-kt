package osukt.domain.converters

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import osukt.domain.Scores
import osukt.helpers.ModUtils
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ScoreConverter : Converter {
    override fun canConvert(cls: Class<*>): Boolean = cls == Scores::class.java

    override fun fromJson(jv: JsonValue): Scores {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        return Scores(
            scoreId = jv.objString("score_id").toLong(),
            userId = jv.objString("user_id").toLong(),
            username = jv.objString("username"),
            score = jv.objString("score").toLong(),
            count300 = jv.objString("count300").toInt(),
            count100 = jv.objString("count100").toInt(),
            count50 = jv.objString("count50").toInt(),
            countMiss = jv.objString("countmiss").toInt(),
            maxCombo = jv.objString("maxcombo").toInt(),
            countKatu = jv.objString("countkatu").toInt(),
            countGeki = jv.objString("countgeki").toInt(),
            isPerfect = if (jv.objString("perfect").toInt() == 1) true else false,
            enabledMods = ModUtils.toModList(jv.objString("enabled_mods").toInt()),
            date = LocalDateTime.parse(jv.objString("date"), formatter),
            rank = jv.objString("rank"),
            pp = jv.objString("pp").toFloat(),
            replayAvailable = if (jv.objString("replay_available").toInt() == 1) true else false
        )
    }

    override fun toJson(value: Any): String {
        return Klaxon().toJsonString(value)
    }
}