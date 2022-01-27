package osukt.domain.beatmap

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import osukt.domain.user.UserCompact

@Serializable
data class BeatmapSetCompact(
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
    val videoAvailable: Boolean
)
