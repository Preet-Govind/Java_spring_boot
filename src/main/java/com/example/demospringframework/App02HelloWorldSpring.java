package com.example.demospringframework;

import com.example.demospringframework.game.GameRunner;
import com.example.demospringframework.game.PacmanGame;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demospringframework.game.*;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
		// 1 - Launch spring context
		var context =new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		// 2 - Configure the things that we want spring to manage 
		//created HelloWorldConfiguration class with @Configuration
		
		// 3 - Retrieving Beans managed by Spring
		System.out.println(context.getBean("name"));//finding the bean with name "bean"
		//System.out.println(context.getBean("HelloWorldConfiguration"));//won't work
		//System.out.println(context.getBean(HelloWorldConfiguration.class));//by class type		
		System.out.println("by class type :"+context.getBean(Address.class));
		//other beans - if any bean name doesn't match , 
		//it'll throw error "No bean named '...WrongBeanName...' available"
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address"));
		//bean calling bean methods
		System.out.println("by method calling :"+context.getBean("person2MethodCalling"));
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}
}