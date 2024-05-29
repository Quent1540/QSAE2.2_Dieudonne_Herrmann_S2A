import org.example.fichiers.Arc;
import org.example.fichiers.Arcs;
import org.example.fichiers.GrapheListe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGraphe {

    @Test
    public void testConstructionGraphe() {
        GrapheListe g = new GrapheListe();

        // Ajoutez des arcs au graphe
        g.ajouterArc("A", "B", 10);
        g.ajouterArc("A", "C", 20);
        g.ajouterArc("B", "D", 15);

        // Vérifiez si les arcs ont été correctement ajoutés
        assertEquals(0, g.getIndice("A")); // Vérifie que le nœud "A" a été ajouté
        assertEquals(1, g.getIndice("B")); // Vérifie que le nœud "B" a été ajouté
        assertEquals(2, g.getIndice("C")); // Vérifie que le nœud "C" a été ajouté
        assertEquals(3, g.getIndice("D")); // Vérifie que le nœud "D" a été ajouté

        // Vérifiez les arcs sortants du nœud "A"
        assertEquals(2, g.getAdjacence().get(0).getArcs().size()); //Il doit y avoir deux arcs sortant de A
        assertEquals("B", g.getAdjacence().get(0).getArcs().get(0).getDest()); //Le premier arc sortant de A doit etre B
        assertEquals(12, g.getAdjacence().get(0).getArcs().get(0).getCout()); // Le cout du premier arc sortant de A doit etre egal au cout de l'arc reliant A a B, soit 12
    }

    // Ajoutez d'autres méthodes de test selon vos besoins
}