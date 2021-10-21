package osukt.enums

enum class Endpoint(val value: String) {
    Base("https://osu.ppy.sh/api/"),
    User("get_user"),
    UserBest("get_user_best"),
    UserRecent("get_user_recent"),
    Beatmaps("get_beatmaps"),
    Scores("get_scores"),
    Match("get_match"),
    Replay("get_replay")
}