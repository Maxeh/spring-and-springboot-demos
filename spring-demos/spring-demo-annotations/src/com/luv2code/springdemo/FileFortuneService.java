package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	private String filename = "fortune-data.txt";
	private List<String> theFortunes;
		
	@PostConstruct
	public void doSomeStartupStuff() {
		URL url = getClass().getResource(filename);	
		File theFile = new File(url.getPath());
		System.out.println("File exists: " + theFile.exists());
		
		theFortunes = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
			String tempLine;
			while ((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getFortune() {
		Random rand = new Random();
		return theFortunes.get(rand.nextInt(theFortunes.size()));
	}
}
