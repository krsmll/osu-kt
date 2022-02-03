package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserStatistics(
    @SerialName("level")
    val level: Level,
    @SerialName("global_rank")
    val rankGlobal: Int?,
    @SerialName("country_rank")
    val rankCountry: Int?,
    @SerialName("pp")
    val pp: Float,
    @SerialName("ranked_score")
    val scoreRanked: Long,
    @SerialName("total_score")
    val scoreTotal: Long,
    @SerialName("hit_accuracy")
    val accuracy: Float,
    @SerialName("play_count")
    val playCount: Int,
    @SerialName("play_time")
    val playTimeSeconds: Int,
    @SerialName("total_hits")
    val hitsTotal: Int,
    @SerialName("maximum_combo")
    val maxCombo: Int,
    @SerialName("replays_watched_by_others")
    val replayViews: Int,
    @SerialName("is_ranked")
    val isRanked: Boolean,
    @SerialName("grade_counts")
    val gradeCounts: GradeCounts
)