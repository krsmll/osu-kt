package osukt.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import osukt.enums.RankStatus

@Serializer(forClass = RankStatus::class)
object RankStatusSerializer : KSerializer<RankStatus> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("RankStatus", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): RankStatus {
        return try {
            val key: Int = decoder.decodeInt()
            RankStatus.fromInt(key)
        } catch (e: IllegalArgumentException) {
            RankStatus.Unknown
        }
    }

    override fun serialize(encoder: Encoder, value: RankStatus) {
        encoder.encodeInt(value.value)
    }
}