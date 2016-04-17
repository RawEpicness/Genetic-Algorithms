package com.loltech.genetics.project;


public class MainRunner {
	
	static int width = 500;
	static int height = 500;
	static String name = "Genetic Algorithm";
	static int popSize = 50;
	public static void main(String args[]) {
		new GameEngine(width, height, name);
	}
	
}
