package com.cg.project.services;

import org.springframework.stereotype.Component;

@Component("greetingServices1")
public class GreetingServicesImpl2 implements GreetingServices{
	@Override
	public void greetUser(String name) {
		System.out.println("Hi ! "+name);
		
	}

}
