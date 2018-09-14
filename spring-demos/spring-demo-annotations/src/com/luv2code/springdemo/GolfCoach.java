package com.luv2code.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GolfCoach implements Coach {
	
	@Autowired
	@Qualifier("golfFortuneService")
	FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practise golf!";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	public void doMyStartupStuff() {
	    System.out.println("@@@ " +  getClass().getName() + ": inside of doMyStartupStuff()");
	}
}
