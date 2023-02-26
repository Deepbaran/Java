package com.in28minumtes.spring.aop.springaop.data;

import org.springframework.stereotype.Repository;
import com.in28minumtes.spring.aop.springaop.aspect.TrackTime;

@Repository
public class Dao1 {
	
	@TrackTime //Custom Annotation
	public String retrieveSomething() {
		return "Dao1";
	}
}
