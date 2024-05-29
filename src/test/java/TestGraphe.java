import org.example.fichiers.Arc;
import org.example.fichiers.Arcs;
import org.example.fichiers.GrapheListe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGraphe {

    @Test
    public void testConstructionGraphe() {
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 10);
        g.ajouterArc("A", "C", 20);
        g.ajouterArc("B", "D", 15);

        assertEquals(0, g.getIndice("A")); //On verifie que le noeud A a bien ete ajoute
        assertEquals(3, g.getIndice("D")); // On verifie que le noeud D a bien ete ajoute

        assertEquals("B", g.getAdjacence().get(0).getArcs().get(0).getDest()); //Le premier arc sortant de A doit etre B
        assertEquals(12, g.getAdjacence().get(0).getArcs().get(0).getCout()); // Le cout du premier arc sortant de A doit etre egal au cout de l'arc reliant A a B, soit 12
    }
}