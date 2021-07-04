package osukt

/** Endpoints for the API. */
object Endpoints {
    val osuApiBase: String = "https://osu.ppy.sh/api/"

    val User: String = "get_user"
    val UserBest: String = "get_user_best"
    val UserRecent: String = "get_user_recent"
    val Beatmaps: String = "get_beatmaps"
    val Scores: String = "get_scores"
    val Match: String = "get_match"
    val Replay: String = "get_replay"
}