/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geovana
 */
public abstract class Functions {
    public static double PRECISION = 1E-16;
    public double X_LOW = 0;
    public double X_HIGH = 0;
    public String name;
    double optimum;
    double CR;

    public double evaluate(Genes genes) {
        return Double.MAX_VALUE;
    }

}
