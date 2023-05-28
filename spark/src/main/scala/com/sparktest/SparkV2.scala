package com.sparktest

import org.apache.spark.sql.SparkSession

object SparkV2 {

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("SparkByExamples.com")
      .getOrCreate()

    import spark.implicits._

    val df = Seq(
      (1, 2, 3),
      (4, 5, 6)
    ).toDF()

    // println(df)
    df.show()

  }

}
