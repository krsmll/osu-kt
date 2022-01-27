package osukt.client

import io.ktor.client.*
import io.ktor.client.call.*
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

class Client(private val clientId: Int, private val clientSecret: String) {

    private val httpClient: HttpClient

    init {
        clientInstance = this
        httpClient = HttpClient {
            expectSuccess = false
            ResponseObserver { response ->
                println("HTTP Status: ${response.status.value}")
            }
        }
        token = getAccessToken()
    }

    companion object {
        private var clientInstance: Client? = null
        private var token: Token? = null;

        fun instance(): Client = if (clientInstance != null) {
            clientInstance!!
        } else {
            throw RuntimeException(
                "Client hasn't been initialized. Please provide your client ID and client secret to authenticate."
            )
        }
    }

    internal fun get(url: String, queryParams: Map<String, Any>): String? {
        val response = runBlocking {
            httpClient.get<HttpResponse>(url) {
                headers {
                    append("Authorization", "Bearer ${token!!.accessToken}")
                    queryParams.forEach { parameter(it.key, it.value) }
                }
            }
        }

        return if (response.status.value in 200..299) runBlocking {
            response.receive()
        } else null
    }

    private fun getAccessToken(): Token? {
        val response = runBlocking {
            httpClient.request<HttpResponse> {
                url(Endpoint.OAuth.value)
                method = HttpMethod.Post
                body = TextContent(
                    text = Json.encodeToString(TokenRequest(clientId, clientSecret, "client_credentials", "public")),
                    contentType = ContentType.Application.Json
                )
            }
        }

        return if (response.status.value in 200..299) Json.decodeFromString<Token>(runBlocking {
            response.receive()
        }) else null
    }
}
