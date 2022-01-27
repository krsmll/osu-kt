package osukt.enums

enum class Endpoint(val value: String) {
    OAuth("https://osu.ppy.sh/oauth/token"),
    Base("https://osu.ppy.sh/api/v2"),
    Images("https://s.ppy.sh/"),
    User("/users/%s"),
    UserScore("/users/%s/scores/%s"), // 1 = User, 2 = Score Type
    Beatmaps("/beatmaps/%s"),
    Scores("get_scores"),
    Match("get_match"),
    Replay("get_replay")
}