package com.in28minumtes.spring.aop.springaop.data;

import org.springframework.stereotype.Service;

import com.in28minumtes.spring.aop.springaop.aspect.TrackTime;

@Service
public class Dao1 {
	
	@TrackTime //Custom Annotation
	public String retrieveSomething() {
		return "Dao1";
	}
}
