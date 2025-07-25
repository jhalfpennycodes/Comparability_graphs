import org.jgrapht.Graph;

public class strictPartialOrder {

    public static boolean isIrreflexive(Graph graph){
        for (Object vertex : graph.vertexSet()) {
            if (graph.containsEdge(vertex, vertex)) return false;
        }
        return true;
    }

    public static boolean isAntiSymmetric(Graph graph) {
        for (Object vertex1 : graph.vertexSet()){
            for (Object vertex2 : graph.vertexSet()){
                if (vertex1.equals(vertex2)){
                    if (graph.containsEdge(vertex1, vertex2)
                            && graph.containsEdge(vertex2, vertex1)) return false;
                }
            }
        }
        return true;
    }

    public static boolean isTransitive(Graph graph){
        for (Object vertex1 : graph.vertexSet()) {
            for (Object vertex2 : graph.vertexSet()) {
                if (!vertex1.equals(vertex2) && !graph.containsEdge(vertex1, vertex1)) return false;
            }
        }
        return true;
    }
}
