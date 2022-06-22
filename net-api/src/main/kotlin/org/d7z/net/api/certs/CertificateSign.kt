package org.d7z.net.api.certs

/**
 * 证书签名（一般）
 */
interface CertificateSign {
    /**
     * 证书签名版本
     */
    val version: Int

    /**
     * 签名算法
     */
    val algorithm: String

    /**
     * 签名内容
     */
    val sign: ByteArray

    /**
     * 证书信息
     */
    val cert: Certificate
}
