/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geovana
 */
public class FunctionOne extends Functions {

    public FunctionOne() {
        X_HIGH = 100;
        X_LOW = -100;
        name = "Funcao 1";
        optimum = 0;
        CR = 0.2;
    }

    @Override
    public double evaluate(Genes genes) {
        double loc[] = genes.getGenes();
        double fitness = 0;
        for (int i =0; i<loc.length; i++){
            fitness+= Math.pow(loc[i],2);
        }
        return fitness;  
    }
}
