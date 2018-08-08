
name := "pocketpillsassignmentbase"
 
version := "1.0" 
      
lazy val `pocketpillsassignmentbase` = (project in file(".")).enablePlugins(PlayJava)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
scalaVersion := "2.11.11"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

libraryDependencies += javaJdbc

libraryDependencies += guice

libraryDependencies += evolutions

libraryDependencies += "org.postgresql" % "postgresql" % "42.1.4"

// https://mvnrepository.com/artifact/org.mindrot/jbcrypt
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.4"

// enable Play cache API (based on your Play version)
libraryDependencies += play.sbt.PlayImport.cacheApi
// include play-redis library
libraryDependencies += "com.github.karelcemus" %% "play-redis" % "2.2.0"

// https://mvnrepository.com/artifact/de.mkammerer/argon2-jvm
libraryDependencies += "de.mkammerer" % "argon2-jvm" % "2.4"

jacocoReportSettings := JacocoReportSettings()
  .withThresholds(
    JacocoThresholds(
      instruction = 80,
      method = 100,
      branch = 100,
      complexity = 100,
      line = 90,
      clazz = 100)
  )

jacocoExcludes in Test := Seq(
  "controllers.Reverse*",
  "views.*",
  "controllers.javascript.*",
  "jooq.*",
  "Module",
  "router.Routes*",
  "*.routes*"
)

lazy val myProject = (project in file(".")).enablePlugins(PlayJava, PlayEbean)
