package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradeCounts(
    @SerialName("ss")
    val ss: Int,
    @SerialName("ssh")
    val ssh: Int,
    @SerialName("s")
    val s: Int,
    @SerialName("sh")
    val sh: Int,
    @SerialName("a")
    val a: Int
)