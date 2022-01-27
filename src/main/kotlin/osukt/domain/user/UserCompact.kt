package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserCompact(
    @SerialName("username")
    val username: String,
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("default_group")
    val defaultGroup: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("profile_colour")
    val profileColor: String?,
    @SerialName("last_visit")
    val lastVisit: String,
    @SerialName("is_active")
    val isActive: Boolean?,
    @SerialName("is_bot")
    val isBot: Boolean?,
    @SerialName("is_deleted")
    val isDeleted: Boolean?,
    @SerialName("is_online")
    val isOnline: Boolean?,
    @SerialName("is_supporter")
    val isSupporter: Boolean?,
    @SerialName("pm_friends_only")
    val friendsOnlyPm: Boolean?,
    @SerialName("id")
    val id: Long?
)