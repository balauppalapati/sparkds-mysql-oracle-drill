name := "SparkDataSources"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.4.0"

resolvers += Resolver.mavenLocal
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "mysql" % "mysql-connector-java" % "8.0.12",
  "org.apache.drill.exec" % "drill-jdbc-all" % "1.10.0" exclude ("org.slf4j", "log4j-over-slf4j")
)
