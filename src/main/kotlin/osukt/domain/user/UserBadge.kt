package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserBadge(
    @SerialName("awarded_at")
    val awardedAt: String,
    @SerialName("description")
    val description: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("url")
    val url: String
)