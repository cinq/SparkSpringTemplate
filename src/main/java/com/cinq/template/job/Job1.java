package com.cinq.template.job;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Job1 code
 */
@Component
public class Job1 {

	public void run(JavaSparkContext jsc, String args[]){
		// Do something for fun
		String data[] = {"string1", "string2", "string3"};
		JavaRDD<String> sData = jsc.parallelize(Arrays.asList(data));
		sData.foreach(new VoidFunction<String>() {
			public void call(String s) throws Exception {
				System.out.println(s);
			}
		});
	}
}
