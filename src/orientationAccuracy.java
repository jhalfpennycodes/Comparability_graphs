import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.HashSet;
import java.util.Set;

public class orientationAccuracy {

    public static Set<OrientableEdge> findTransitiveEdges(Graph<String, OrientableEdge> graph) {

        Set<OrientableEdge> potentialTransitiveEdges = new HashSet<>();
        for (OrientableEdge edge : graph.edgeSet()) {
            String source = graph.getEdgeSource(edge);
            String target = graph.getEdgeTarget(edge);

            // Check if there exists a path from source to target that doesn't use the edge
            DijkstraShortestPath<String, OrientableEdge> shortestPath = new DijkstraShortestPath<>(graph);
            GraphPath<String, OrientableEdge> pathWithoutEdge = shortestPath.getPath(source, target);

            if (pathWithoutEdge != null) {
                potentialTransitiveEdges.add(edge);
            }
        }
        return potentialTransitiveEdges;
    }


    public static float accuracy(DefaultDirectedGraph<String, OrientableEdge> DG, Graph<String, OrientableEdge> graph){

        int count=0;
        System.out.println(findTransitiveEdges(graph));

        float accuracy=0;
        return accuracy;
    }
}
