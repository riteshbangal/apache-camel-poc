package com.poc.camel.aws.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-camel.xml");
		applicationContext.start();
		System.out.println("Application context started");
		try {
			Thread.sleep(5 * 60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		applicationContext.stop();
		applicationContext.close();
		System.out.println("Application context stopped...");
	}
}
