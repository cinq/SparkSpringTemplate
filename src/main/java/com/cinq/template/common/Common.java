package com.cinq.template.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Some common methods to facilitate
 */
@Service
public class Common implements Serializable {

	public String parseSomething(String str){
		if ( StringUtils.isNotBlank(str) ) {
			return str;
		} else {
			return "unknown";
		}
	}
}
