package osukt.domain

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import osukt.Client
import osukt.Endpoints
import osukt.enums.GameMode
import osukt.helpers.ModUtils

data class Scores(
    @Json(name = "score_id")
    val scoreId: String,
    @Json(name = "score")
    val score: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "count300")
    val count300: String,
    @Json(name = "count100")
    val count100: String,
    @Json(name = "count50")
    val count50: String,
    @Json(name = "countmiss")
    val countMiss: String,
    @Json(name = "maxcombo")
    val maxCombo: String,
    @Json(name = "countkatu")
    val countKatu: String,
    @Json(name = "countgeki")
    val countGeki: String,
    @Json(name = "perfect")
    val isPerfect: String,
    @Json(name = "enabled_mods")
    val enabledMods: String,
    @Json(name = "user_id")
    val userId: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "rank")
    val rank: String,
    @Json(name = "pp")
    val pp: String,
    @Json(name = "replay_available")
    val replayAvailable: String
) {
    companion object {
        fun get(
            userId: String,
            beatmapId: String,
            gameMode: GameMode = GameMode.STANDARD,
            isUsername: Boolean = false,
            mods: String = "",
            limit: Int = 50
        ): List<Scores> =
            Klaxon().parseArray(
                Client
                    .instance()
                    .get(
                        Endpoints.Scores, mutableMapOf(
                            "u" to userId,
                            "b" to beatmapId,
                            "m" to gameMode.value.toString(),
                            "type" to if (isUsername) "string" else "id",
                            "limit" to limit.toString(),
                            "mods" to ModUtils.parseMods(mods).toString()
                        )
                    )
            )!!
    }
}