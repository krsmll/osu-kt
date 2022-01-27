package osukt.domain.beatmap

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Availability(
    @SerialName("download_disabled")
    val downloadDisabled: Boolean,
    @SerialName("more_information")
    val moreInformation: String?
)