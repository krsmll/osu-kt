package osukt

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.json.responseJson

class Client(private val key: String) {

    init {
        clientInstance = this
    }

    companion object {
        private var clientInstance: Client? = null

        fun instance(): Client = if (clientInstance != null) {
            clientInstance!!
        } else {
            throw java.lang.RuntimeException(
                "Client hasn't been initialized with an osu! API key. Please do so before trying to call other methods."
            )
        }
    }

    private val url: String = "https://osu.ppy.sh/api/"

    fun get(endpoint: String, queryString: MutableMap<String, String>): String {
        queryString["k"] = key
        val (_, response, result) = Fuel.get(
            url + endpoint, queryString.toList()
        ).responseJson()



        if (response.statusCode != 200) {
            throw RuntimeException(response.responseMessage)
        }

        val (data, _) = result

        if (data != null) {
            println(data.content)
            return data.content
        } else {
            throw RuntimeException(response.responseMessage)
        }
    }
}
