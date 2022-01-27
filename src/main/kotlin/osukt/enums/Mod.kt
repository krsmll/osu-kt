package osukt.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Mod(val shortName: String, val bitValue: Int) {
    @SerialName("NF") NoFail("NF", 1),
    @SerialName("EZ") Easy("EZ", 2),
    @SerialName("TD") TouchDevice("TD", 4),
    @SerialName("HD") Hidden("HD", 8),
    @SerialName("HR") HardRock("HR", 16),
    @SerialName("SD") SuddenDeath("SD", 32),
    @SerialName("DT") DoubleTime("DT", 64),
    @SerialName("RX") Relax("RX", 128),
    @SerialName("HT") HalfTime("HT", 256),
    @SerialName("NC") Nightcore("NC", 512),
    @SerialName("FL") Flashlight("FL", 1024),
    @SerialName("AT") Autoplay("AT", 2048),
    @SerialName("SO") SpunOut("SO", 4096),
    @SerialName("AP") AutoPilot("AP", 8192),
    @SerialName("PF") Perfect("PF", 16384),
    @SerialName("K4") Key4("K4", 32768),
    @SerialName("K5") Key5("K5", 65536),
    @SerialName("K6") Key6("K6", 131072),
    @SerialName("K7") Key7("K7", 262144),
    @SerialName("K8") Key8("K8", 524288),
    @SerialName("FI") FadeIn("FI", 1048576),
    @SerialName("RD") Random("RD", 2097152),
    @SerialName("CN") Cinema("CN", 4194304),
    @SerialName("TR") Target("TR", 8388608),
    @SerialName("K9") Key9("K9", 16777216),
    @SerialName("KC") KeyCoop("KC", 33554432),
    @SerialName("K1") Key1("K1", 67108864),
    @SerialName("K3") Key3("K3", 134217728),
    @SerialName("K2") Key2("K2", 268435456),
    @SerialName("V2") ScoreV2("V2", 536870912),
    @SerialName("MR") Mirror("MR", 1073741824)
}