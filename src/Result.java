/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author geovana
 */
public class Result implements Comparable<Result>{
     double fitness;
     String function;

    public Result(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String funcao) {
        this.function = funcao;
    }

    @Override
    public int compareTo(Result o) {
        if (this.fitness<o.fitness){
            return -1;
        }else{
          if (this.fitness>o.fitness){
              return 1;
          }  else{
              return 0;
          }
        }
    }
}
