package com.loltech.genetics.project;

import java.awt.Dimension;
import java.awt.Toolkit;

public class MainRunner {
	
	static String name = "Genetic Algorithm";
	static int popSize = 50;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double height = screenSize.getHeight() - 150;
	public static void main(String args[]) {
		new GameEngine((int) height, (int) height, name);
	}
	
}
