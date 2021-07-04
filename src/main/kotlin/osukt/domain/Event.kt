package osukt.domain

import com.beust.klaxon.Json

data class Event(
    @Json(name = "display_html")
    val displayHtml: String,
    @Json(name = "beatmap_id")
    val beatmapId: String,
    @Json(name = "beatmapset_id")
    val beatmapSetId: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "epicfactor")
    val epicFactor: String
)
