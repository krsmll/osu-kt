package osukt.domain.user

import kotlinx.serialization.Serializable

@Serializable
data class Kudosu(val total: Int, val available: Int)