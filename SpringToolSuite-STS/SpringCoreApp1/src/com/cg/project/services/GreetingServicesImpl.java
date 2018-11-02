package com.cg.project.services;

import org.springframework.stereotype.Component;

@Component("greetingServices")
public class GreetingServicesImpl implements GreetingServices{
@Override
	public void greetUser(String name) {
		System.out.println("Hello "+name);
	}

}
