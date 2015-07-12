package com.cinq.template.job;

import com.cinq.template.conf.ConfImpl;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Job2 code
 */
@Component
public class Job2 {

	final private static Logger logger = LoggerFactory.getLogger(Job2.class);
	@Autowired
	ConfImpl conf;

	public void run(JavaSparkContext jsc, String args[]){
		logger.info(conf.getItem1());
	}

	public void runSomethingElse(JavaSparkContext jsc, String args[]){
		logger.info(conf.getItem2());
	}
}
