import sbt._

object Dependencies {
  val finagleVersion = "6.34.0"
  val libThriftVersion = "0.8.0"
  val scroogeVersion = "4.6.0"

  val finagleCore = "com.twitter" %% "finagle-core" % finagleVersion
  val finagleThrift = "com.twitter" %% "finagle-thrift" % finagleVersion
  val finagleHttp = "com.twitter" %% "finagle-http" % finagleVersion

  val scrooge = "com.twitter" %% "scrooge-core" % scroogeVersion

  val libThrift = "org.apache.thrift" % "libthrift" % libThriftVersion

  val commonDependencies: Seq[ModuleID] = Seq(
    finagleCore,
    finagleThrift,
    finagleHttp,
    scrooge,
    libThrift
  )
}