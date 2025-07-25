import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;

public class gamma04 {

    static DefaultDirectedGraph<String, OrientableEdge> forceDirection(Graph<String, OrientableEdge> G) {

        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graphs.addAllVertices(DG, G.vertexSet());

        if (G.edgeSet().isEmpty()) return DG;

        OrientableEdge arbitraryEdge = G.edgeSet().iterator().next();
        arbitraryEdge.setForwardOrientation(DG, arbitraryEdge);

        for (OrientableEdge orientedEdge : G.edgeSet()) {
            if (orientedEdge.isOriented()) {
                for (OrientableEdge edge : G.edgeSet()) {
                    if (orientedEdge.equals(edge)) continue;
                    //Check the edge is oriented before comparing
                    //Check if the orientation of one edge force another
                    if ((G.getEdgeSource(orientedEdge) == G.getEdgeSource(edge) &&
                            !G.containsEdge(G.getEdgeTarget(orientedEdge), G.getEdgeTarget(edge)))) {
                        if (orientedEdge.isForwardOriented()) edge.setForwardOrientation(DG, edge);
                        else if (orientedEdge.isBackwardOriented()) edge.setBackwardOriented(DG, edge);
                    }
                    if ((G.getEdgeTarget(orientedEdge) == G.getEdgeTarget(edge) &&
                            !G.containsEdge(G.getEdgeSource(orientedEdge), G.getEdgeSource(edge)))) {
                        if (orientedEdge.isForwardOriented()) edge.setForwardOrientation(DG, edge);
                        else if (orientedEdge.isBackwardOriented()) edge.setBackwardOriented(DG, edge);
                    }
                    if ((G.getEdgeTarget(orientedEdge) == G.getEdgeSource(edge) &&
                            !G.containsEdge(G.getEdgeSource(orientedEdge), G.getEdgeTarget(edge)))) {
                        if (orientedEdge.isForwardOriented()) edge.setBackwardOriented(DG, edge);
                        else if (orientedEdge.isBackwardOriented()) edge.setForwardOrientation(DG, edge);
                    }
                    if ((G.getEdgeSource(orientedEdge) == G.getEdgeTarget(edge) &&
                            !G.containsEdge(G.getEdgeTarget(orientedEdge), G.getEdgeSource(edge)))) {
                        if (orientedEdge.isForwardOriented()) edge.setBackwardOriented(DG, edge);
                        else if (orientedEdge.isBackwardOriented()) edge.setForwardOrientation(DG, edge);
                    }
                }
            }
            while (!orientedEdge.isOriented()) {
                orientedEdge.setForwardOrientation(DG, orientedEdge);
            }
        }
        return DG;
    }
}
