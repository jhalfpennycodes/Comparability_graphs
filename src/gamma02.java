import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.exit;


public class gamma02 {

    static DefaultDirectedGraph<String, DefaultEdge> forceDirection(Graph<String, DefaultEdge> G){
        //---------------------------CREATE NEW DIRECTED GRAPH:---------------------------
        //Create a directed graph based off the vertex and edge array
        DefaultDirectedGraph<String, DefaultEdge> DG = new DefaultDirectedGraph<>(DefaultEdge.class);
        //Add same vertices as graph G to the directed graph
        Graphs.addAllVertices(DG, G.vertexSet());

        //---------------------------RANDOM ORIENTATION:---------------------------
        //Assign random orientation to arbitrary edge
        DefaultEdge arbitraryEdge = G.edgeSet().iterator().next();
        DG.addEdge(G.getEdgeSource(arbitraryEdge), G.getEdgeTarget(arbitraryEdge));

        for (DefaultEdge directedEdge: DG.edgeSet()){
            for (DefaultEdge undirectedEdge : G.edgeSet()){
                //Do not need to check edges with themselves
                if (directedEdge.equals(undirectedEdge)) continue;

                //Check if orientation has already been assigned
                if (DG.getEdgeSource(directedEdge)==G.getEdgeTarget(undirectedEdge) &&
                        DG.getEdgeTarget(directedEdge)==G.getEdgeSource(undirectedEdge)) continue;

                //Apply Force Direction rule
                //ab Γ a'b' iff ---> then:
                //either a = a' and bb' ∉ E
                //or     b = b' and aa' ∉ E
                if ((DG.getEdgeSource(directedEdge)==G.getEdgeSource(undirectedEdge) &&
                !G.containsEdge(DG.getEdgeTarget(directedEdge), G.getEdgeTarget(undirectedEdge)))){
                    DG.addEdge(G.getEdgeSource(undirectedEdge), G.getEdgeTarget(undirectedEdge));
                    System.out.println("1.--------------");
                    System.out.println("Comparing: " + directedEdge + " - " + undirectedEdge);
                    System.out.println("DG Edge source = " + DG.getEdgeSource(directedEdge));
                    System.out.println("G Edge source = "+G.getEdgeSource(undirectedEdge));
                    System.out.println("G does not contain: " + DG.getEdgeTarget(directedEdge) + "->" + G.getEdgeTarget(undirectedEdge));
                    System.out.println("Added edge is: " + G.getEdgeSource(undirectedEdge) + "->" + G.getEdgeTarget(undirectedEdge));
                }

                if ((DG.getEdgeTarget(directedEdge) ==G.getEdgeTarget(undirectedEdge) &&
                        !G.containsEdge(DG.getEdgeSource(directedEdge), G.getEdgeSource(undirectedEdge)))){
                    DG.addEdge(G.getEdgeSource(undirectedEdge), G.getEdgeTarget(undirectedEdge));
                    System.out.println("2.--------------");
                    System.out.println("Comparing: " + directedEdge + " - " + undirectedEdge);
                    System.out.println("DG Edge target = " + DG.getEdgeTarget(directedEdge));
                    System.out.println("G Edge target = "+G.getEdgeTarget(undirectedEdge));
                    System.out.println("G does not contain: " + DG.getEdgeSource(directedEdge) + "->" + G.getEdgeSource(undirectedEdge));
                    System.out.println("Added edge is: " + G.getEdgeSource(undirectedEdge) + "->" + G.getEdgeTarget(undirectedEdge));
                }

                if ((DG.getEdgeTarget(directedEdge)==G.getEdgeSource(undirectedEdge) &&
                        !G.containsEdge(DG.getEdgeSource(directedEdge), G.getEdgeTarget(undirectedEdge)))){
                    DG.addEdge(G.getEdgeTarget(undirectedEdge), G.getEdgeSource(undirectedEdge));
                    System.out.println("3.--------------");
                    System.out.println("Comparing: " + directedEdge + " - " + undirectedEdge);
                    System.out.println("DG Edge target = " + DG.getEdgeTarget(directedEdge));
                    System.out.println("G Edge source = "+G.getEdgeSource(undirectedEdge));
                    System.out.println("G does not contain: " + DG.getEdgeSource(directedEdge) + "->" + G.getEdgeTarget(undirectedEdge));
                    System.out.println("Added edge is: " + G.getEdgeTarget(undirectedEdge) + "->" + G.getEdgeSource(undirectedEdge));

                }

                if ((DG.getEdgeSource(directedEdge)==G.getEdgeTarget(undirectedEdge) &&
                        !G.containsEdge(G.getEdgeTarget(undirectedEdge), G.getEdgeSource(undirectedEdge)))){
                    DG.addEdge(G.getEdgeTarget(undirectedEdge), G.getEdgeSource(undirectedEdge));
                    System.out.println("3.--------------");
                    System.out.println("Comparing: " + directedEdge + " - " + undirectedEdge);
                    System.out.println("DG Edge source = " + DG.getEdgeSource(directedEdge));
                    System.out.println("G Edge target = "+G.getEdgeTarget(undirectedEdge));
                    System.out.println("G does not contain: " + DG.getEdgeTarget(directedEdge) + "->" + G.getEdgeSource(undirectedEdge));
                    System.out.println("Added edge is: " + G.getEdgeTarget(undirectedEdge) + "->" + G.getEdgeSource(undirectedEdge));
                }
            }
        }
        System.out.println(DG.edgeSet());
        return DG;
    }

    public static Graph<String, DefaultEdge> createGraph(){
        Graph<String, DefaultEdge> g = new DefaultUndirectedGraph<>(DefaultEdge.class);

        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        String e = "e";
        String f = "f";

        ////Square graph
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(c, d);
        g.addEdge(a, d);

        ////Extended triangle graph
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//        g.addVertex(d);
//        g.addVertex(e);
//        g.addVertex(f);
//        g.addEdge(a, b);
//        g.addEdge(b, c);
//        g.addEdge(b, f);
//        g.addEdge(c, d);
//        g.addEdge(c, f);
//        g.addEdge(f, e);

        ////Kite graph
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//        g.addVertex(d);
//        g.addVertex(e);
//        g.addEdge(a, b);
//        g.addEdge(a, e);
//        g.addEdge(a, c);
//        g.addEdge(a, d);
//        g.addEdge(b, c);
//        g.addEdge(b, d);
//        g.addEdge(b, e);
//        g.addEdge(c, d);


//        ////House graph
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//        g.addVertex(d);
//        g.addVertex(e);
//        g.addVertex(f);
//        g.addEdge(a,b);
//        g.addEdge(a,c);
//        g.addEdge(b,c);
//        g.addEdge(b,d);
//        g.addEdge(b,e);
//        g.addEdge(c,e);
//        g.addEdge(c,f);
//        g.addEdge(d,e);
////        g.addEdge(e,f);

        //Star
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//        g.addVertex(d);
//        g.addVertex(e);
//        g.addEdge(a,b);
//        g.addEdge(a,d);
//        g.addEdge(a,e);
//        g.addEdge(b,c);
//        g.addEdge(b,e);
//        g.addEdge(c,d);
//        g.addEdge(c,e);
//        g.addEdge(d,e);

        return g;
    }
}
