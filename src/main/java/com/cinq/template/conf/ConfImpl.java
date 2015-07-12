package com.cinq.template.conf;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Configuration implementation
 */
@Service
public class ConfImpl implements Conf, Serializable {

	public String getItem1() {
		return item1;
	}

	public String getItem2(){
		return item2;
	}
}
