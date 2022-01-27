package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScoreStatistics(
    @SerialName("count_50")
    val count50: Int,
    @SerialName("count_100")
    val count100: Int,
    @SerialName("count_300")
    val count300: Int,
    @SerialName("count_geki")
    val countGeki: Int,
    @SerialName("count_katu")
    val countKatu: Int,
    @SerialName("count_miss")
    val countMiss: Int
)