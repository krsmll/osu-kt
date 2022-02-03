package osukt.api

import org.junit.jupiter.api.Test
import osukt.client.Client
import osukt.domain.user.User
import osukt.enums.UserLookupType
import osukt.helper.Configuration
import kotlin.test.assertNotNull

class ClientTests {

    private val client: Client

    init {
        val prop = Configuration.getClientInfo()
        client = Client(prop.getProperty("CLIENT_ID").toInt(), prop.getProperty("CLIENT_SECRET"))
    }

    @Test
    fun `Ensure access token gets refreshed in case it is outdated`() {
        client.useOutdatedToken()

        val user = User.get("Slay", type = UserLookupType.Username)

        assertNotNull(user, "Access token did not refresh.")
    }
}