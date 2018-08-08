logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.6.17")

//Coverage plugin
addSbtPlugin("com.github.sbt" % "sbt-jacoco" % "3.1.0")

//Ebean plugin
addSbtPlugin("com.typesafe.sbt" % "sbt-play-ebean" % "4.1.3")