import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

public class basicGraphs {

    static String a = "a";
    static String b = "b";
    static String c = "c";
    static String d = "d";
    static String e = "e";
    static String f = "f";


    public static  Graph<String, OrientableEdge> triangleGraph(){

        Graph<String, OrientableEdge> g = new DefaultUndirectedGraph<>(OrientableEdge.class);
        ////Square graph
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(c, a);

        return g;
    }


    public static  Graph<String, OrientableEdge> squareGraph(){
        Graph<String, OrientableEdge> g = new DefaultUndirectedGraph<>(OrientableEdge.class);

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(c, d);
        g.addEdge(a, d);

        return g;
    }


    public static  Graph<String, OrientableEdge> extendedTriangle(){
        Graph<String, OrientableEdge> g = new DefaultUndirectedGraph<>(OrientableEdge.class);

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);
        g.addVertex(f);
        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(b, f);
        g.addEdge(c, d);
        g.addEdge(c, f);
        g.addEdge(f, e);

        return g;
    }

    public static  Graph<String, OrientableEdge> houseGraph(){
        Graph<String, OrientableEdge> g = new DefaultUndirectedGraph<>(OrientableEdge.class);

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);
        g.addEdge(a, e);
        g.addEdge(a, b);
        g.addEdge(a, c);
        g.addEdge(a, d);
        g.addEdge(b, c);
        g.addEdge(b, d);
        g.addEdge(b, e);
        g.addEdge(c, d);

        return g;
    }

    public static  Graph<String, OrientableEdge> starGraph(){
        Graph<String, OrientableEdge> g = new DefaultUndirectedGraph<>(OrientableEdge.class);

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);
        g.addEdge(a,b);
        g.addEdge(a,d);
        g.addEdge(a,e);
        g.addEdge(b,c);
        g.addEdge(b,e);
        g.addEdge(c,d);
        g.addEdge(c,e);
        g.addEdge(d,e);

        return g;
    }

    public static  Graph<String, OrientableEdge> kiteGraph(){
        Graph<String, OrientableEdge> g = new DefaultUndirectedGraph<>(OrientableEdge.class);

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);
        g.addEdge(a, e);
        g.addEdge(a, b);
        g.addEdge(a, c);
        g.addEdge(a, d);
        g.addEdge(b, c);
        g.addEdge(b, d);
        g.addEdge(b, e);
        g.addEdge(c, d);

        return g;
    }

    public static  Graph<String, OrientableEdge> fourTriangleGraph(){
        Graph<String, OrientableEdge> g = new DefaultUndirectedGraph<>(OrientableEdge.class);

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);
        g.addVertex(f);
        g.addEdge(a, b);
        g.addEdge(a, c);
        g.addEdge(c, b);
        g.addEdge(c, e);
        g.addEdge(b, e);
        g.addEdge(c, d);
        g.addEdge(d, e);
        g.addEdge(b, f);
        g.addEdge(e, f);

        return g;
    }

    public static  Graph<String, OrientableEdge> alternateFourTriangleGraph(){
        Graph<String, OrientableEdge> g = new DefaultUndirectedGraph<>(OrientableEdge.class);

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);
        g.addVertex(f);
        g.addEdge(a, b);
        g.addEdge(a, c);
        g.addEdge(c, b);
        g.addEdge(c, e);
        g.addEdge(b, e);
        g.addEdge(c, d);
        g.addEdge(d, e);
        g.addEdge(b, f);

        return g;
    }


}
