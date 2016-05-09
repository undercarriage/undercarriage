package com.undercarriage.services

import com.twitter.finagle.Thrift

object Services {
  Thrift.client.withStatsReceiver(null).newIface()
}
