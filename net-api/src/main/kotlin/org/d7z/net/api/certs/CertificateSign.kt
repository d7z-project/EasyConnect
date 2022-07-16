package org.d7z.net.api.certs

/**
 *
 * 证书签名数据
 *
 * @property cert Certificate 证书内容
 * @property algorithm String 证书签名算法
 * @property sign String 签名结果
 * @constructor
 */
data class CertificateSign(
    val cert: Certificate,
    val algorithm: String,
    val sign: String
)
