package com.example.demospringframework.game;

public class PacmanGame implements GamingConsole{
	
	public void up()
	{
		System.out.println("Jump");
	}
	public void down()
	{
		System.out.println("down");
	}
	public void left()
	{
		System.out.println("back");
	}
	public void right()
	{
		System.out.println("ahead");
	}
}
