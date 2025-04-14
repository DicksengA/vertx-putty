package com.balonglong

import org.apache.sshd.client.SshClient
import org.apache.sshd.common.channel.PtyChannelConfiguration
import org.apache.sshd.common.channel.StreamingChannel
import java.net.InetSocketAddress
import java.util.concurrent.CountDownLatch

object MyMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val countDownLatch = CountDownLatch(1);
        val client = SshClient.setUpDefaultSimpleClient()
        val  address = InetSocketAddress.createUnresolved("localhost",2222);
        val session = client.sessionLogin(address,"", "")
        val config = PtyChannelConfiguration()
        config.ptyType = "xterm-256color"

        val channel = session.createShellChannel(config, mutableMapOf<String,Int>())
        channel.isRedirectErrorStream = true;
        channel.out = System.out
        channel.`in` = System.`in`
        channel.open()
        channel.streaming = StreamingChannel.Streaming.Sync
//
//        channel.channelListenerProxy.channelClosed(channel,NullPointerException());
        channel.addCloseFutureListener {
            it.await(5000)
            countDownLatch.countDown()
        }

        countDownLatch.await()

    }
}
