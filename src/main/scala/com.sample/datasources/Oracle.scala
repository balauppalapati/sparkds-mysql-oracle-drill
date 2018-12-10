package com.sample.datasources

import java.util.Properties
import com.sample.utils.Utils._

object Oracle {

  def main(args: Array[String]) = {
    val spark = sparkInit()

    //    val url = "jdbc:oracle:thin:root/root@//localhost:1521/XE"
    val url = "jdbc:oracle:thin:@//localhost:1521/XE"
    val (user, password) = ("root", "root")
    val inputTableName = "trial"
    val props = new Properties()
    props.put("user", user)
    props.put("password", password)
    props.put("driver", "oracle.jdbc.driver.OracleDriver")
    props.put("numPartitions", "10")
    val df = spark.read.jdbc(url, inputTableName, props)

    df.write.jdbc(url, "outputTable", props)
  }
}
