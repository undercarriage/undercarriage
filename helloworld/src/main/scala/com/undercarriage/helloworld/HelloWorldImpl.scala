package com.undercarriage.helloworld

import com.twitter.util.Future
import com.undercarriage.helloworld.thriftscala.{HelloWorldRequest, HelloWorldResponse, HelloWorldService}

class HelloWorldImpl extends HelloWorldService[Future] {
  override def toUpperCase(request: HelloWorldRequest): Future[HelloWorldResponse] = {
    val responseMessage = request.message.map(_.toUpperCase)
    Future.value(HelloWorldResponse(responseMessage))
  }
}
