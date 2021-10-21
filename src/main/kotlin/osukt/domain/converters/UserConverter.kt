package osukt.domain.converters

import com.beust.klaxon.Converter
import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonValue
import com.beust.klaxon.Klaxon
import osukt.domain.Event
import osukt.domain.User
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UserConverter : Converter {
    override fun canConvert(cls: Class<*>): Boolean = cls == User::class.java

    override fun fromJson(jv: JsonValue): User {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        return User(
            id = jv.objString("user_id").toLong(),
            username = jv.objString("username"),
            joinDate = LocalDateTime.parse(jv.objString("join_date"), formatter),
            count300 = jv.objString("count300").toLong(),
            count100 = jv.objString("count100").toLong(),
            count50 = jv.objString("count50").toLong(),
            playcount = jv.objString("playcount").toInt(),
            scoreRanked = jv.objString("ranked_score").toLong(),
            scoreTotal = jv.objString("total_score").toLong(),
            rankGlobal = jv.objString("pp_rank").toInt(),
            level = jv.objString("level").toFloat(),
            ppRaw = jv.objString("pp_raw").toInt(),
            accuracy = jv.objString("accuracy").toFloat(),
            countSs = jv.objString("count_rank_ss").toInt(),
            countSsh = jv.objString("count_rank_ssh").toInt(),
            countS = jv.objString("count_rank_s").toInt(),
            countSh = jv.objString("count_rank_sh").toInt(),
            countA = jv.objString("count_rank_a").toInt(),
            country = jv.objString("country"),
            timePlayedSeconds = jv.objString("total_seconds_played").toLong(),
            rankCountry = jv.objString("pp_country_rank"),
            events = jv.obj?.array<JsonObject?>("events")!!.map {
                Event(
                    it?.get("display_html") as String,
                    (it.get("beatmap_id") as String).toLong(),
                    (it.get("beatmapset_id") as String).toLong(),
                    LocalDateTime.parse(it.get("date") as String, formatter),
                    (it.get("epicfactor") as String).toInt()
                )
            }
        )
    }

    override fun toJson(value: Any): String {
        return Klaxon().toJsonString(value)
    }
}