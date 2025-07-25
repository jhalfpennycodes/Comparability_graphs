import org.jgrapht.Graph;
import org.jgrapht.generate.CompleteGraphGenerator;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.util.SupplierUtil;


public class testCompleteGraph {

    public static void run(String algorithm, int nV){

        String graphType = "Complete graph";
        String file = "completeResults.csv";

        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        // Create a new random graph using the GnmRandomGraphGenerator
        CompleteGraphGenerator generator;
        generator = new CompleteGraphGenerator(nV);
        Graph<String, OrientableEdge> graph = new SimpleGraph<String, OrientableEdge>(SupplierUtil.createStringSupplier(), OrientableEdgeSupplier.createOrientableEdgeSupplier(), false);
        generator.generateGraph(graph);

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
            writeResults.writeFailed(file, algorithm, graphType, graph.vertexSet().size(), graph.edgeSet().size(), DG.vertexSet().size(), DG.edgeSet().size(), irreflexive, antisymmetric, transitive ,runningTime, false, graph, DG);
        }
        else{
            writeResults.writeToFile(file, algorithm, graphType, graph.vertexSet().size(), graph.edgeSet().size(),
                    DG.vertexSet().size(), DG.edgeSet().size(), irreflexive, antisymmetric, transitive, runningTime,
                    true, graph, DG);
        }


    }
}
