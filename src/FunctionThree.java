/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geovana
 */
public class FunctionThree extends Functions  {
     
    public FunctionThree() {
        X_HIGH = 100;
        X_LOW = -100;
        name = "Funcao 3";
        optimum = 0;
        CR = 0.8;
    }

    @Override
    public double evaluate(Genes location) {
        double loc[] = location.getGenes();
        double fitness = 0, f;
        for (int i =0; i<loc.length; i++){
            f = 0;
            for (int j=0; j<i; j++){
                f= loc[j];
            }
            fitness+= Math.pow(f,2);
        }
        return fitness;  
    }
}
