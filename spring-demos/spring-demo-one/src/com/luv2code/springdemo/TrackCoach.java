package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public TrackCoach() {
		System.out.println("inside no-arg constructor");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("inside setter method - setFortuneService");	
		this.fortuneService = fortuneService;
	}
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("inside setter method - setTeam");
		this.team = team;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "On track: " + fortuneService.getFortune();
	}
	
	
}
