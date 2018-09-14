package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Demo for java config file (with beans and without component scan) and java annotations
 */
public class __GolfDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach theCoach = context.getBean("golfCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune());
		
		context.close();
	}

}
