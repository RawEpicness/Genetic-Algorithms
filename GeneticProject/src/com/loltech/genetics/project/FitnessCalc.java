package com.loltech.genetics.project;

public class FitnessCalc {
	static int[] solution = new int[2];

    /* Public methods */
    // Set a candidate solution as a byte array
    public static void setSolution(int x, int y) {
        solution[0] = x;
        solution[1] = y;
    }

    // To make it easier we can use this method to set our candidate solution 
    // with string of 0s and 1s

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static int getFitness(Individual individual) {
        int fitness = 0;
        // Loop through our individuals genes and compare them to our cadidates
        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            fitness = (solution[0] * individual.character.x) + (solution[1] * individual.character.y);
        }
        return fitness;
    }
    
    // Get optimum fitness
    static int getMaxFitness() {
        int maxFitness = solution[0]*solution[0] + solution[1]*solution[1];
        return maxFitness;
    }
}
