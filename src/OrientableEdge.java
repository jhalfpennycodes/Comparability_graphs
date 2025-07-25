import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class OrientableEdge extends DefaultEdge {

    private boolean isOriented = false;
    private boolean isForwardOriented = false;
    private boolean isBackwardOriented = false;

    public boolean isOriented() { return  isOriented; }
    public boolean isForwardOriented() {
        return isForwardOriented;
    }
    public boolean isBackwardOriented() { return  isBackwardOriented; }

    public void setForwardOrientation(DefaultDirectedGraph<String, OrientableEdge> graph, OrientableEdge edge) {
        graph.addEdge(graph.getEdgeSource(edge), graph.getEdgeTarget(edge));
        this.isForwardOriented = true;
        this.isOriented = true;
    }

    public void setBackwardOriented(DefaultDirectedGraph<String, OrientableEdge> graph, OrientableEdge edge) {
        graph.addEdge(graph.getEdgeTarget(edge), graph.getEdgeSource(edge));
        this.isBackwardOriented = true;
        this.isOriented = true;
    }


}