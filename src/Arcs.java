import java.util.List;
import java.util.ArrayList;

public class Arcs {
    private List<Arc> arcs;

    public Arcs() {
        arcs = new ArrayList<>();
    }

    public void ajouterArc(Arc a) {
        arcs.add(a);
    }

    public List<Arcs> getArcs() {
        return arcs;
    }
}