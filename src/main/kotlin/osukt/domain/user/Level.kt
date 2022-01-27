package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Level(
    @SerialName("current")
    val current: Int,
    @SerialName("progress")
    val progress: Int
)