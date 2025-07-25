import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.HashSet;
import java.util.Set;

public class gamma03 {

    static DefaultDirectedGraph<String, OrientableEdge> forceDirection(Graph<String, OrientableEdge> G) {
        //---------------------------CREATE NEW DIRECTED GRAPH:---------------------------
        //Create a directed graph based on input graph
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        DefaultDirectedGraph<String, OrientableEdge> Failed = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graphs.addAllVertices(DG, G.vertexSet());



        //---------------------------RANDOM ORIENTATION:---------------------------
        //Assign random orientation to arbitrary edge
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
                        System.out.println("Should be oriented: " + edge);
                        if (orientedEdge.isForwardOriented()) edge.setForwardOrientation(DG, edge);
                        else if (orientedEdge.isBackwardOriented()) edge.setBackwardOriented(DG, edge);

                        System.out.println("1.--------------");
                        System.out.println("Comparing: " + orientedEdge + " - " + edge);
                        System.out.println("DG Edge source = " + DG.getEdgeSource(orientedEdge));
                        System.out.println("G Edge source = " + G.getEdgeSource(orientedEdge));
                        System.out.println("G does not contain: " + DG.getEdgeTarget(orientedEdge) + "->" + G.getEdgeTarget(edge));
                        System.out.println("Added edge is: " + G.getEdgeSource(edge) + "->" + G.getEdgeTarget(edge));
                        System.out.println("Is oriented: " + edge.isOriented());
                    }

                    if ((G.getEdgeTarget(orientedEdge) == G.getEdgeTarget(edge) &&
                            !G.containsEdge(G.getEdgeSource(orientedEdge), G.getEdgeSource(edge)))) {
                        if (orientedEdge.isForwardOriented()) edge.setForwardOrientation(DG, edge);
                        else if (orientedEdge.isBackwardOriented()) edge.setBackwardOriented(DG, edge);

                        System.out.println("2.--------------");
                        System.out.println("Comparing: " + orientedEdge + " - " + edge);
                        System.out.println("DG Edge target = " + DG.getEdgeTarget(orientedEdge));
                        System.out.println("G Edge target = " + G.getEdgeTarget(edge));
                        System.out.println("G does not contain: " + DG.getEdgeSource(orientedEdge) + "->" + G.getEdgeSource(edge));
                        System.out.println("Added edge is: " + G.getEdgeSource(edge) + "->" + G.getEdgeTarget(edge));
                    }

                    if ((G.getEdgeTarget(orientedEdge) == G.getEdgeSource(edge) &&
                            !G.containsEdge(G.getEdgeSource(orientedEdge), G.getEdgeTarget(edge)))) {
                        if (orientedEdge.isForwardOriented()) edge.setBackwardOriented(DG, edge);
                        else if (orientedEdge.isBackwardOriented()) edge.setForwardOrientation(DG, edge);

                        System.out.println("3.--------------");
                        System.out.println("Comparing: " + orientedEdge + " - " + edge);
                        System.out.println("DG Edge target = " + DG.getEdgeTarget(orientedEdge));
                        System.out.println("G Edge source = " + G.getEdgeSource(edge));
                        System.out.println("G does not contain: " + DG.getEdgeSource(orientedEdge) + "->" + G.getEdgeTarget(edge));
                        System.out.println("Added edge is: " + G.getEdgeTarget(edge) + "->" + G.getEdgeSource(edge));
                    }

                    if ((G.getEdgeSource(orientedEdge) == G.getEdgeTarget(edge) &&
                            !G.containsEdge(G.getEdgeTarget(orientedEdge), G.getEdgeSource(edge)))) {
                        if (orientedEdge.isForwardOriented()) edge.setBackwardOriented(DG, edge);
                        else if (orientedEdge.isBackwardOriented()) edge.setForwardOrientation(DG, edge);

                        System.out.println("4.--------------");
                        System.out.println("Comparing: " + orientedEdge + " - " + edge);
                        System.out.println("DG Edge source = " + DG.getEdgeSource(orientedEdge));
                        System.out.println("G Edge target = " + G.getEdgeTarget(edge));
                        System.out.println("G does not contain: " + DG.getEdgeTarget(orientedEdge) + "->" + G.getEdgeSource(edge));
                        System.out.println("Added edge is: " + G.getEdgeTarget(edge) + "->" + G.getEdgeSource(edge));
                    }
                }
            }
            while (!orientedEdge.isOriented()) {
                orientedEdge.setForwardOrientation(DG, orientedEdge);
            }
        }
        if (DG.edgeSet().size()==G.edgeSet().size()) {
            System.out.println(DG);
            return DG;
        }
        else {
            System.out.println(G);
            System.out.println(DG);
            return Failed;
        }
    }
}
