package com.undercarriage.helloworld

import java.util.concurrent.{ScheduledThreadPoolExecutor, TimeUnit}

import com.twitter.finagle.Thrift
import com.twitter.util.{Await, Future}
import com.undercarriage.helloworld.thriftscala.{HelloWorldRequest, HelloWorldService}

import scala.util.Try

object HelloWorldConsumer extends App {
  val helloworldHost = sys.env("HELLOWORLD_SERVICE_HOST")
  val helloworldPort = sys.env("HELLOWORLD_SERVICE_PORT")
  val client = Thrift.newIface[HelloWorldService[Future]](s"$helloworldHost:$helloworldPort")

  val ex = new ScheduledThreadPoolExecutor(1)
  val task = new Runnable {
    def run() = {
      val respFuture = Try(client.toUpperCase(HelloWorldRequest(Some("lowercase"))))
      respFuture.toOption
        .map { resp => Await.result(resp) }
        .foreach { resp => println(resp.response.getOrElse("empty")) }
    }
  }

  val f = ex.scheduleAtFixedRate(task, 1, 1, TimeUnit.SECONDS)
}
