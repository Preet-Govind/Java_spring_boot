package com.example.demospringframework;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

record Person (String name ,int age,Address address) {};//replacement for setter getters - auto constructors - jdk16
record Address (String FirstLine ,String SecondLine) {};
@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name()
	{
		return "bean returns a name";
	}
	
	@Bean
	@Qualifier("name2")
	public String Name2()
	{
		return "bean returns name2";
	}

	@Bean
	public Integer age()
	{
		return 25;
	}
	
	@Bean
	public Person person()
	{
		/*
		var person = new Person("Ravi",25);
		return person;
		*/
		return new Person("Ravi",25,new Address("addressP1-1","addressP1-2"));
	}
	
	@Bean(name="address")//bean name customization
	public Address addr()
	{
		return new Address("bean returns address","2nd Line");
	}
	
	@Bean
	public Person person2MethodCalling()
	{
		return new Person(name(),age(),new Address("Person2Address-1","Person2Address-2"));
	}
	
	//multiple beans with same return type can't be get using getBean()
	//generates error
	
	@Bean
	@Primary
	public Address address2()
	{
		return new Address("bean returns address2","2nd Line");
	}
	
	@Bean
	public Person person3Params(@Qualifier("name2") String name , int age , Address address2)
	{
		return new Person(name,age,address2);
	}
}
