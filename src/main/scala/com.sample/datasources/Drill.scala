package com.sample.datasources

import com.sample.utils.Utils._

object Drill {
  def main(args: Array[String]) = {
    val spark = sparkInit()

    //Read from hive
    val df = spark.read
      .format("jdbc")
      //Hive Configs
      .option("url", "jdbc:drill:zk=192.168.0.137:2181;schema=hive;")
      .option("driver", "org.apache.drill.jdbc.Driver")
      .option("dbtable", "\"default\".\"test2\"")
      .load()

    /* Drill-Local : CSV, JSON
      .option("url", "jdbc:drill:zk=192.168.1.9:2181;schema=dfs;")
      .option("driver", "org.apache.drill.jdbc.Driver")
      .option("dbtable", "root.\"test.csv\"")
      .load()
     */

    //Write to local file system.
    df.write
      .format("jdbc")
      .option("url", "jdbc:drill:zk=192.168.0.13:2181;schema=dfs;")
      .option("driver", "org.apache.drill.jdbc.Driver")
      .option("dbtable", "\"tmp\".\"test3.csv\"")
      .save()
  }
}

