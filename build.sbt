scalaVersion := "2.12.15"

inThisBuild(
  libraryDependencies ++= List(
    "org.mockito" % "mockito-core" % "2.23.4",
    "junit" % "junit" % "4.9"
  )
)

val legacy = project.settings(
  libraryDependencies += "org.mockito" % "mockito-core" % "2.23.4",
)
val migrated = project.settings(
  libraryDependencies += "org.mockito" % "mockito-core" % "3.6.0",
  libraryDependencies += "org.mockito" % "mockito-inline" % "3.6.0",
)
