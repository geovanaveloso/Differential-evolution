/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geovana
 */
public class FunctionEleven extends Functions {

    public FunctionEleven() {
        X_HIGH = 600;
        X_LOW = -600;
        name = "Funcao 11";
        optimum = 0;
         CR = 0.1;
    }

    @Override
    public double evaluate(Genes location) {
        double loc[] = location.getGenes();
        double fitness = 0, prod;
        for (int i = 0; i < loc.length; i++) {
            prod = 0;
            for (int j = 1; j < loc.length; j++) {
                prod *= Math.cos((loc[j] / Math.sqrt(j))) + 1;
            }
            fitness+=Math.pow(loc[i], 2)-prod;
        }
        return fitness/4000;
    }
}
