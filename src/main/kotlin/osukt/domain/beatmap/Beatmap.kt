package osukt.domain.beatmap

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import osukt.client.Client
import osukt.enums.Endpoint
import osukt.enums.GameMode
import osukt.enums.RankStatus

@Serializable
data class Beatmap(
    @SerialName("accuracy")
    val accuracy: Float,
    @SerialName("ar")
    val ar: Float,
    @SerialName("beatmapset_id")
    val idBeatmapSet: Long,
    @SerialName("bpm")
    val bpm: Float?,
    @SerialName("convert")
    val isConvert: Boolean,
    @SerialName("count_circles")
    val countCircles: Int,
    @SerialName("count_sliders")
    val countSliders: Int,
    @SerialName("count_spinners")
    val countSpinners: Int,
    @SerialName("cs")
    val cs: Float,
    @SerialName("deleted_at")
    val deletedAt: String?,
    @SerialName("drain")
    val drainTime: Float,
    @SerialName("hit_length")
    val hitLength: Int,
    @SerialName("is_scoreable")
    val isScoreable: Boolean,
    @SerialName("last_updated")
    val lastUpdate: String,
    @SerialName("mode")
    val mode: GameMode,
    @SerialName("difficulty_rating")
    val starRating: Float,
    @SerialName("status")
    val status: String,
    @SerialName("passcount")
    val passCount: Int,
    @SerialName("playcount")
    val playCount: Int,
    @SerialName("ranked")
    val rankStatus: RankStatus,
    @SerialName("url")
    val url: String
) {
    companion object {
        private val json = Json { ignoreUnknownKeys = true }

        fun get(beatmapId: Long): Beatmap? {
            val url = Endpoint.Base.value + Endpoint.Beatmaps.value.format(beatmapId)

            Client.instance().get(url, mapOf())?.let {
                return json.decodeFromString(it)
            } ?: return null
        }
    }
}