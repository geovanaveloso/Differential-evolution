/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geovana
 */
public class FunctionNine extends Functions {

    public FunctionNine() {
        X_HIGH = 5.12;
        X_LOW = -5.12;
        name = "Funcao 9";
        optimum = 0;
        CR= 0.0;
    }

    @Override
    public double evaluate(Genes location) {
        double loc[] = location.getGenes();
        double fitness = 0;
        for (int i = 0; i < loc.length; i++) {
            fitness += (Math.pow(loc[i], 2)-10*Math.cos(2*Math.PI*loc[i])+10);
        }
        return fitness;
    }

}
