package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _SetterDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");		
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myTrackCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// call our new methods to get the literal values
		System.out.println(((TrackCoach)theCoach).getEmailAddress());
		System.out.println(((TrackCoach)theCoach).getTeam());
		
		// close the context
		context.close();
	}

}
