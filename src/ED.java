
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author geovana
 */
public class ED {

    private static final int SIZE_DIMENSION = 30;
    private static final double F_LOW = 0.3;
    private static final double F_HIGH = 0.9;
    int SIZE_POPULATION;
    int MAX_GENERATIONS;
    ArrayList<Chromosome> population = new ArrayList<>();
    double[] listFitness;
    Functions function;
    double[] convergence;
    Random random = new Random();

    public ED(Functions f, int size_population, int max_generations) {
        this.function = f;
        this.SIZE_POPULATION = size_population;
        this.MAX_GENERATIONS = max_generations;
        listFitness = new double[SIZE_POPULATION];
        convergence = new double[MAX_GENERATIONS];
    }

    public double execute() {
        population.clear();
        initializePopulation();
        updateFitness();

        int generation = 0;

        double F;

        while (generation < MAX_GENERATIONS) {
            for (int i = 0; i < SIZE_POPULATION; i++) {
                F = F_LOW + random.nextDouble() * (F_HIGH - F_LOW);
                int r[] = {-1, -1};
                int jr = random.nextInt(SIZE_POPULATION);
                // Target chromosome
                Chromosome target = population.get(i);
                // Best chromosome
                Chromosome pBest = population.get(getMinPos(listFitness));
                Chromosome trial = new Chromosome();
                Chromosome pr1;
                Chromosome pr2;
                double rand;

                while (r[0] == r[1]) {
                    r[0] = random.nextInt(SIZE_POPULATION);
                    r[1] = random.nextInt(SIZE_POPULATION);
                }

                // Chromosome randomly chosen
                pr1 = population.get(r[0]);
                pr2 = population.get(r[1]);

                //Mutation
                double[] newGenes = new double[SIZE_DIMENSION];
                for (int j = 0; j < SIZE_DIMENSION; j++) {
                    newGenes[j] = pBest.getGenes().getGenes()[j] + F * (pr1.getGenes().getGenes()[j] - pr2.getGenes().getGenes()[j]);
                }

                // Crossover
                double[] newGenesTrial = new double[SIZE_DIMENSION];
                for (int j = 0; j < SIZE_DIMENSION; j++) {
                    rand = random.nextDouble();
                    if (rand < function.CR || j == jr) {
                        newGenesTrial[j] = newGenes[j];
                    } else {
                        newGenesTrial[j] = target.getGenes().getGenes()[j];
                    }
                }
                trial.setGenes(new Genes(newGenesTrial));

                //If the fitness of the trial is better than the target
                // the trial is allocated in the population in place of the target
                if (trial.getFitness(function) < listFitness[i]) {
                    target.setGenes(new Genes(trial.getGenes().getGenes()));
                }

                updateFitness();
            }
            updateFitness();
            double best = Utils.checkPrecision(listFitness[getMinPos(listFitness)], function);
            Utils.writeConvergence(best, SIZE_POPULATION, MAX_GENERATIONS, function.name);
            generation++;
        }
        return listFitness[getMinPos(listFitness)];
    }

    // Initializes the population randomly respecting the maximum and minimum interval of each function
    public void initializePopulation() {
        Chromosome p;
        for (int i = 0; i < SIZE_POPULATION; i++) {
            p = new Chromosome();
            double[] gene = new double[SIZE_DIMENSION];
            for (int j = 0; j < SIZE_DIMENSION; j++) {
                gene[j] = function.X_LOW + random.nextDouble() * (function.X_HIGH - function.X_LOW);
            }
            p.setGenes(new Genes(gene));
            population.add(p);
        }
    }

    // Update fitness
    public void updateFitness() {
        for (int i = 0; i < SIZE_POPULATION; i++) {
            listFitness[i] = population.get(i).getFitness(this.function);
        }
    }

    // Get index that has better fitness
    public static int getMinPos(double[] list) {
        int pos = 0;
        double minValue = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i] < minValue) {
                pos = i;
                minValue = list[i];
            }
        }
        return pos;
    }

    public boolean checkconvergence() {
        int convergent = 0;
        for (int i = 0; i < SIZE_POPULATION; i++) {
            for (int j = 0; j < SIZE_POPULATION; j++) {
                if (i != j) {
                    double f = Math.abs(listFitness[i] - listFitness[j]);
                    if (f < Functions.PRECISION) {
                        convergent++;
                    }
                }
            }
        }
        return (convergent / SIZE_POPULATION * SIZE_POPULATION) >= 0.8;
    }

}
