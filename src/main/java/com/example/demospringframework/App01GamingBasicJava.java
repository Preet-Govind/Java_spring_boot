package com.example.demospringframework;

import com.example.demospringframework.game.GameRunner;
import com.example.demospringframework.game.MarioGamer;
import com.example.demospringframework.game.SuperContraGame;
import com.example.demospringframework.game.PacmanGame;

public class App01GamingBasicJava {
	public static void main(String[] args) {
		//tightly coupled
	//var Game = new MarioGamer();
	//var game=new SuperContraGame();
	var game = new PacmanGame();
	var gameRunner = new GameRunner(game);
	gameRunner.run();
	}
}
