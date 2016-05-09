import Dependencies._

lazy val helloworld = project.in(file("helloworld")).
  settings(Commons.settings: _*).
  settings(
    libraryDependencies ++= commonDependencies
  )

lazy val helloworldConsumer = Project("helloworld-consumer", file("helloworld-consumer")).
  settings(Commons.settings: _*).
  settings(
    libraryDependencies ++= commonDependencies
  ).
  dependsOn(helloworld)

lazy val newservice = (project in file("newservice")).
  settings(Commons.settings: _*).
  settings(
    libraryDependencies ++= commonDependencies
  )

lazy val services = (project in file("services")).
  settings(Commons.settings: _*).
  settings(
    libraryDependencies ++= commonDependencies
  )
