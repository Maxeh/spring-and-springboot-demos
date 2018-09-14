package com.luv2code.springdemo;

public class HappyFortuneService2 implements FortuneService {
	
	String[] fortunes = {"you look great", "keep up the good work", "you can do it"};
	
	@Override
	public String getFortune() {
		int rand = (int) Math.floor(Math.random() * 3);
		return fortunes[rand];
	}
}
