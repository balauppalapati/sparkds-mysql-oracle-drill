package com.sample.datasources

import java.util.Properties
import com.sample.utils.Utils._

object MySql {

  def main(args: Array[String]) = {
    val spark = sparkInit()

    val url = "jdbc:mysql://localhost:3306/trial"
    val (user, password) = ("root", "root")
    val inputTableName = "test"
    val props = new Properties()
    props.put("user", user)
    props.put("password", password)
    props.put("driver", "com.mysql.jdbc.Driver")
    props.put("numPartitions", "10")

    val df = spark.read.jdbc(url, inputTableName, props)
    df.show()
    df.write.jdbc(url, "output_table3", props)
  }
}
