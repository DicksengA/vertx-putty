package com.balonglong

import io.vertx.core.Handler
import io.vertx.ext.shell.ShellService
import io.vertx.ext.shell.cli.Completion
import io.vertx.ext.shell.session.Session
import io.vertx.ext.shell.term.SignalHandler
import io.vertx.ext.shell.term.Term
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.apache.sshd.client.SshClient
import org.apache.sshd.client.channel.ClientChannelEvent
import org.junit.jupiter.api.Test
import java.net.InetSocketAddress
import java.util.*
import java.util.concurrent.TimeUnit


class ATest {


    @Test
    fun aTest():Unit= runBlocking {
        val client = SshClient.setUpDefaultSimpleClient()
         val  address = InetSocketAddress.createUnresolved("localhost",2222);
        val session = client.sessionLogin(address,"", "")
        val channel = session.createExecChannel("pwd")
        channel.isRedirectErrorStream = true;
        channel.out = System.out
        channel.`in` = System.`in`
        channel.open()

        val events: Set<ClientChannelEvent> =
            channel.waitFor(EnumSet.of(ClientChannelEvent.CLOSED), TimeUnit.SECONDS.toMillis(5000))

        session.close()
    }

    fun abcv(){
        val term = object :Term{
            override fun type(): String {
                TODO("Not yet implemented")
            }

            override fun width(): Int {
                TODO("Not yet implemented")
            }

            override fun height(): Int {
                TODO("Not yet implemented")
            }

            override fun stdinHandler(p0: Handler<String>?): Term {
                TODO("Not yet implemented")
            }

            override fun write(p0: String?): Term {
                TODO("Not yet implemented")
            }

            override fun resizehandler(p0: Handler<Void>?): Term {
                TODO("Not yet implemented")
            }

            override fun lastAccessedTime(): Long {
                TODO("Not yet implemented")
            }

            override fun echo(p0: String?): Term {
                TODO("Not yet implemented")
            }

            override fun setSession(p0: Session?): Term {
                TODO("Not yet implemented")
            }

            override fun interruptHandler(p0: SignalHandler?): Term {
                TODO("Not yet implemented")
            }

            override fun suspendHandler(p0: SignalHandler?): Term {
                TODO("Not yet implemented")
            }

            override fun readline(p0: String?, p1: Handler<String>?) {
                TODO("Not yet implemented")
            }

            override fun readline(p0: String?, p1: Handler<String>?, p2: Handler<Completion>?) {
                TODO("Not yet implemented")
            }

            override fun closeHandler(p0: Handler<Void>?): Term {
                TODO("Not yet implemented")
            }

            override fun close() {
                TODO("Not yet implemented")
            }

        }




    }

    @Test
    fun aTest2():Unit= runBlocking {
        val client = SshClient.setUpDefaultSimpleClient()
        val address = InetSocketAddress.createUnresolved("localhost",2222);
        val session = client.sessionLogin(address,"", "")
        val channel = session.createShellChannel()
        channel.isRedirectErrorStream = true;
        channel.out = System.out
        channel.`in` = System.`in`
        channel.open()

        val events: Set<ClientChannelEvent> =
            channel.waitFor(EnumSet.of(ClientChannelEvent.CLOSED), TimeUnit.SECONDS.toMillis(5000))

        session.close()


    }
}