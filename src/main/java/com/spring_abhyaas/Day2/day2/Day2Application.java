package com.spring_abhyaas.Day2.day2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Day2Application {

	public static void main(String[] args) {
		SpringApplication.run(Day2Application.class, args);
		MyThread thread1 = new MyThread();
		
		System.out.println("thread1");
		thread1.start();//new thread starts ,new stack for it
		//thread.run();//on the same stack , here it will be main's stack
		System.out.println("thread2");
		
		MyThread thread2=new MyThread();
		thread2.start();
		
		//thread2.start();
		//thread2.run();//after start() , we can't call run()
		System.out.println("Now no multi-threads");
		
		System.out.println("thread3");
		MyThread thread3=new MyThread();
		thread3.run();
		
		System.out.println("thread4");
		MyThread thread4=new MyThread();
		thread4.run();
		
		System.out.println("thread3");
		thread3.run();
		
	}
	
	private static class MyThread extends Thread{
		@Override
		public void run() {
			System.out.println("In thread , Name: "+currentThread().getName()+"; ID: "+this.getId()+" Priority: "+this.getPriority());		
		}
	}
	
}

