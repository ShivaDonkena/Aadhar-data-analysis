package com.aadhar.analysis

import org.apache.spark.sql.{DataFrame, SparkSession}

object AadharDataFilter {

  def main(args: Array[String]): Unit = {
    val path: String = "A:\\bigdata\\UIDAI-ENR-DETAIL-20170308.csv"
    val spark: SparkSession = SparkSession.builder().master("local[2]").appName("AadharAanalysis").getOrCreate()
    val data: DataFrame = readFile(spark, path)

  }

  def readFile(sparkSession: SparkSession, path: String): DataFrame = {
    sparkSession.read.format("csv").option("header", true).load(path = path)
  }

}

