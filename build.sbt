name := "play-asynchronous-http-programming"

version := "1.0.0"

scalaVersion := "2.13.0"

libraryDependencies += guice

lazy val root = (project in file(".")).enablePlugins(PlayJava)