package osukt

import osukt.domain.Scores
import osukt.domain.User
import osukt.helpers.ModUtils
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
            prop.getProperty(
                "OSU_KEY"
            )
        ) // Instance can be accessed using Client.instance()

        val user = User.get("Slay", isUsername = true)
        val scores = Scores.get("Slay", "2803688", isUsername = true)
        println(user)
        println(scores)

        println(ModUtils.modsToString(9))
        println(ModUtils.parseMods("HDNF"))
    }
}