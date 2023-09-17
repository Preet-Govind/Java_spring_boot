package com.springboot_abhyaas.day1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Day1Application {

	public static void main(String[] args) {
		ApplicationContext apc=SpringApplication.run(Day1Application.class, args);
		for(String s : apc.getBeanDefinitionNames() ) 
		{
			System.out.println(s);
			}
		/*
		same thing below , either of them should be ran to
		avoid multiple launches for the same port 
		*/
		
		/*
		 for(String s : ((ApplicationContext) SpringApplication.run(Day1Application.class, args)).getBeanDefinitionNames() ) 
		{
			System.out.println(s);
			}
		 */
	}

}
