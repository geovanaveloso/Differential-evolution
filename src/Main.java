

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author geovana
 */
public class Main {

    static String path;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	path = args[0];
        final int MAX_TESTS = 10;
        long begin, end;
        Functions f;
        int[] population_size_test = {100, 200, 500};
        int[] max_generation_tests = {2000};

        for (int m = 0; m < 4; m++) {
            if (m == 0) {
                f = new FunctionOne();
                Utils.createDirectory(path + f.name);
            } else {
                if (m == 1) {
                    f = new FunctionThree();
                    Utils.createDirectory(path + f.name);
               } else {
                    if (m == 2) {
                        f = new FunctionNine();
                        Utils.createDirectory(path + f.name);
                    } else {
                        f = new FunctionEleven();
                        Utils.createDirectory(path + f.name);
                    }
                }
            }
            for (int k = 0; k < max_generation_tests.length; k++) {
                for (int j = 0; j < population_size_test.length; j++) {
                    System.out.println("Executando " + f.name + " Tamanho enxame " + population_size_test[j]);
                    ED ed = new ED(f, population_size_test[j], max_generation_tests[k]);
                    begin = System.currentTimeMillis();
                    for (int i = 0; i < MAX_TESTS; i++) {
                        double r = ed.execute();
                        r = Utils.checkPrecision(r, f);
                        Utils.writeResultTestes(r, population_size_test[j], max_generation_tests[k],f.name);
                    }
                    end = System.currentTimeMillis();
                    Utils.writeTime((end - begin), f.name, population_size_test[j], max_generation_tests[k]);
                }
            }
        }
   }
}
