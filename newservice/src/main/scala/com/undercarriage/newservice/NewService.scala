package com.undercarriage.newservice

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

object NewService extends App {
  val service = new Service[http.Request, http.Response] {
    def apply(req: http.Request): Future[http.Response] = {
      val resp = http.Response(req.version, http.Status.Ok)

      resp.setContentString(s"hello world from newservice")
      Future.value(resp)
    }
  }

  val server = Http.serve(":9003", service)
  Await.ready(server)
}

