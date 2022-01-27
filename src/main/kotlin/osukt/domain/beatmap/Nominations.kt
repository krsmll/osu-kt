package osukt.domain.beatmap

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Nominations(
    @SerialName("current")
    val current: Int,
    @SerialName("required")
    val required: Int
)