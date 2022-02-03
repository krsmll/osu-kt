package osukt.api

import org.junit.jupiter.api.Test
import osukt.client.Client
import osukt.domain.user.User
import osukt.enums.UserLookupType
import osukt.helper.Configuration
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

internal class UserTests {

    private val client: Client

    init {
        val prop = Configuration.getClientInfo()
        client = Client(prop.getProperty("CLIENT_ID").toInt(), prop.getProperty("CLIENT_SECRET"))
    }

    @Test
    fun `Ensure User JSON data gets deserialized correctly, and User get() method returns`() {
        val user = User.get("Slay", type = UserLookupType.Username)

        assertNotNull(user, "User should not be null.")
        assertEquals("Slay", user.username)
    }

    @Test
    fun `Ensure User is null if restricted on Bancho`() {
        val user = User.get("chef", type = UserLookupType.Username)

        assertNull(user, "User should have been null.")
    }

    @Test
    fun `Ensure User works with users grayed out and inactive on Bancho`() {
        val user = User.get("Hitoyomi", type = UserLookupType.Username)

        assertNotNull(user, "User should not be null.")
    }

    @Test
    fun `Ensure getting User with ID works`() {
        val user = User.get("124493", type = UserLookupType.Id)

        assertNotNull(user, "User should not be null.")
    }

    @Test
    fun `Ensure getting User with no type specified works, and defaults to ID lookup`() {
        val user = User.get("124493")

        assertNotNull(user, "User should not be null.")
    }
}