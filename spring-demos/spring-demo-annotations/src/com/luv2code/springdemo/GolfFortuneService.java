package com.luv2code.springdemo;

public class GolfFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You are a good golf player!";
	}

}
