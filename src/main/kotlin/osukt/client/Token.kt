package osukt.client

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import osukt.serializers.ExpiresInSerializer

@Serializable
data class Token(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("token_type")
    val tokenType: String,
    @SerialName("expires_in")
    @Serializable(with = ExpiresInSerializer::class)
    val expiresIn: Long
)