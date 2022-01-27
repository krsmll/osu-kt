package osukt.domain.beatmap

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import osukt.domain.user.UserCompact
import osukt.enums.RankStatus

@Serializable
data class BeatmapSet(
    @SerialName("artist")
    val artist: String,
    @SerialName("artist_unicode")
    val artistUnicode: String,
    @SerialName("covers")
    val covers: BeatmapSetCovers,
    @SerialName("creator")
    val creator: String,
    @SerialName("favourite_count")
    val favoriteCount: Int,
    @SerialName("id")
    val id: Long,
    @SerialName("nsfw")
    val nsfw: Boolean,
    @SerialName("play_count")
    val playCount: Int,
    @SerialName("preview_url")
    val previewUrl: String,
    @SerialName("source")
    val source: String,
    @SerialName("status")
    val status: String,
    @SerialName("title")
    val title: String,
    @SerialName("title_unicode")
    val titleUnicode: String,
    @SerialName("user_id")
    val userId: Long,
    @SerialName("video")
    val videoAvailable: Boolean,
    @SerialName("beatmaps")
    val beatmaps: List<Beatmap>?,
    @SerialName("genre")
    val genre: String?,
    @SerialName("language")
    val language: String?,
    @SerialName("user")
    val user: UserCompact?,
    @SerialName("description")
    val description: String?,
    @SerialName("availability")
    val availability: Availability,
    @SerialName("bpm")
    val bpm: Float,
    @SerialName("can_be_hyped")
    val isHypeable: Boolean,
    @SerialName("hype")
    val hype: Hype?,
    @SerialName("is_scoreable")
    val isScoreable: Boolean,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("legacy_thread_url")
    val legacyThreadUrl: String?,
    @SerialName("nominations")
    val nominations: Nominations,
    @SerialName("ranked")
    val rankStatus: RankStatus,
    @SerialName("ranked_date")
    val rankedDate: String?,
    @SerialName("storyboard")
    val hasStoryboard: Boolean,
    @SerialName("submitted_date")
    val submissionDate: String,
    @SerialName("tags")
    val tags: String
)