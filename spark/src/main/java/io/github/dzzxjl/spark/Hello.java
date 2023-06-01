package io.github.dzzxjl.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;


public class Hello {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("HelloWorld").setMaster("local").setSparkHome("/usr/lib/spark/spark-2.1.1-bin-hadoop2.7");
        // setMaster指定Master
        // setSparkHome指向安装spark的地址，视环境而定
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> data = sc.textFile("README.md");
        // 加载README.md文件并创建RDD
        data.foreach(new VoidFunction<String>() {
            public void call(String s) throws Exception {
                System.out.println(s);
            }
        });
        // 输出RDD中的每个分区的内容

    }


}
