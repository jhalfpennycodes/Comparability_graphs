import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.generate.ComplementGraphGenerator;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class knotting {

    private static Graph<String, DefaultEdge> createGraph(){
        Graph<String, DefaultEdge> g = new DefaultUndirectedGraph<>(DefaultEdge.class);

        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        String e = "e";
        String f = "f";

//        //Square graph
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//        g.addVertex(d);
//        g.addEdge(a, b);
//        g.addEdge(b, c);
//        g.addEdge(c, d);
//        g.addEdge(a, d);

//        //Square graph with point
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//        g.addVertex(d);
//        g.addVertex(e);
//        g.addEdge(a, b);
//        g.addEdge(b, c);
//        g.addEdge(c, d);
//        g.addEdge(a, d);
//        g.addEdge(a, e);


//        Square with line
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addEdge(a, b);
        g.addEdge(a, d);
        g.addEdge(a, c);
        g.addEdge(b, c);
        g.addEdge(b, d);

        //Extended triangle graph
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

//        //Kite graph
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


        //House graph
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
//        g.addEdge(e,f);

//        //Star
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

          //Knotting trial
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//
//        g.addEdge(a,b);
//        g.addEdge(a,c);

        return g;
    }

    static void Knotting(Graph G) {
        //---------------------------RETRIEVE GRAPH G INFORMATION:---------------------------
        //Convert the edges and vertices to array format
        Object[] vertexSet = G.vertexSet().toArray();
        Object[] edgeSet = G.edgeSet().toArray();

        //---------------------------CREATE NEW DIRECTED GRAPH:---------------------------
        //Create a directed graph based off the vertex and edge array
        DefaultDirectedGraph<String, DefaultEdge> DG = new DefaultDirectedGraph<>(DefaultEdge.class);

        //Add same vertices as graph G to the directed graph
        for (Object o : vertexSet) {
            DG.addVertex((String) o);
        }

        //Generate the complement graph of G
        ComplementGraphGenerator<String, DefaultEdge> g = new ComplementGraphGenerator<String, DefaultEdge>(G);
        Graph<String, DefaultEdge> complement = new DefaultUndirectedGraph<>(DefaultEdge.class);
        g.generateGraph(complement);

        //Create instances of Dijkstra algorithm
        DijkstraShortestPath dijkComplement = new DijkstraShortestPath(complement);
        DijkstraShortestPath dijkG = new DijkstraShortestPath<>(G);


        //Get the array of directed edges
        Object[] directedEdgeSet = DG.edgeSet().toArray();
        for (int i=0; i<directedEdgeSet.length; i++){
            System.out.println(directedEdgeSet[i]);
        }



        System.out.println("Graph G: " + G);
        System.out.println("Complement of graph G: " + complement);

        for (int i=0; i<edgeSet.length; i++){
            for (int j=0; j<edgeSet.length; j++){
                //Case where for ab ~ ac, b=c. Check source adn target are the same.
                if (G.getEdgeSource(edgeSet[i])==G.getEdgeSource(edgeSet[j]) &&
                        G.getEdgeTarget(edgeSet[i])==G.getEdgeTarget(edgeSet[j])){
                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))==false &
                            DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))==false) {
                        System.out.println("0-----------");
                        System.out.println("Round i="+i+", j="+j);
                        System.out.println(G.getEdgeSource(edgeSet[i])+"="+G.getEdgeSource(edgeSet[j]) +", "+G.getEdgeTarget(edgeSet[i])+"="+G.getEdgeTarget(edgeSet[j]));
                        System.out.println("DG does NOT contain: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i])+ " or "+
                                G.getEdgeTarget(edgeSet[i])+ "->" + G.getEdgeSource(edgeSet[i]));
                        System.out.println(DG);
                        System.out.println(DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i])));
                        System.out.println(DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i])));
                        System.out.println("Edge added to DG: "+ G.getEdgeSource(edgeSet[i])+ "->" + G.getEdgeTarget(edgeSet[i]));
                        DG.addEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]));
                    }
                }


                //----------------------------------------Cases where: ab ~ ac -------------------------------------------
                //1.For ab ~ ac check if a == a:
                if (G.getEdgeSource(edgeSet[i]) == G.getEdgeSource(edgeSet[j])) {
                    //2. Check b != c:
                    if (G.getEdgeTarget(edgeSet[i]) != G.getEdgeTarget(edgeSet[j])) {
                        //3. Check if the complement of G contains a path W from b to c where path length k≥1
                        //Create an instance of a path from b to c
                        GraphPath pathComplement = dijkComplement.getPath(G.getEdgeTarget(edgeSet[i]), G.getEdgeTarget(edgeSet[j]));
                        if (pathComplement==null){
                            continue;
                        }
                        if (pathComplement.getLength() >= 1) {
                            //4.Check if G contains a path from a to any vertex within W where the path length x,
                            // is greater than 1 and less than the path length of W, 1 ≤ x ≤ k-1:
                            //4.1.Get all possible xi values and store into array:
                            Object[] pathComplementVertexSet = pathComplement.getVertexList().toArray();
                            for (int k = 1; k <= pathComplementVertexSet.length - 1; k++) {
                                //4.2. Iterate through the possible path values to find any path equivalent to axi:
                                GraphPath pathG = dijkG.getPath(G.getEdgeSource(edgeSet[i]), pathComplementVertexSet[k]);
                                //4.3. Check if the path length L found from a to xi is: 1 ≤ L ≤ k-1:
                                if (pathG.getLength() == 1) {
                                    //Check if a->b is already oriented, if true then orient a->c
                                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))) {
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("1.1-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                    //Check if b->a is already oriented, if true then orient c->a
                                    else if (DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))){
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("1.2-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Otherwise, orient both a->b and a->c
                                    else{
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]));
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("1.3-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG does NOT contain any of the edges from: "+G.getEdgeSource(edgeSet[i])
                                                + "->" + G.getEdgeTarget(edgeSet[i])+" or " +G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edges added to DG: "+ G.getEdgeSource(edgeSet[i])+ "->"+G.getEdgeTarget(edgeSet[i])+", "+
                                                G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                }
                                if (pathG.getLength() >= 1 && pathG.getLength() <= pathComplement.getLength()-1) {
                                    //Check if a->b is already oriented, if true then orient a->c
                                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))) {
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("1.4-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                    //Check if b->a is already oriented, if true then orient c->a
                                    else if (DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))){
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("1.5-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Otherwise, orient both a->b and a->c
                                    else{
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]));
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("1.6-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG does NOT contain any of the edges from: "+G.getEdgeSource(edgeSet[i])
                                                + "->" + G.getEdgeTarget(edgeSet[i])+" or " +G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edges added to DG: "+ G.getEdgeSource(edgeSet[i])+ "->"+G.getEdgeTarget(edgeSet[i])+", "+
                                                G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                }
                            }
                        }
                    }
                }


            //----------------------------------------Cases where: ba ~ ac -------------------------------------------
            //1.For ba ~ ac check if a==a:

                if (G.getEdgeTarget(edgeSet[i]) == G.getEdgeSource(edgeSet[j])) {
                    //2. Check if b!=c:
                    if (G.getEdgeSource(edgeSet[i]) != G.getEdgeTarget(edgeSet[j])) {
                        //3. Check if the complement of G contains a path W from b to c where path length k≥1
                        //Create instance of a path from b to c, in the format of ba ~ ac:
                        GraphPath pathComplement = dijkComplement.getPath(G.getEdgeSource(edgeSet[i]), G.getEdgeTarget(edgeSet[j]));
                        if (pathComplement==null){
                            continue;
                        }
                        if (pathComplement.getLength() >= 1) {
                            //4.Check if G contains a path from a to any vertex within W where the path length x,
                            // is greater than 1 and less than the path length of W, 1 ≤ x ≤ k-1
                            //4.1.Get all possible xi values and store into array
                            Object[] pathComplementVertexSet = pathComplement.getVertexList().toArray();
                            for (int k = 0; k < pathComplementVertexSet.length; k++) {
                                //4.2. Iterate through possible paths from a to xi in G
                                GraphPath pathG = dijkG.getPath(G.getEdgeTarget(edgeSet[i]), pathComplementVertexSet[k]);
                                //4.3. Check if the path length found from a to xi is less than length of W:
                                if (pathG.getLength() == 1) {
                                    //Check if a->b is already oriented, if true then orient a->c
                                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))) {
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("2.1-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Check if b->a is already oriented, if true then orient c->a
                                    else if (DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))){
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("2.2-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                    //Otherwise, orient both a->b and a->c
                                    else{
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]));
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("2.3-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG does NOT contain any of the edges from: "+G.getEdgeSource(edgeSet[i])
                                                + "->" + G.getEdgeTarget(edgeSet[i])+" or " +G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edges added to DG: "+ G.getEdgeTarget(edgeSet[i])+ "->"+G.getEdgeSource(edgeSet[i])+", "+
                                                G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                }
                                if (pathG.getLength() >= 1 && pathG.getLength() <= pathComplement.getLength()-1) {
                                    //Check if a->b is already oriented, if true then orient a->c
                                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))) {
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("2.4-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Check if b->a is already oriented, if true then orient c->a
                                    else if (DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))){
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("2.5-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                    //Otherwise, orient both a->b and a->c
                                    else{
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]));
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("2.6-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG does NOT contain any of the edges from: "+G.getEdgeSource(edgeSet[i])
                                                + "->" + G.getEdgeTarget(edgeSet[i])+" or " +G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edges added to DG: "+ G.getEdgeTarget(edgeSet[i])+ "->"+G.getEdgeSource(edgeSet[i])+", "+
                                                G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                }
                            }
                        }
                    }
                }


            //----------------------------------------Cases where: ba ~ ca -------------------------------------------

                //1.For ba ~ ac check if a==a:
                if (G.getEdgeTarget(edgeSet[i]) == G.getEdgeTarget(edgeSet[j])) {
                    //2. Check if b!=c:
                    if (G.getEdgeSource(edgeSet[i]) != G.getEdgeSource(edgeSet[j])) {
                        //3. Check if the complement of G contains a path W from b to c where path length k≥1
                        //Create instance of a path from b to c, in the format of ba ~ ac:
                        GraphPath pathComplement = dijkComplement.getPath(G.getEdgeSource(edgeSet[i]), G.getEdgeSource(edgeSet[j]));
                        if (pathComplement==null){
                            continue;
                        }
                        if (pathComplement.getLength() >= 1) {
                            //4.Check if G contains a path from a to any vertex within W where the path length x,
                            // is greater than 1 and less than the path length of W, 1 ≤ x ≤ k-1
                            //4.1.Get all possible xi values and store into array
                            Object[] pathComplementVertexSet = pathComplement.getVertexList().toArray();
                            for (int k = 0; k < pathComplementVertexSet.length; k++) {
                                //4.2. Iterate through possible paths from a to xi in G
                                GraphPath pathG = dijkG.getPath(G.getEdgeTarget(edgeSet[i]), pathComplementVertexSet[k]);
                                //4.3. Check if the path length found from a to xi is less than length of W:
                                if (pathG.getLength() == 1) {
                                    //Check if a->b is already oriented, if true then orient a->c
                                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))) {
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("3.1-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Check if b->a is already oriented, if true then orient c->a
                                    else if (DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))){
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("3.2-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Otherwise, orient both a->b and a->c
                                    else{
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]));
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("3.3-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG does NOT contain any of the edges from: "+G.getEdgeSource(edgeSet[i])
                                                + "->" + G.getEdgeTarget(edgeSet[i])+" or " +G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edges added to DG: "+ G.getEdgeSource(edgeSet[i])+ "->"+G.getEdgeTarget(edgeSet[i])+", "+
                                                G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                }
                                if (pathG.getLength() >= 1 && pathG.getLength() <= pathComplement.getLength()-1) {
                                    //Check if a->b is already oriented, if true then orient a->c
                                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))) {
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("3.4-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Check if b->a is already oriented, if true then orient c->a
                                    else if (DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))){
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("3.5-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Otherwise, orient both a->b and a->c
                                    else{
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]));
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("3.6-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG does NOT contain any of the edges from: "+G.getEdgeSource(edgeSet[i])
                                                + "->" + G.getEdgeTarget(edgeSet[i])+" or " +G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edges added to DG: "+ G.getEdgeSource(edgeSet[i])+ "->"+G.getEdgeTarget(edgeSet[i])+", "+
                                                G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                }
                            }
                        }
                    }
                }


            //----------------------------------------Cases where: ab ~ ca -------------------------------------------
                //1.For ba ~ ac check if a==a:
                if (G.getEdgeSource(edgeSet[i]) == G.getEdgeTarget(edgeSet[j])) {
                    //2. Check if b!=c:
                    if (G.getEdgeTarget(edgeSet[i]) != G.getEdgeSource(edgeSet[j])) {
                        //3. Check if the complement of G contains a path W from b to c where path length k≥1
                        //Create instance of a path from b to c, in the format of ba ~ ac:
                        GraphPath pathComplement = dijkComplement.getPath(G.getEdgeTarget(edgeSet[i]), G.getEdgeSource(edgeSet[j]));
                        if (pathComplement==null){
                            continue;
                        }
                        if (pathComplement.getLength() >= 1) {
                            //4.Check if G contains a path from a to any vertex within W where the path length x,
                            // is greater than 1 and less than the path length of W, 1 ≤ x ≤ k-1
                            //4.1.Get all possible xi values and store into array
                            Object[] pathComplementVertexSet = pathComplement.getVertexList().toArray();
                            for (int k = 0; k < pathComplementVertexSet.length; k++) {
                                //4.2. Iterate through possible paths from a to xi in G
                                GraphPath pathG = dijkG.getPath(G.getEdgeSource(edgeSet[i]), pathComplementVertexSet[k]);
                                //4.3. Check if the path length found from a to xi is less than length of W:
                                if (pathG.getLength() == 1) {
                                    //Check if a->b is already oriented, if true then orient a->c
                                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))) {
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("4.1-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Check if b->a is already oriented, if true then orient c->a
                                    else if (DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))){
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("4.2-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                    //Otherwise, orient both a->b and a->c
                                    else{
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]));
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("4.3-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG does NOT contain any of the edges from: "+G.getEdgeSource(edgeSet[i])
                                                + "->" + G.getEdgeTarget(edgeSet[i])+" or " +G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edges added to DG: "+ G.getEdgeSource(edgeSet[i])+ "->"+G.getEdgeTarget(edgeSet[i])+", "+
                                                G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                }
                                if (pathG.getLength() >= 1 && pathG.getLength() <= pathComplement.getLength()-1) {
                                    //Check if a->b is already oriented, if true then orient a->c
                                    if (DG.containsEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]))) {
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("4.4-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeSource(edgeSet[i]) + "->" + G.getEdgeTarget(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Check if b->a is already oriented, if true then orient c->a
                                    else if (DG.containsEdge((String) G.getEdgeTarget(edgeSet[i]), (String) G.getEdgeSource(edgeSet[i]))){
                                        DG.addEdge((String) G.getEdgeTarget(edgeSet[j]), (String) G.getEdgeSource(edgeSet[j]));
                                        System.out.println("4.5-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG contains: "+G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edge added to DG: "+ G.getEdgeTarget(edgeSet[j])+ "->" + G.getEdgeSource(edgeSet[j]));
                                    }
                                    //Otherwise, orient both a->b and a->c
                                    else{
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[i]), (String) G.getEdgeTarget(edgeSet[i]));
                                        DG.addEdge((String) G.getEdgeSource(edgeSet[j]), (String) G.getEdgeTarget(edgeSet[j]));
                                        System.out.println("4.6-----------");
                                        System.out.println("Round i="+i+", j="+j);
                                        System.out.println("DG does NOT contain any of the edges from: "+G.getEdgeSource(edgeSet[i])
                                                + "->" + G.getEdgeTarget(edgeSet[i])+" or " +G.getEdgeTarget(edgeSet[i]) + "->" + G.getEdgeSource(edgeSet[i]));
                                        System.out.println("Edges added to DG: "+ G.getEdgeSource(edgeSet[i])+ "->"+G.getEdgeTarget(edgeSet[i])+", "+
                                                G.getEdgeSource(edgeSet[j])+ "->" + G.getEdgeTarget(edgeSet[j]));
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        System.out.println("Directed graph: " + DG);
    }
}
