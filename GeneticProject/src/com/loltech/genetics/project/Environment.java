package com.loltech.genetics.project;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

public class Environment {
	
	Graphics2D g;
	public Canvas c;
	int popSize = 0;
	Population pop;
	int x;
	int y;
	
	Environment(int width, int height, String name, Population myPop, int x, int y) {
		this.pop = myPop;
		this.x = x;
		this.y = y;
		JFrame frame = new JFrame(name);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		c = new Canvas();
		c.setBackground(new Color(204, 204, 204));
		c.setSize(new Dimension(width, height));
		
		frame.add(c);
		frame.pack();
		frame.setVisible(true);
		c.createBufferStrategy(2);
		g = (Graphics2D) c.getBufferStrategy().getDrawGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	
	public Graphics2D getGraphics() {
		return g;
	}
	
	public void reset(Population pop) {
		this.pop = pop;
		for (int i = 0; i < pop.individuals.length; i++) {
				pop.individuals[i].character.setY(0);
				pop.individuals[i].character.setX(0);
		}
	}
	
	public void render(Graphics2D g, int index) {
		g.clearRect(0,0, 500, 500);
		g.setColor(Color.RED);
		g.fillOval(x - 150, y - 150, 1000, 1000);
		g.setColor(Color.BLACK);
		for (int i = 0; i < pop.individuals.length; i++) {
			if (pop.individuals[i].genes[index] == 1) {
				pop.individuals[i].character.setY(pop.individuals[i].character.y - 1);
			} else if (pop.individuals[i].genes[index] == 2) {
				pop.individuals[i].character.setX(pop.individuals[i].character.x - 1);
			} else if (pop.individuals[i].genes[index] == 3) {
				pop.individuals[i].character.setY(pop.individuals[i].character.y + 1);
			} else {
				pop.individuals[i].character.setX(pop.individuals[i].character.x + 1);
			}
			g.drawRect(pop.individuals[i].character.x,pop.individuals[i].character.y, 1,1 );
		}
	}
	
}
