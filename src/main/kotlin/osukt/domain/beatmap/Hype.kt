package osukt.domain.beatmap

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hype(
    @SerialName("current")
    val current: Int,
    @SerialName("required")
    val required: Int
)