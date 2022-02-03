package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import osukt.client.Client
import osukt.enums.Endpoint
import osukt.enums.GameMode
import osukt.enums.UserLookupType

@Serializable
data class User(
    @SerialName("username")
    val username: String,
    @SerialName("previous_usernames")
    val previousUsernames: Array<String>,
    @SerialName("country_code")
    val countryCode: String,
    @SerialName("default_group")
    val defaultGroup: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("cover_url")
    val coverUrl: String,
    @SerialName("profile_colour")
    val profileColor: String?,
    @SerialName("last_visit")
    val lastVisit: String?,
    @SerialName("interests")
    val interests: String?,
    @SerialName("join_date")
    val joinDate: String,
    @SerialName("playmode")
    val playMode: GameMode,
    @SerialName("playstyle")
    val playStyle: List<String>?,
    @SerialName("discord")
    val discord: String?,
    @SerialName("twitter")
    val twitter: String?,
    @SerialName("website")
    val website: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("post_count")
    val postCount: Int?,
    @SerialName("statistics")
    val statistics: UserStatistics?,
    @SerialName("comments_count")
    val commentsCount: Int?,
    @SerialName("occupation")
    val occupation: String?,
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
    @SerialName("location")
    val location: String?,
    @SerialName("country")
    val country: Country? = null,
    @SerialName("has_supported")
    val hasSupported: Boolean,
    @SerialName("badges")
    val badges: List<UserBadge> = listOf(),
    @SerialName("follower_count")
    val followerCount: Int = 0,
    @SerialName("kudosu")
    val kudosu: Kudosu,
    @SerialName("max_blocks")
    val maxBlocks: Int,
    @SerialName("max_friends")
    val maxFriends: Int,
    @SerialName("id")
    val id: Long?
) {
    companion object {
        private val json = Json { ignoreUnknownKeys = true }

        fun get(username: String, mode: GameMode? = null, type: UserLookupType? = null): User? {
            var url = Endpoint.Base.value + Endpoint.User.value.format(username)
            val queryParams = if (type != null) mapOf("key" to type.value) else mapOf()

            if (mode != null) {
                url = url + "/${mode.lookupName}"
            }

            Client.instance().get(url, queryParams)?.let {
                return json.decodeFromString(it)
            } ?: return null
        }
    }
}