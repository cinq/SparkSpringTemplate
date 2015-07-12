package com.cinq.template.app;

import com.cinq.template.job.Job1;
import com.cinq.template.job.Job2;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.Serializable;

/**
 * Starting point to launch all Spark application
 */
public class Start implements Serializable {

	final private static Logger logger = LoggerFactory.getLogger(Start.class);

	public static void main(String[] args) {
		if ( args == null || args.length < 1 || StringUtils.isNotBlank(args[0]) ) {
			usage();
			throw new IllegalArgumentException("You need to pass at least the name of the job to start.");
		}

		SparkConf sparkConf = new SparkConf().setAppName("Start " + args[0]);
		JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SparkDi.class);

		switch(args[0]){
			case StartConstants.job1:
				try {
					Job1 job1 = ctx.getBean(Job1.class);
					job1.run(javaSparkContext, args);
				} catch (BeansException be) {
					be.printStackTrace();
				}
				break;
			case StartConstants.job2:
				try {
					Job2 job2 = ctx.getBean(Job2.class);
					job2.run(javaSparkContext, args);
					job2.runSomethingElse(javaSparkContext, args);
				} catch ( BeansException be ) {
					be.printStackTrace();
				}
				break;
			default:
				logger.error("Could not find the job to run");
		}
	}

	private static void usage() {
		StringBuilder str = new StringBuilder();
		str.append("You need to pass at least 1 argument to this job starter:\n");
		str.append("\t1. The name of the job to start");

		System.out.println(str.toString());
		logger.info(str.toString());
	}
}
