import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultUndirectedGraph;


public class testSingletonGraph {

    public static void run(String algorithm){

        String graphType = "Singleton graph";
        String file = "singletonResults.csv";

        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        DefaultUndirectedGraph<String, OrientableEdge> graph = new DefaultUndirectedGraph<>(OrientableEdge.class);
        graph.addVertex("0");

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
