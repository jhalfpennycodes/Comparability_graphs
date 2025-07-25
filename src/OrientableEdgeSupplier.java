import java.io.Serializable;
import java.util.function.Supplier;

public class OrientableEdgeSupplier {
    public static Supplier<OrientableEdge> createOrientableEdgeSupplier()
    {
        return ORIENTABLE_EDGE_SUPPLIER;
    }

    public static final Supplier<OrientableEdge> ORIENTABLE_EDGE_SUPPLIER =
            (Supplier<OrientableEdge> & Serializable) OrientableEdge::new;
}
