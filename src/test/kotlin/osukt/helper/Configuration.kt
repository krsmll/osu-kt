package osukt.helper

import java.io.File
import java.util.*

class Configuration {
    companion object {
        fun getClientInfo(): Properties = Properties().apply { load(File("config.properties").bufferedReader()) }
    }
}