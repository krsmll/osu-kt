package osukt

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.json.responseJson
import osukt.enums.Endpoint

class Client(private val key: String) {

    init {
        clientInstance = this
    }

    companion object {
        private var clientInstance: Client? = null

        fun instance(): Client = if (clientInstance != null) {
            clientInstance!!
        } else {
            throw RuntimeException(
                "Client hasn't been initialized with an osu! API key. Please do so before trying to call other methods."
            )
        }
    }

    fun get(endpoint: Endpoint, queryString: MutableMap<String, String>): String {
        queryString["k"] = key
        val (_, response, result) = Fuel.get(
            Endpoint.Base.value + endpoint.value, queryString.toList()
        ).responseJson()

        if (response.statusCode != 200) {
            throw RuntimeException(response.responseMessage)
        }

        val (data, _) = result

        if (data != null) {
            return data.content
        } else {
            throw RuntimeException(response.responseMessage)
        }
    }
}
