package osukt

import osukt.client.Client
import osukt.domain.beatmap.Beatmap
import osukt.domain.user.Score
import osukt.domain.user.User
import osukt.enums.ScoreType
import osukt.enums.UserLookupType
import java.io.FileInputStream
import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val prop = Properties()
        val fis = FileInputStream("config.properties")
        prop.load(fis)
        fis.close()

        Client(
            prop.getProperty("CLIENT_ID").toInt(),
            prop.getProperty("CLIENT_SECRET")
        ) // Instance can be accessed using Client.instance()

        println(User.get("Slay", type = UserLookupType.Username))
        println(Beatmap.get(3400798))
        println(Score.get(7093124, type = ScoreType.Recent))
    }
}