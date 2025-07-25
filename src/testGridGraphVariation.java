import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.GraphMeasurer;
import org.jgrapht.generate.*;
import org.jgrapht.graph.*;
import org.jgrapht.util.SupplierUtil;
import org.jgrapht.alg.TransitiveReduction;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.io.File;
import java.io.FileWriter;


public class testGridGraphVariation {

    public static void run(String algorithm, int row, int col){

        String graphType = "Grid graph variation";
        String file = "gridVariationResults.csv";

        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        // Create a new random graph using the GnmRandomGraphGenerator
        GridGraphGenerator generator;
        generator = new GridGraphGenerator(row, col);
        SimpleGraph<String, OrientableEdge> graph = new SimpleGraph<String, OrientableEdge>(SupplierUtil.createStringSupplier(), OrientableEdgeSupplier.createOrientableEdgeSupplier(), false);
        generator.generateGraph(graph);

        graph.removeEdge(graph.edgeSet().iterator().next());

        double runningTime = 0;
        if (algorithm=="Gamma") {
            long startTimeSquare = System.nanoTime();
            DG = gamma04.forceDirection(graph);
            long endTimeSquare = System.nanoTime();
            runningTime = (endTimeSquare - startTimeSquare)/1000000;
        }
        else if (algorithm=="Knotting"){
            long startTimeSquare = System.nanoTime();
            DG = knotting02.Knotting(graph);
            long endTimeSquare = System.nanoTime();
            runningTime = (double) (endTimeSquare - startTimeSquare)/1000000;
        }

        boolean irreflexive, antisymmetric, transitive;
        irreflexive = strictPartialOrder.isIrreflexive(DG);
        antisymmetric = strictPartialOrder.isAntiSymmetric(DG);
        transitive = strictPartialOrder.isTransitive(DG);

        if (DG.edgeSet().size()!=graph.edgeSet().size()){
            writeResults.writeFailed(file, algorithm, graphType, graph.vertexSet().size(), graph.edgeSet().size(),
                    DG.vertexSet().size(), DG.edgeSet().size(), irreflexive, antisymmetric, transitive ,runningTime,
                    false, graph, DG);
        }
        else{
            writeResults.writeToFile(file, algorithm, graphType, graph.vertexSet().size(), graph.edgeSet().size(),
                    DG.vertexSet().size(), DG.edgeSet().size(), irreflexive, antisymmetric, transitive, runningTime,
                    true, graph, DG);
        }
    }
}
