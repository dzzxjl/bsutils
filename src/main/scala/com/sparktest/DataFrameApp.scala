package com.sparktest

import org.apache.spark.sql.SparkSession

object DataFrameApp {
	def main(args: Array[String]): Unit = {

		val spark = SparkSession.builder().appName("DataFrameApp").master("local[2]").getOrCreate()

		// 第一种：Spark中使用toDF函数创建DataFrame
		import spark.implicits._
		val df = Seq(
			(1, "First Value", java.sql.Date.valueOf("2010-01-01")),
			(2, "Second Value", java.sql.Date.valueOf("2010-02-01"))
		).toDF("int_column", "string_column", "date_column")

		df.show(100)


		// 第二种：Spark中使用createDataFrame函数创建DataFrame
		// val schema = StructType(List(
		//   StructField("integer_column", IntegerType, nullable = false),
		//   StructField("string_column", StringType, nullable = true),
		//   StructField("date_column", DateType, nullable = true)
		// ))
		//
		// val sc = spark.sparkContext
		// val rdd = sc.parallelize(Seq(
		//   Row(1, "First Value", java.sql.Date.valueOf("2010-01-01")),
		//   Row(2, "Second Value", java.sql.Date.valueOf("2010-02-01"))
		// ))
		// val df = spark.createDataFrame(rdd, schema)
		// df.show(100)


		// 第三种：通过文件创建DataFrame

		// //把json文件加载成DataFrame
		// val path = "/Users/dzzxjl/people.json"
		// val peopledataframe = spark.read.format("json").load("file:///Users/dzzxjl/people.json")
		//
		// //输出dataframe对应的Schema信息
		// peopledataframe.printSchema()
		// peopledataframe.select("name").show()

		spark.stop()

	}
}
