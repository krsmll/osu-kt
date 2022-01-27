package osukt.enums

import kotlinx.serialization.Serializable
import osukt.serializers.RankStatusSerializer

@Serializable(with = RankStatusSerializer::class)
enum class RankStatus(val value: Int, val status: String) {
    Unknown(-3, "Unknown"),
    Graveyard(-2, "graveyard"),
    Wip(-1, "wip"),
    Pending(0, "pending"),
    Ranked(1, "ranked"),
    Approved(2, "approved"),
    Qualified(3, "qualified"),
    Loved(4, "loved");

    companion object {
        fun fromInt(value: Int) = RankStatus.values().first { it.value == value }
    }
}