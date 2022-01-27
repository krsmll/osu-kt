package osukt.domain.beatmap

import kotlinx.serialization.Serializable

@Serializable
data class BeatmapSetCovers(
    val cover: String,
    val cover2x: String? = null,
    val card: String,
    val card2x: String? = null,
    val list: String,
    val list2x: String? = null,
    val slimCover: String? = null,
    val slimCover2x: String? = null
)