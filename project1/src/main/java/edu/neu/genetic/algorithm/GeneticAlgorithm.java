package edu.neu.genetic.algorithm;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneticAlgorithm {

    private static final Logger log = Logger.getLogger(GeneticAlgorithm.class);

    public static void main(String[] args) {

        final int POPULATION_SIZE = 1000;
        int genoTypeLength = 6;
        int phenoTypeLength = 12;
        double cutoff = 0.2;
        final int MAX_NUMBER_OF_GENERATION = 1000;

        List<City> initialRoute = new ArrayList<>(Arrays.asList(
                new City("Bombay", 19.0760, 72.877, 1),
                new City("Delhi", 28.7041, 77.1025, 2),
                new City("Kolkata", 22.5726, 88.3639, 3),
                new City("Chennai", 13.0827, 80.2707, 4),
                new City("Hyderabad", 17.3850, 78.4867, 5),
                new City("Itanagar", 27.0610, 93.3712, 6),
                new City("Srinagar", 34.0836, 74.797, 7),
                new City("Boston", 42.3601, -71, 8),
                new City("New York", 40.7128, -74, 9),
                new City("Miami", 25.7617, -80.191, 10),
                new City("Adelaide", 34.9285, -138.607, 11),
                new City("auckland", 36.8567, -174.163, 12)
                ));

        log.info("Base Route before Generation 0 " + initialRoute);

        Population population = new Population(cutoff, initialRoute);

        population.initializePopulation(POPULATION_SIZE, genoTypeLength, phenoTypeLength);

        int bestConstantDistanceForGenerationsCtr = 1;
        double bestDistanceSoFar;
        int totalGenerationSpawned = 1;
        population.sortPopulation();
        TSPPhenome bestPhenome = population.getGenomeList().get(0).getPhenome();

        bestDistanceSoFar = population.getGenomeList().get(0).getPhenome().getTotalDistance();

        System.out.println("Generation 0\n" + population.getGenomeList().get(0).getPhenome().toString());
        log.info("\n First Generation " + population.getGenomeList().get(0).getPhenome().toString());

        /**
         * Run the loop for max 100 generations
         * Assumption: if the bestMinDistance is same for 10 generations
         * we have found our optimal solution
         */
        for (int i = 1; i <= MAX_NUMBER_OF_GENERATION; i++) {

            if (bestConstantDistanceForGenerationsCtr > 10) {
                break;
            }

            population.regeneration();
            population.sortPopulation();

            bestConstantDistanceForGenerationsCtr++;
            totalGenerationSpawned++;
            double currentBestDistance = population.getGenomeList().get(0).getPhenome().getTotalDistance();

            // if the best distance is reduced more than 50, reintialize the counter to 1 and run until it reaches 20 again
            if (currentBestDistance < (bestDistanceSoFar - 50)) {
                bestDistanceSoFar = currentBestDistance;
                bestConstantDistanceForGenerationsCtr = 1;
                bestPhenome = population.getGenomeList().get(0).getPhenome();
            }
            System.out.println("\nGeneration " + i);
            System.out.println(population.getGenomeList().get(0).getPhenome().toString());
        }
        System.out.println("\n*******Best way to visit all the cities*******\n" + bestPhenome);
        System.out.println("Total number of generations spawned: " + totalGenerationSpawned);
    }
}
