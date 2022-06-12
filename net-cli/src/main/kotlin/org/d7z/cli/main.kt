package org.d7z.cli

import java.net.InetSocketAddress
import java.net.NetworkInterface
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

fun main(args: Array<String>) {
    println("Hello World")
    val networkInterfaces = NetworkInterface.networkInterfaces()
    val inetAddress =
        networkInterfaces.flatMap { inet -> inet.interfaceAddresses.map { inet.name to it }.stream() }.toList()
    val open = DatagramChannel.open()
}
