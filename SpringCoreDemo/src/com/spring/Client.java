package com.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Object Construction | old style

		Employee eRef = new Employee();
		eRef.setEid(101);
		eRef.setEname("Kushagra");
		eRef.setEaddress("Indore");

		System.out.println("---------------------------------------");
		System.out.println("|   object creation by Old style      |");
		System.out.println("---------------------------------------\n");
		System.out.println("Employee Details : "+ eRef);

		//Spring Way| IOC (Inversion Of Control)

		Resource resource = new ClassPathResource("employeebean.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		ApplicationContext context = new ClassPathXmlApplicationContext("employeebean.xml");

		//		Employee e1 = (Employee)factory.getBean("emp1");
		//		Employee e2 = factory.getBean("emp2", Employee.class);
		Employee e1 = (Employee)context.getBean("emp1");
		Employee e2 = context.getBean("emp2", Employee.class);


		System.out.println("\n---------------------------------------");
		System.out.println("|  object creation by Spring style    |");
		System.out.println("---------------------------------------\n");

		System.out.println("Employee 1 Details: "+ e1);
		System.out.println("Employee 2 Details: "+ e2);
	}



}
