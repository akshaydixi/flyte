name := "flyte-service"

version := "1.0"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-feature")


resolvers ++= Seq(
  "Spray repository" at "http://repo.spray.io",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= {
  val akkaV = "2.3.6"
  val sprayV = "1.3.2"
  Seq(
    "io.spray" %% "spray-can" % sprayV,
    "io.spray" %% "spray-http" % sprayV,
    "io.spray" %% "spray-routing" % sprayV,
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "org.specs2" %% "specs2-core" % "2.3.11" % "test",
    "net.liftweb" %% "lift-json" % "2.5.1",
    "ch.qos.logback" % "logback-classic" % "1.0.13"
  )
}

libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"

libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

libraryDependencies += "de.l3s.boilerpipe" % "boilerpipe" % "1.1.0"

libraryDependencies += "xerces" % "xercesImpl" % "2.9.1"

libraryDependencies += "net.sourceforge.nekohtml" % "nekohtml" % "1.9.13"

Revolver.settings