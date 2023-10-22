package io.github.dzzxjl.sparktest

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by yangyibo on 16/11/21.
 */
object SparkV1 {

	def main(args: Array[String]) {

		// 本机的spark就用local，远端的就写ip
		// 如果是打成jar包运行则需要去掉 setMaster("local")因为在参数中会指定。

		val conf = new SparkConf()
			.setAppName("mySpark")
			.setMaster("local")

		val sc = new SparkContext(conf)

		// val rdd = sc.parallelize(List(1,2,3,4,5,6)).map(_*3)
		val rdd = sc.parallelize(List(1, 2, 3, 4, 5, 6))
		// val rdd = sc.parallelize(List(1, 2, 3, 4, 5, 6))


		val filterRDD = rdd.filter(_ >= 3)
		println(filterRDD.collect())
		//    val mappedRDD = rdd.filter(_>10).collect()
		//    //对集合求和
		//    println(rdd.reduce(_+_))
		//    //输出大于10的元素
		for (arg <- filterRDD)
			print(arg + " ")


		// tmp change

	}
}
