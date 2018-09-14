package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Demo for XML (with component scan) and java annotations.
 */
public class _AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
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
