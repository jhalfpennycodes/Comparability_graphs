import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.generate.ComplementGraphGenerator;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class knotting02 {

    static DefaultDirectedGraph<String, OrientableEdge> Knotting(Graph<String, OrientableEdge> G) {

        //---------------------------INITIALISE GRAPHS:---------------------------
        //Create undirected graph and directed graph
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graphs.addAllVertices(DG, G.vertexSet());

        Graph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        Graphs.addAllVertices(graph, G.vertexSet());
        Graphs.addAllEdges(graph, G, G.edgeSet());

        //Generate the complement graph of G
        ComplementGraphGenerator<String, DefaultEdge> g = new ComplementGraphGenerator<>(graph);
        Graph<String, DefaultEdge> complement = new DefaultUndirectedGraph<>(DefaultEdge.class);
        g.generateGraph(complement);

        //Create instances of Dijkstra algorithm
        DijkstraShortestPath dijkComplement = new DijkstraShortestPath(complement);
        DijkstraShortestPath dijkG = new DijkstraShortestPath<>(G);

        for (OrientableEdge orientedEdge : G.edgeSet()) {
            for (OrientableEdge edge : G.edgeSet()) {
                if (orientedEdge.equals(edge)) {
                    if (!orientedEdge.isOriented() && !edge.isOriented()) edge.setForwardOrientation(DG, edge);
                }

                if (!edge.isOriented()) {
                    //ab ~ ac
                    if (G.getEdgeSource(orientedEdge) == G.getEdgeSource(edge)) {
                        //Check if the path W from b to c exists
                        GraphPath pathComplement = dijkComplement.getPath(G.getEdgeTarget(orientedEdge), G.getEdgeTarget(edge));
                        if (pathComplement == null) continue;
                        if (pathComplement.getLength() >= 1) {
                            Object[] pathComplementVertexSet = pathComplement.getVertexList().toArray();
                            for (int k = 1; k <= pathComplementVertexSet.length - 1; k++) {
                                GraphPath pathG = dijkG.getPath(G.getEdgeSource(orientedEdge), pathComplementVertexSet[k]);
                                if (pathG == null) {
                                    continue;
                                }
                                if (pathG.getLength() == 1) {
                                    if (orientedEdge.isForwardOriented()) edge.setForwardOrientation(DG, edge);
                                    else if (orientedEdge.isBackwardOriented()) edge.setBackwardOriented(DG, edge);
                                }
                                if (pathG.getLength() >= 1 && pathG.getLength() <= pathComplement.getLength() - 1) {
                                    if (orientedEdge.isForwardOriented()) edge.setForwardOrientation(DG, edge);
                                    else if (orientedEdge.isBackwardOriented()) edge.setBackwardOriented(DG, edge);
                                }
                            }
                        }
                    }

                    //ab ~ ca
                    if (G.getEdgeSource(orientedEdge) == G.getEdgeTarget(edge)) {
                        //Check if the path W from b to c exists
                        GraphPath pathComplement = dijkComplement.getPath(G.getEdgeTarget(orientedEdge), G.getEdgeSource(edge));
                        if (pathComplement == null) {
                            continue;
                        }
                        if (pathComplement.getLength() >= 1) {
                            Object[] pathComplementVertexSet = pathComplement.getVertexList().toArray();
                            for (int k = 1; k <= pathComplementVertexSet.length - 1; k++) {
                                GraphPath pathG = dijkG.getPath(G.getEdgeSource(orientedEdge), pathComplementVertexSet[k]);
                                if (pathG == null) {
                                    continue;
                                }
                                if (pathG.getLength() == 1) {
                                    if (orientedEdge.isForwardOriented()) edge.setBackwardOriented(DG, edge);
                                    else if (orientedEdge.isBackwardOriented()) edge.setForwardOrientation(DG, edge);
                                }
                                if (pathG.getLength() >= 1 && pathG.getLength() <= pathComplement.getLength() - 1) {
                                    if (orientedEdge.isForwardOriented()) edge.setBackwardOriented(DG, edge);
                                    else if (orientedEdge.isBackwardOriented()) edge.setForwardOrientation(DG, edge);
                                }
                            }
                        }
                    }

                    //ba ~ ac
                    if (G.getEdgeTarget(orientedEdge) == G.getEdgeSource(edge)) {
                        //Check if the path W from b to c exists
                        GraphPath pathComplement = dijkComplement.getPath(G.getEdgeSource(orientedEdge), G.getEdgeTarget(edge));
                        if (pathComplement == null) {
                            continue;
                        }
                        if (pathComplement.getLength() >= 1) {
                            Object[] pathComplementVertexSet = pathComplement.getVertexList().toArray();
                            for (int k = 1; k <= pathComplementVertexSet.length - 1; k++) {
                                GraphPath pathG = dijkG.getPath(G.getEdgeTarget(orientedEdge), pathComplementVertexSet[k]);
                                if (pathG == null) {
                                    continue;
                                }
                                if (pathG.getLength() == 1) {
                                    if (orientedEdge.isForwardOriented()) edge.setBackwardOriented(DG, edge);
                                    else if (orientedEdge.isBackwardOriented()) edge.setForwardOrientation(DG, edge);
                                }
                                if (pathG.getLength() >= 1 && pathG.getLength() <= pathComplement.getLength() - 1) {
                                    if (orientedEdge.isForwardOriented()) edge.setBackwardOriented(DG, edge);
                                    else if (orientedEdge.isBackwardOriented()) edge.setForwardOrientation(DG, edge);
                                }
                            }
                        }
                    }

                    //ba ~ ca
                    if (G.getEdgeTarget(orientedEdge) == G.getEdgeTarget(edge)) {
                        //Check if the path W from b to c exists
                        GraphPath pathComplement = dijkComplement.getPath(G.getEdgeSource(orientedEdge), G.getEdgeSource(edge));
                        if (pathComplement == null) {
                            continue;
                        }
                        if (pathComplement.getLength() >= 1) {
                            Object[] pathComplementVertexSet = pathComplement.getVertexList().toArray();
                            for (int k = 1; k <= pathComplementVertexSet.length - 1; k++) {
                                GraphPath pathG = dijkG.getPath(G.getEdgeTarget(orientedEdge), pathComplementVertexSet[k]);
                                if (pathG == null) {
                                    continue;
                                }
                                if (pathG.getLength() == 1) {
                                    if (orientedEdge.isForwardOriented()) edge.setForwardOrientation(DG, edge);
                                    else if (orientedEdge.isBackwardOriented()) edge.setBackwardOriented(DG, edge);
                                }
                                if (pathG.getLength() >= 1 && pathG.getLength() <= pathComplement.getLength() - 1) {
                                    if (orientedEdge.isForwardOriented()) edge.setForwardOrientation(DG, edge);
                                    else if (orientedEdge.isBackwardOriented()) edge.setBackwardOriented(DG, edge);
                                }
                            }
                        }
                    }
                }
            }
        }
        return DG;
    }
}
