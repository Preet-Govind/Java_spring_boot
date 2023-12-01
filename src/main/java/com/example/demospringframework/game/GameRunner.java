package com.example.demospringframework.game;

public class GameRunner {
	//MarioGamer game;
	//SuperContraGame game;
	GamingConsole game;
	public GameRunner(GamingConsole game)
	{
		this.game=game;
	}
	public void run()
	{
		System.out.println("GameRunner :"+game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
