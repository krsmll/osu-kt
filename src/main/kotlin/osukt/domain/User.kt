package osukt.domain

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import osukt.Client
import osukt.Endpoints
import osukt.enums.GameMode

data class User(
    @Json(name = "user_id")
    val id: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "join_date")
    val joinDate: String,
    @Json(name = "count300")
    val count300: String,
    @Json(name = "count100")
    val count100: String,
    @Json(name = "count50")
    val count50: String,
    @Json(name = "playcount")
    val playcount: String,
    @Json(name = "ranked_score")
    val scoreRanked: String,
    @Json(name = "total_score")
    val scoreTotal: String,
    @Json(name = "pp_rank")
    val rankGlobal: String,
    @Json(name = "level")
    val level: String,
    @Json(name = "pp_raw")
    val ppRaw: String,
    @Json(name = "accuracy")
    val accuracy: String,
    @Json(name = "count_rank_ss")
    val countSs: String,
    @Json(name = "count_rank_ssh")
    val countSsh: String,
    @Json(name = "count_rank_s")
    val countS: String,
    @Json(name = "count_rank_sh")
    val countSh: String,
    @Json(name = "count_rank_a")
    val countA: String,
    @Json(name = "country")
    val country: String,
    @Json(name = "total_seconds_played")
    val timePlayedSeconds: String,
    @Json(name = "pp_country_rank")
    val rankCountry: String,
    @Json(name = "events")
    val events: List<Event?>
) {
    companion object {
        fun get(userId: String, gameMode: GameMode = GameMode.STANDARD, isUsername: Boolean = false): User =
            Klaxon().parseArray<User>(
                Client
                    .instance()
                    .get(
                        Endpoints.User, mutableMapOf(
                            "u" to userId,
                            "m" to gameMode.value.toString(),
                            "type" to if (isUsername) "string" else "id"
                        )
                    )
            )!![0]
    }

    override fun toString(): String {
        return "osu! User: $username Rank: #$rankGlobal (${country} #$rankCountry)"
    }
}
