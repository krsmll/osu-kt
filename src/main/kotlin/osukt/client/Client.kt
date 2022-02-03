package osukt.client

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.content.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import osukt.enums.Endpoint
import java.util.*

class Client(private val clientId: Int, private val clientSecret: String) {

    private val HTTP_CLIENT: HttpClient
    private val GRANT_TYPE = "client_credentials"
    private val SCOPE = "public"

    init {
        HTTP_CLIENT = HttpClient(CIO) {
            expectSuccess = false
            ResponseObserver { response ->
                println("HTTP Status: ${response.status.value}")
            }
        }

        clientInstance = this
        token = getAccessToken()
    }

    companion object {
        private var clientInstance: Client? = null
        private var token: Token? = null

        internal fun instance(): Client = clientInstance ?: throw RuntimeException(
            "Client hasn't been initialized. Please provide your client ID and client secret to authenticate."
        )
    }

    internal fun get(url: String, queryParams: Map<String, Any>): String? =
        runBlocking {
            if (System.currentTimeMillis() > token!!.expiresIn) token = getAccessToken()

            HTTP_CLIENT.get<HttpResponse>(url) {
                headers {
                    append("Authorization", "Bearer ${token!!.accessToken}")
                    queryParams.forEach { parameter(it.key, it.value) }
                }
            }
        }.let {
            when (it.status.value) {
                in 200..299 -> runBlocking { it.receive() }
                else -> null
            }
        }

    private fun getAccessToken(): Token? = runBlocking {
        HTTP_CLIENT.request<HttpResponse> {
            url(Endpoint.OAuth.value)
            method = HttpMethod.Post
            body = TextContent(
                text = Json.encodeToString(TokenRequest(clientId, clientSecret, GRANT_TYPE, SCOPE)),
                contentType = ContentType.Application.Json
            )
        }
    }.let {
        if (it.status.value in 200..299) {
            Json.decodeFromString<Token>(runBlocking { it.receive() })
        } else null
    }

    internal fun useOutdatedToken() {
        token = Token(
            token!!.accessToken,
            token!!.tokenType,
            System.currentTimeMillis() - 1000000
        )
    }
}