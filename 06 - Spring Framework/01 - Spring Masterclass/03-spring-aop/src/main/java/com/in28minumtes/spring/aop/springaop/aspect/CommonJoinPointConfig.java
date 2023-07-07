package com.in28minumtes.spring.aop.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	//We can use this everywhere instead of using the pointcut everywhere.
	//Now we have all the pointcuts in the same place and they became reusable.
	//THIS IS A GOOD PRACTICE
	//All the JoinPoints are defined by AspectJ and implemented by Spring AOP.
	
	@Pointcut("execution(* com.in28minumtes.spring.aop.springaop.data.*.*(..))")
	public void dataLayerExecution() {
		// This will intercept any execution in the data layer.
	}
	
	@Pointcut("execution(* com.in28minumtes.spring.aop.springaop.business.*.*(..))")
	public void businessExecution() {
		// This will intercept any execution in the business layer.
	}
	
	@Pointcut("execution(* com.in28minumtes.spring.aop.springaop.data.*.*(..)) && execution(* com.in28minumtes.spring.aop.springaop.business.*.*(..))")
	public void anyLayerExecution() {
		// This will intercept any execution in both, data layer and business layer.
	}
	
	@Pointcut("bean(*Dao*)")
	public void beanContainsDao() {
		// This will intercept any bean that has Dao in its name.
	}
	
	@Pointcut("bean(Dao*)")
	public void beanStartingWithDao() {
		// This will intercept any bean that has Dao at the starting of its name.
	}
	
	@Pointcut("bean(*Dao)")
	public void beanEndingWithDao() {
		// This will intercept any bean that has Dao at the ending of its name.
	}
	
	@Pointcut("within(com.in28minumtes.spring.aop.springaop.data..*)")
	public void dataLayerExecutionWithWithin() {
		// This will intercept all calls within the data layer.
	}
	
	@Pointcut("@annotation(com.in28minumtes.spring.aop.springaop.aspect.TrackTime)")
	public void TrackTime() {
		// This will intercept all calls that has the com.in28minumtes.spring.aop.springaop.aspect.TrackTime annotation.
	}
	
}
