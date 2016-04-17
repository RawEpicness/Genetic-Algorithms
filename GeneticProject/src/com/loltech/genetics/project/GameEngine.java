package com.loltech.genetics.project;

import java.awt.Graphics2D;

import com.advprogramming.engine.Engine;

public class GameEngine implements Engine {
	
	int width;
	int height;
	String name;
	Environment environment;
	Graphics2D g;
	int UPDATES_PER_SEC = 100000;
	Population myPop;
	
	GameEngine (int width, int height, String name) {
		int solutionX = (int)(height - Math.random() * 100);
		int solutionY = (int)(height - Math.random() * 100);
		System.out.println(solutionX + ", " + solutionY);
		FitnessCalc.setSolution(solutionX, solutionY);
		myPop = new Population(500, true, height);
		setUpEnvironment(width, height, name, solutionX, solutionY);
        startGame();
	}
	
	public void setUpEnvironment(int width, int height, String name, int solutionX, int solutionY) {
		environment = new Environment(width, height, name, myPop, solutionX, solutionY);
		this.width = width;
		this.height = height;
		this.name = name;
		g = (Graphics2D) environment.getGraphics();
	}

	public void render2(Graphics2D g, int i) {
		environment.render(g, i);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void startGame() {
		int generationCount = 0;
		while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
			generationCount++;
			long startTime = 0L;
			long sleepDuration = 0L;
			int i = 0;
			while (i < Individual.defaultGeneLength) {
				startTime = System.currentTimeMillis();
				update();
				render2(g, i);
				
				environment.c.getBufferStrategy().show();
				
				sleepDuration = (1 / (UPDATES_PER_SEC * UPDATES_PER_SEC * UPDATES_PER_SEC)) - (System.currentTimeMillis() - startTime);
				
				if (sleepDuration > 0) {
					try {
						Thread.sleep(sleepDuration);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				i++;
			}
			System.out.println("generation: " + generationCount + ", " + myPop.getFittest().character.x + ", " + myPop.getFittest().character.y);
            System.out.print("genes:");
			for (int x = 0; x < myPop.getFittest().size(); x++) {
	            // Crossover
				System.out.print(myPop.getFittest().genes[x]);
	        }
			System.out.print("\n");
			myPop = Algorithm.evolvePopulation(myPop, height);
			environment.reset(myPop);
		}
		System.out.print("finished with:");
		for (int x = 0; x < myPop.getFittest().size(); x++) {
            // Crossover
			System.out.print(myPop.getFittest().genes[x]);
        }
	}

	@Override
	public void reset() {
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
}
