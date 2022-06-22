package org.d7z.net.api.certs

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Calendar

/**
 * 证书接口抽象
 */
/**
 *
 * @property id String 证书ID，需要保证同根证书签发的所有证书UUID均不一致
 * @property before LocalDateTime 证书有效期不早于此时间
 * @property after LocalDateTime 证书有效期不晚于此时间
 * @property algorithm String 证书算法名称（全大写，例如 `RSA`）
 * @property publicKey ByteArray 公钥信息
 * @property sign List<ICertificateSign> 证书签名
 * @constructor
 */
data class Certificate(
    val id: String,
    val before: LocalDateTime,
    val after: LocalDateTime,
    val algorithm: String,
    val publicKey: ByteArray,
    val sign: List<CertificateSign>,
) {
    fun bytes(): ByteArray {
        """
        id=$id
        before=$before
        """.lines().filter { it.isNotBlank() }.let {
            StringBuilder().apply {
                it.forEach { data -> this.append(data.trim()).append("\r\n") }
            }.toString().toByteArray(Charsets.ISO_8859_1)
        }
        TODO()
    }

    companion object {
        private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        private val base64Encoder = Base64.getEncoder()
        private val base64Decoder = Base64.getDecoder()

        fun from(arr: ByteArray, gzip: Boolean = false): Certificate {
            val time = Calendar.getInstance()
            time.timeZone.getOffset(time.timeInMillis)
            TODO()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Certificate

        if (id != other.id) return false
        if (before != other.before) return false
        if (after != other.after) return false
        if (algorithm != other.algorithm) return false
        if (!publicKey.contentEquals(other.publicKey)) return false
        if (sign != other.sign) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + before.hashCode()
        result = 31 * result + after.hashCode()
        result = 31 * result + algorithm.hashCode()
        result = 31 * result + publicKey.contentHashCode()
        result = 31 * result + sign.hashCode()
        return result
    }
}
