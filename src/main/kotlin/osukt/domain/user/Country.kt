package osukt.domain.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("code")
    val code: String,
    @SerialName("name")
    val name: String
)