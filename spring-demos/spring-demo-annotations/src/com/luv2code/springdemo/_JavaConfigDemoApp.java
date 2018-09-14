package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Demo for java config file (with component scan) and java annotations
 * !! For this demo app to work, you have to remove the comment slashes on line 9 in the SportConfig file
 */
public class _JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune());
		
		System.out.println(((TennisCoach)theCoach).getEmailAndTeam());
		
		// close the context
		context.close();
	}

}
