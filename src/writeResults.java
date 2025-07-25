import org.jgrapht.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class writeResults {

    public static void writeToFile(String file, String algorithm, String graphType, int vertices, int edges, int verticesDG, int edgesDG,
                                   boolean irreflexive, boolean antisymmetric, boolean transitive, double runningTime,
                                   boolean success, Graph inputGraph, Graph outputGraph) {
        //Write results to CSV
//        try {
//            FileWriter pw = new FileWriter("Results/full_" + file, true);
//            BufferedReader br = new BufferedReader(new FileReader("Results/full_" + file));
//            if (br.readLine() == null) {
//                pw.append("Algorithm, Graph type, Number of input vertices, Number of input edges, " +
//                        "Number of output vertices, Number of output edges, Not reflexive, Antisymmetric, " +
//                        "Transitive, Running Time, Success, Graph input, Graph output");
//            }
//            pw.append("\n" + algorithm + ", " + graphType +", " + vertices + ", " + edges + ", " + verticesDG +", " +
//                    edgesDG + ", " + irreflexive + ", " + antisymmetric + ", " + transitive + ", " + runningTime + ", "
//                    + success + ", " + inputGraph + ", " + outputGraph);
//            pw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            FileWriter pw = new FileWriter("Results/" + file, true);
            BufferedReader br = new BufferedReader(new FileReader("Results/" + file));
            if (br.readLine() == null) {
                pw.append("Algorithm, Graph type, Number of input vertices, Number of input edges, " +
                        "Number of output vertices, Number of output edges, Not reflexive, Antisymmetric, " +
                        "Transitive, Running Time, Success");
            }
            pw.append("\n" + algorithm + ", " + graphType +", " + vertices + ", " + edges + ", " + verticesDG +", " +
                    edgesDG + ", " + irreflexive + ", " + antisymmetric + ", " + transitive + ", " + runningTime + ", "
                    + success);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFailed(String file, String algorithm, String graphType, int vertices, int edges, int verticesDG, int edgesDG,
                                   boolean irreflexive, boolean antisymmetric, boolean transitive, double runningTime,
                                   boolean success, Graph inputGraph, Graph outputGraph){
//        try {
//            FileWriter pw = new FileWriter("Results/full_" + file, true);
//            BufferedReader br = new BufferedReader(new FileReader("Results/full_" + file));
//            if (br.readLine() == null) {
//                pw.append("Algorithm, Graph type, Number of input vertices, Number of input edges, " +
//                        "Number of output vertices, Number of output edges, Not reflexive, Antisymmetric, " +
//                        "Transitive, Running Time, Success, Graph input, Graph output");
//            }
//            pw.append("\n" + algorithm + ", " + graphType +", " + vertices + ", " + edges + ", " + verticesDG +", " +
//                    edgesDG + ", " + irreflexive + ", " + antisymmetric + ", " + transitive + ", " + runningTime + ", "
//                    + success + ", " + inputGraph + ", " + outputGraph);
//            pw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            FileWriter pw = new FileWriter("Results/" + file, true);
            BufferedReader br = new BufferedReader(new FileReader("Results/" + file));
            if (br.readLine() == null) {
                pw.append("Algorithm, Graph type, Number of input vertices, Number of input edges, " +
                        "Number of output vertices, Number of output edges, Not reflexive, Antisymmetric, " +
                        "Transitive, Running Time, Success");
            }
            pw.append("\n" + algorithm + ", " + graphType +", " + vertices + ", " + edges + ", " + verticesDG +", " +
                    edgesDG + ", " + irreflexive + ", " + antisymmetric + ", " + transitive + ", " + runningTime + ", "
                    + success);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
