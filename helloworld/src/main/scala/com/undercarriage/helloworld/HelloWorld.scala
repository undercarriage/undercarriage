package com.undercarriage.helloworld

import com.twitter.finagle.Thrift
import com.twitter.util.Await

object HelloWorld extends App {
  val server = Thrift.serveIface(":8080", new HelloWorldImpl)
  Await.ready(server)
}