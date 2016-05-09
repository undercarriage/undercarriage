import sbt._
import Keys._

object Commons {
  val settings: Seq[Def.Setting[_]] = Seq(
    organization := "com.undercarriage",
    version := "0.1.0",
    scalaVersion := "2.11.8",
    resolvers += "twitter-repo" at "https://maven.twttr.com"
  )
}