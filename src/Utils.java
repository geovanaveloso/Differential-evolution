
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author geovana
 */
public class Utils {

    static void writeResultTestes(double r, int size_pop, int generations, String name_function) {
        File file = new File(Main.path + name_function + "/Solucao Testes - Tamanho_enxame " + size_pop + ".txt");
        try {
            try (Writer bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(String.valueOf(r));
                bw.write("\n");
                bw.flush();
                bw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static double checkPrecision(double r, Functions f) {
        if ((r - f.optimum) < Functions.PRECISION) {
            return 0.0;
        } else {
            return r;
        }
    }

    static void writeConvergence(double convergence, int size_pop, int generations, String name_function) {
        File file = new File(Main.path + name_function + "/Solucao cada geracao (convergencia) - " + size_pop + ".txt");
        try (Writer bw = new BufferedWriter(new FileWriter(file, true));) {
            bw.append(String.valueOf(convergence));
            bw.append("\n");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void writeTime(long time, String name_function, int size_pop, int generations) {
        File file = new File(Main.path + name_function + "/Tempo de execucao - Tamanho_enxame " + size_pop + ".txt");
        try (Writer bw = new BufferedWriter(new FileWriter(file, true));) {
            bw.write(String.valueOf(time));
            bw.write("\n");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void createDirectory(String directory) {
        try {
            if (!new File(directory + "/").exists()) {
                (new File(directory + "/")).mkdir();
            }
        } catch (Exception ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
