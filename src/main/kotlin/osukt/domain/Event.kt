package osukt.domain

import java.time.LocalDateTime

data class Event(
    val displayHtml: String, // TODO: Parse this.
    val beatmapId: Long,
    val beatmapSetId: Long,
    val date: LocalDateTime,
    val epicFactor: Int
)
