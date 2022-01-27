package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScoreWeight(
    @SerialName("percentage")
    val percentage: Int,
    @SerialName("pp")
    val pp: Float
)