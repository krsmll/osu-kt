package osukt.domain

import com.beust.klaxon.Klaxon
import osukt.Client
import osukt.domain.converters.UserConverter
import osukt.enums.Endpoint
import osukt.enums.GameMode
import java.time.LocalDateTime

data class User(
    val id: Long,
    val username: String,
    val joinDate: LocalDateTime,
    val count300: Long,
    val count100: Long,
    val count50: Long,
    val playcount: Int,
    val scoreRanked: Long,
    val scoreTotal: Long,
    val rankGlobal: Int,
    val level: Float,
    val ppRaw: Int,
    val accuracy: Float,
    val countSs: Int,
    val countSsh: Int,
    val countS: Int,
    val countSh: Int,
    val countA: Int,
    val country: String,
    val timePlayedSeconds: Long,
    val rankCountry: String,
    val events: List<Event?>
) {
    companion object {
        val userConverter: UserConverter = UserConverter()

        fun get(userId: String, gameMode: GameMode = GameMode.STANDARD, isUsername: Boolean = false): User =
            Klaxon()
                .converter(userConverter)
                .parseArray<User>(
                Client
                    .instance()
                    .get(
                        Endpoint.User, mutableMapOf(
                            "u" to userId,
                            "m" to gameMode.value.toString(),
                            "type" to if (isUsername) "string" else "id"
                        )
                    )
            )!![0]
    }

    override fun toString(): String {
        return "User: $username Rank: $rankGlobal (#$rankCountry)"
    }
}
