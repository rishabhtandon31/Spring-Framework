package com.cg.project.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.project.beans.Employee;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("projectbeans.xml");
		Employee employee= (Employee) context.getBean("employee");
		System.out.println(employee);
	}

}
