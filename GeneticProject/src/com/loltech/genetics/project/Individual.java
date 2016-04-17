package com.loltech.genetics.project;

import com.advprogramming.engine.GameObject;

public class Individual {
	static int height;
	static int defaultGeneLength;
    public int[] genes;
    public GameObject character = new GameObject(0,0,1,1);
    // Cache
    private int fitness = 0;

    // Create a random individual
    
    public Individual(int height) {
    	Individual.defaultGeneLength = height * 2;
    	Individual.height = height;
    	genes = new int[defaultGeneLength];
    }
    
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
        	double rand = Math.random();
        	if (rand <= .25) {
        		genes[i] = 1;
        	} else if (rand > .25 && rand <= .5) {
        		genes[i] = 2;
        	} else if (rand > .5 && rand <= .75) {
        		genes[i] = 3;
        	} else {
        		genes[i] = 4;
        	}
        }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }
    
    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int value) {
        genes[index] = value;
        fitness = 0;
    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }
    
    public void setX(int x) {
    	character.setX(x);
    }
    public void setY(int y) {
    	character.setX(y);
    }
    
    public int getX() {
    	return character.x;
    }
    
    public int getY() {
    	return character.y;
    }
    
    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}
