package osukt.api

import org.junit.jupiter.api.Test
import osukt.client.Client
import osukt.domain.user.Score
import osukt.enums.GameMode
import osukt.enums.ScoreType
import osukt.helper.Configuration
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ScoreTests {
    private val client: Client

    init {
        val prop = Configuration.getClientInfo()
        client = Client(prop.getProperty("CLIENT_ID").toInt(), prop.getProperty("CLIENT_SECRET"))
    }

    @Test
    fun `Ensure getting recent scores works`() {
        val scores = Score.get(7093124, type = ScoreType.Recent, includeFails = true)

        assertNotNull(scores, "Recent score should not be null.")
    }

    @Test
    fun `Ensure getting best scores works`() {
        val scores = Score.get(7093124, type = ScoreType.Best)

        assertNotNull(scores, "Best scores should not be null.")
    }

    @Test
    fun `Ensure limiting amount of scores works`() {
        val scores = Score.get(7093124, type = ScoreType.Best, limit = 3)


        assertNotNull(scores, "Scores should not be null.")
        assert(scores.size == 3) { "Scores size should be 3." }
    }

    @Test
    fun `Ensure getting scores by specifying game mode works`() {
        val scores = Score.get(7093124, type = ScoreType.Best, mode = GameMode.Mania)

        assertNotNull(scores, "Scores should not be null.")
        assertEquals(GameMode.Mania, scores[0].mode, "Game mode should have been ${GameMode.Mania.standardizedName}")
    }
}