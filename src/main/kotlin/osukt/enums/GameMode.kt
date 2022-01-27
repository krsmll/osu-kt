package osukt.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GameMode(val value: Int, val standardizedName: String, val lookupName: String) {
    @SerialName("osu") Standard(0, "osu!", "osu"),
    @SerialName("taiko") Taiko(1, "osu!taiko", "taiko"),
    @SerialName("fruits") Catch(2, "osu!catch", "fruits"),
    @SerialName("mania") Mania(3, "osu!mania", "mania")
}