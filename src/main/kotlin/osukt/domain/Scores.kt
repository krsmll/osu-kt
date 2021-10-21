package osukt.domain

import com.beust.klaxon.Klaxon
import osukt.Client
import osukt.domain.converters.ScoreConverter
import osukt.enums.Endpoint
import osukt.enums.GameMode
import osukt.enums.Mod
import osukt.helpers.ModUtils
import java.time.LocalDateTime

data class Scores(
    val scoreId: Long,
    val userId: Long,
    val username: String,
    val score: Long,
    val count300: Int,
    val count100: Int,
    val count50: Int,
    val countMiss: Int,
    val maxCombo: Int,
    val countKatu: Int,
    val countGeki: Int,
    val isPerfect: Boolean,
    val enabledMods: List<Mod>,
    val date: LocalDateTime,
    val rank: String,
    val pp: Float,
    val replayAvailable: Boolean
) {
    companion object {
        val scoreConverter: ScoreConverter = ScoreConverter()

        fun get(
            userId: String,
            beatmapId: String,
            gameMode: GameMode = GameMode.STANDARD,
            isUsername: Boolean = false,
            mods: String = "",
            limit: Int = 50
        ): List<Scores> =
            Klaxon()
                .converter(scoreConverter)
                .parseArray(
                    Client
                        .instance()
                        .get(
                            Endpoint.Scores, mutableMapOf(
                                "u" to userId,
                                "b" to beatmapId,
                                "m" to gameMode.value.toString(),
                                "type" to if (isUsername) "string" else "id",
                                "limit" to limit.toString(),
                                "mods" to ModUtils.parseModString(mods).toString()
                            )
                        )
                )!!
    }
}