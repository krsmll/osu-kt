package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import osukt.client.Client
import osukt.domain.beatmap.Beatmap
import osukt.domain.beatmap.BeatmapSetCompact
import osukt.enums.Endpoint
import osukt.enums.GameMode
import osukt.enums.Mod
import osukt.enums.ScoreType

@Serializable
data class Score(
    @SerialName("id")
    val id: Long,
    @SerialName("best_id")
    val idBest: Long?,
    @SerialName("user_id")
    val idUser: Long,
    @SerialName("accuracy")
    val accuracy: Float,
    @SerialName("mods")
    val mods: List<Mod>,
    @SerialName("score")
    val score: Long,
    @SerialName("max_combo")
    val comboMax: Int,
    @SerialName("perfect")
    val perfect: Boolean,
    @SerialName("passed")
    val passed: Boolean,
    @SerialName("statistics")
    val statistics: ScoreStatistics,
    @SerialName("pp")
    val pp: Float?,
    @SerialName("rank")
    val rank: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("mode")
    val mode: GameMode,
    @SerialName("replay")
    val replayAvailable: Boolean,
    @SerialName("beatmap")
    val beatmap: Beatmap?,
    @SerialName("beatmapset")
    val beatmapSet: BeatmapSetCompact,
    @SerialName("user")
    val user: UserCompact? = null,
) {
    companion object {
        private val json = Json { ignoreUnknownKeys = true }

        fun get(
            user: Long,
            type: ScoreType = ScoreType.Recent,
            mode: GameMode? = null,
            limit: Int? = null,
            offset: String? = null,
            includeFails: Boolean? = null
        ): List<Score>? {
            val url = Endpoint.Base.value + Endpoint.UserScore.value.format(user, type.value)
            val queryParams = mutableMapOf<String, Any>()

            if (includeFails != null && includeFails) queryParams.put("include_fails", "1")
            if (mode != null) queryParams.put("mode", mode.lookupName)
            if (limit != null) queryParams.put("limit", limit)
            if (offset != null) queryParams.put("offset", offset)

            Client.instance().get(url, queryParams.toMap())?.let {
                return json.decodeFromString(it)
            } ?: return null
        }
    }
}