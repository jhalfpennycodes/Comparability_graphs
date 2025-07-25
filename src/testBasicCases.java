import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;

public class testBasicCases {

    public static void runBasicTests(String algorithm){

        testBasicCases.testTriangle(algorithm);
        testBasicCases.testSquare(algorithm);
        testBasicCases.testExtendedTriangle(algorithm);
        testBasicCases.testHouseGraph(algorithm);
        testBasicCases.starGraph(algorithm);
        testBasicCases.kiteGraph(algorithm);
        testBasicCases.testFourTriangleGraph(algorithm);
        testBasicCases.testAlternateFourTriangleGraph(algorithm);
    }

    public static void testTriangle(String algorithm) {
        //Test square
        String graphType = "Basic triangle";
        String file = "basicResults.csv";
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graph graph = basicGraphs.triangleGraph();
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


    public static void testSquare(String algorithm) {
        //Test square
        String graphType = "Basic square graph";
        String file = "basicResults.csv";
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graph graph = basicGraphs.squareGraph();
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

    public static void testExtendedTriangle(String algorithm) {
        //Test extended triangle
        String graphType = "Basic extended triangle graph";
        String file = "basicResults.csv";
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graph graph = basicGraphs.extendedTriangle();
        long runningTime = 0;
        if (algorithm=="Gamma") {
            long startTimeSquare = System.currentTimeMillis();
            DG = gamma04.forceDirection(graph);
            long endTimeSquare = System.currentTimeMillis();
            runningTime = endTimeSquare - startTimeSquare;
        }
        else if (algorithm=="Knotting"){
            long startTimeSquare = System.currentTimeMillis();
            DG = knotting02.Knotting(graph);
            long endTimeSquare = System.currentTimeMillis();
            runningTime = endTimeSquare - startTimeSquare;
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

    public static void testHouseGraph(String algorithm) {
        //Test extended triangle
        String graphType = "Basic house graph";
        String file = "basicResults.csv";
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graph graph = basicGraphs.houseGraph();
        long runningTime = 0;
        if (algorithm=="Gamma") {
            long startTimeSquare = System.currentTimeMillis();
            DG = gamma04.forceDirection(graph);
            long endTimeSquare = System.currentTimeMillis();
            runningTime = endTimeSquare - startTimeSquare;
        }
        else if (algorithm=="Knotting"){
            long startTimeSquare = System.currentTimeMillis();
            DG = knotting02.Knotting(graph);
            long endTimeSquare = System.currentTimeMillis();
            runningTime = endTimeSquare - startTimeSquare;
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

    public static void starGraph(String algorithm) {
        //Test extended triangle
        String graphType = "Basic star graph";
        String file = "basicResults.csv";
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graph graph = basicGraphs.starGraph();
        long runningTime = 0;
        if (algorithm=="Gamma") {
            long startTimeSquare = System.currentTimeMillis();
            DG = gamma04.forceDirection(graph);
            long endTimeSquare = System.currentTimeMillis();
            runningTime = endTimeSquare - startTimeSquare;
        }
        else if (algorithm=="Knotting"){
            long startTimeSquare = System.currentTimeMillis();
            DG = knotting02.Knotting(graph);
            long endTimeSquare = System.currentTimeMillis();
            runningTime = endTimeSquare - startTimeSquare;
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

    public static void kiteGraph(String algorithm) {
        //Test extended triangle
        String graphType = "Basic kite graph";
        String file = "basicResults.csv";
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graph graph = basicGraphs.kiteGraph();
        long runningTime = 0;
        if (algorithm=="Gamma") {
            long startTimeSquare = System.currentTimeMillis();
            DG = gamma04.forceDirection(graph);
            long endTimeSquare = System.currentTimeMillis();
            runningTime = endTimeSquare - startTimeSquare;
        }
        else if (algorithm=="Knotting"){
            long startTimeSquare = System.currentTimeMillis();
            DG = knotting02.Knotting(graph);
            long endTimeSquare = System.currentTimeMillis();
            runningTime = endTimeSquare - startTimeSquare;
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

    public static void testFourTriangleGraph(String algorithm) {
        //Test square
        String graphType = "Basic four triangle graph";
        String file = "basicResults.csv";
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graph graph = basicGraphs.fourTriangleGraph();
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

    public static void testAlternateFourTriangleGraph(String algorithm) {
        //Test square
        String graphType = "Basic alternate four triangle graph";
        String file = "basicResults.csv";
        DefaultDirectedGraph<String, OrientableEdge> DG = new DefaultDirectedGraph<>(OrientableEdge.class);
        Graph graph = basicGraphs.alternateFourTriangleGraph();
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
