import org.example.fichiers.Arc;
import org.example.fichiers.Arcs;
import org.example.fichiers.Valeur;
import org.example.fichiers.GrapheListe;
import org.example.fichiers.BellmanFord;
import org.example.fichiers.Dijkstra;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGraphe{

    @Test
    public void testConstructionGraphe(){
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 10);
        g.ajouterArc("A", "C", 20);
        g.ajouterArc("B", "D", 15);

        assertEquals(0, g.getIndice("A"));
        assertEquals(3, g.getIndice("D"));

        assertEquals("B", g.getAdjacence().get(0).getArcs().get(0).getDest()); //Le premier arc sortant de A doit etre B
        assertEquals(12, g.getAdjacence().get(0).getArcs().get(0).getCout()); // Le cout du premier arc sortant de A doit etre egal au cout de l'arc reliant A a B, soit 12
    }

    @Test
    public void testPointfixe(){

        GrapheListe graphepf = new GrapheListe();
        graphepf.ajouterArc("A", "B", 6);
        graphepf.ajouterArc("A", "D", 2);
        graphepf.ajouterArc("B", "C", 4);
        graphepf.ajouterArc("D", "B", 1);
        graphepf.ajouterArc("C", "D", 3);

        BellmanFord bellmanFord = new BellmanFord();
        Valeur resultats = bellmanFord.resoudre(graphepf, "A");

        // Vérifier les valeurs des plus courts chemins
        assertEquals(0.0, resultats.getValeur("A"));
        assertEquals(5.0, resultats.getValeur("B"));

        // Vérifier les parents des nœuds
        assertNull(null, resultats.getParent("A"));
        assertEquals("A", resultats.getParent("B"));
    }

    @Test
    public void testDijkstra() {

        GrapheListe graphedij = new GrapheListe();
        graphedij.ajouterArc("A", "B", 6);
        graphedij.ajouterArc("A", "D", 2);
        graphedij.ajouterArc("B", "C", 4);
        graphedij.ajouterArc("D", "B", 1);
        graphedij.ajouterArc("C", "D", 3);

        Dijkstra dijkstra = new Dijkstra();
        Valeur resultats = dijkstra.resoudre(graphedij, "A");

        // Vérifier les valeurs des plus courts chemins
        assertEquals(0.0, resultats.getValeur("A"));
        assertEquals(3.0, resultats.getValeur("B"));
        assertEquals(7.0, resultats.getValeur("C"));
        assertEquals(2.0, resultats.getValeur("D"));

        // Vérifier les parents des nœuds
        assertNull(resultats.getParent("A"));
        assertEquals("D", resultats.getParent("B"));
        assertEquals("B", resultats.getParent("C"));
        assertEquals("A", resultats.getParent("D"));
    }
}