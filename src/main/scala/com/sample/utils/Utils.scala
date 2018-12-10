package com.sample.utils

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object Utils {

  def sparkInit(): SparkSession =
    SparkSession.builder
      .appName("Simple Application")
      .config("spark.master", "local")
      .config("spark.driver.bindAddress", "127.0.0.1")
      .getOrCreate()

  def readInput(
      path: String =
        "/home/bala/bala/Learning/SparkSampleProject/Data/German_Credit.csv")(
      implicit sparkSession: SparkSession): DataFrame = {
    sparkSession.read
      .format("csv")
      .option("header", "true")
      .option("nullValue", "NA")
      .option("inferSchema", "true")
      .load(s"file:$path")
  }

  def writeTo(path: String, dataFrame: DataFrame) = {
    dataFrame
      .coalesce(1)
      .write
      .mode(SaveMode.Overwrite)
      .option("header", "true")
      .csv(path)
  }
}
