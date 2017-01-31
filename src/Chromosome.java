/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geovana
 */
public class Chromosome {

    private double fitness;
    private Genes genes;

    public Chromosome() {
        super();
    }

    public Chromosome(double fitness, Genes location) {
        this.fitness = fitness;
        this.genes = location;
    }

    public Genes getGenes() {
        return genes;
    }

    public void setGenes(Genes genes) {
        this.genes = genes;
    }

    public double getFitness(Functions f) {
        fitness = f.evaluate(genes);
        return fitness;
    }
}
