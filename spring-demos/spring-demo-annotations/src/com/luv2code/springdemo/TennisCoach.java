package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	//define a default constructor
	public TennisCoach() {
		System.out.println("inside tennisCoach constructor");
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("leeets go!");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("ciao bella!");
	}
	
	// define a setter method (setter injection)
	// info: you can use any method name
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("inside tennisCoach setFortuneService");
		this.fortuneService = fortuneService;
	}*/
	
	// constructor injection
	/*@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDailyWorkout() {
		return "Practise your backhand volley";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
	public String getEmailAndTeam() {
		return email + "\n" + team;
	}
	
}
