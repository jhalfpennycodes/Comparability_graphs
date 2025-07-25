import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.Set;

import static java.lang.System.exit;

public class gamma {

    public static DefaultDirectedGraph<String, DefaultEdge> ForceDirection(Graph G){
        //---------------------------RETRIEVE GRAPH G INFORMATION:---------------------------
        //Retrieve the set of edges in the undirected graph G
        Set<DefaultEdge> EdgeSet = G.edgeSet();

        //Convert the edges and vertices to array format
        Object[] vertexSet = G.vertexSet().toArray();
        Object[] edgeSet = G.edgeSet().toArray();


        //---------------------------CREATE NEW DIRECTED GRAPH:---------------------------
        //Create a directed graph based off the vertex and edge array
        DefaultDirectedGraph<String, DefaultEdge> DG = new DefaultDirectedGraph<>(DefaultEdge.class);

        //Add same vertices as graph G to the directed graph
        for (int i=0; i<vertexSet.length; i++){
            DG.addVertex((String) vertexSet[i]);
        }


        //---------------------------RANDOM ORIENTATION:---------------------------
        //Assign random orientation to arbitrary edge
        DG.addEdge((String) G.getEdgeSource(edgeSet[0]), (String) G.getEdgeTarget(edgeSet[0]));

        //Convert the directed edges to array format
        Object[] directedEdgeSet = DG.edgeSet().toArray();



        //---------------------------FORCE DIRECTION RULE:---------------------------
        for (int i=0; i<directedEdgeSet.length; i++){
            for (int j=0; j<edgeSet.length; j++){
                //Do not need to check edges with themselves
                if (i==j) continue;

                //Check for cases where ab Γ ba and skip these cases as the orientation is already implemented
                if (
                        DG.getEdgeSource((DefaultEdge) directedEdgeSet[i])==G.getEdgeTarget(edgeSet[j])
                    &&
                        DG.getEdgeTarget((DefaultEdge) directedEdgeSet[i])==G.getEdgeSource(edgeSet[j])
                )
                {
                    continue;
                }

                //Apply Force Direction rule
                //ab Γ a'b' iff ---> then:
                //either a = a' and bb' ∉ E
                //or     b = b' and aa' ∉ E
                if(
                    //Check that a==a' && bb' ∉ E
                        (       DG.getEdgeSource((DefaultEdge) directedEdgeSet[i])==G.getEdgeSource(edgeSet[j])
                            &&
                                G.containsEdge(DG.getEdgeTarget((DefaultEdge) directedEdgeSet[i]), G.getEdgeTarget(edgeSet[j]))==false
                        )
                    ||
                                //Check that b==b' && aa' ∉ E
                        (
                                DG.getEdgeTarget((DefaultEdge) directedEdgeSet[i])==G.getEdgeTarget(edgeSet[j])
                            &&
                                G.containsEdge(DG.getEdgeSource((DefaultEdge) directedEdgeSet[i]), G.getEdgeSource(edgeSet[j]))==false
                        )
                )
                {
                    //Add the given edge to the directed graph
                    DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                    directedEdgeSet = DG.edgeSet().toArray();
                }


                if (
                        (
                                DG.getEdgeSource((DefaultEdge) directedEdgeSet[i]) == G.getEdgeTarget(edgeSet[j])
                            &&
                                G.containsEdge(DG.getEdgeTarget((DefaultEdge) directedEdgeSet[i]), G.getEdgeSource(edgeSet[j]))==false
                        )
                    ||
                        (
                                DG.getEdgeTarget((DefaultEdge) directedEdgeSet[i]) == G.getEdgeSource(edgeSet[j])
                            &&
                                G.containsEdge(DG.getEdgeSource((DefaultEdge) directedEdgeSet[i]), G.getEdgeTarget(edgeSet[j]))==false
                        )
                )
                {
                    DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                    directedEdgeSet = DG.edgeSet().toArray();
                }
            }
        }

        for (int i=0; i<directedEdgeSet.length; i++){
            for (int j=0; j< directedEdgeSet.length; j++){
                if (
                        DG.getEdgeSource((DefaultEdge) directedEdgeSet[i])== DG.getEdgeTarget((DefaultEdge) directedEdgeSet[j])
                    &&
                        DG.getEdgeTarget((DefaultEdge) directedEdgeSet[i])== DG.getEdgeSource((DefaultEdge) directedEdgeSet[j])
                )
                {
                    System.out.println("Undirected graph that causes failure: "+G);
                    System.out.println("The graph provided is not a comparability graph and cannot be oriented according" +
                                        " to the Gamma enforcement. Please provide a comparability graph.");
                    exit(0);
                }
            }
        }


//        System.out.println("Undirected graph: "+G);
//        System.out.println("Comparability graph"+DG);


        return DG;
    }
}
