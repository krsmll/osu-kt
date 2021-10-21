package osukt.domain

import com.beust.klaxon.Json
import java.time.LocalDateTime

data class Event(
    @Json(name = "display_html")
    val displayHtml: String,
    @Json(name = "beatmap_id")
    val beatmapId: Long,
    @Json(name = "beatmapset_id")
    val beatmapSetId: Long,
    @Json(name = "date")
    val date: LocalDateTime,
    @Json(name = "epicfactor")
    val epicFactor: Int
)
