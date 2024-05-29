package org.example.fichiers;
import java.util.List;
import java.util.ArrayList;

public class GrapheListe implements Graphe {
    private ArrayList<String> noeuds;
    private ArrayList<Arcs> adjacence;

    public GrapheListe() {
        noeuds = new ArrayList<>();
        adjacence = new ArrayList<>();
    }

    public int getIndice(String n) {
        return noeuds.indexOf(n);
    }

    public void ajouterArc(String depart, String destination, double cout) {
        if (!noeuds.contains(depart)) {
            noeuds.add(depart);
            adjacence.add(new Arcs());
        }
        if (!noeuds.contains(destination)) {
            noeuds.add(destination);
            adjacence.add(new Arcs());
        }

        int indiceDepart = getIndice(depart);
        int indiceDestination = getIndice(destination);

        adjacence.get(indiceDepart).ajouterArc(new Arc(destination, cout));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Parcours de tous les noeuds
        for (int i = 0; i < noeuds.size(); i++) {
            String noeud = noeuds.get(i);
            Arcs arcsSortants = adjacence.get(i);

            // Construction de la chaîne pour le noeud actuel
            sb.append(noeud).append(" -> ");

            // Ajout des arcs sortants
            List<Arc> arcs = arcsSortants.getArcs();
            for (int j = 0; j < arcs.size(); j++) {
                Arc arc = arcs.get(j);
                sb.append(arc.getDestination()).append("(").append(arc.getCout()).append(")");
                if (j < arcs.size() - 1) {
                    sb.append(" ");
                }
            }

            sb.append("\n");
        }
    }
}
