package com.cg.project.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.project.services.GreetingServices;
public class MainClass {
	public static void main(String[] args) {
		/*GreetingServices greetingServices= new GreetingServicesImpl();
		greetingServices.greetUser("Rishabh Tandon");*/
		
		ApplicationContext context= new ClassPathXmlApplicationContext("projectbeans.xml");
		/*GreetingServices greetingServices= (GreetingServices) context.getBean("greetingServices");
		greetingServices.greetUser("Rishabh");*/
		((GreetingServices) context.getBean("greetingServices1")).greetUser("Rahul");
		((GreetingServices) context.getBean("greetingServices")).greetUser("Rahul");
	}
}
