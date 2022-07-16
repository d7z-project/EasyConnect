package org.d7z.net.api.certs

import java.time.LocalDateTime

/**
 *  证书信息
 *
 * @property id String 证书ID，需要保证同根证书签发的所有证书UUID均不一致
 * @property before LocalDateTime 证书有效期不早于此时间
 * @property after LocalDateTime 证书有效期不晚于此时间
 * @property algorithm String 证书算法名称（全大写，例如 `RSA`）
 * @property publicKey String 公钥信息(Base64编码)
 * @property sign List<ICertificateSign> 证书签名
 * @constructor
 */
data class Certificate(
    val id: String,
    val before: LocalDateTime,
    val after: LocalDateTime,
    val algorithm: String,
    val publicKey: String,
    val sign: List<CertificateSign>
)
