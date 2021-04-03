name := "SlickProject"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3"
)

libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.5" % Test