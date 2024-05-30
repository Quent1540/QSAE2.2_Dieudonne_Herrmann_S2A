package org.example.fichiers;

import java.util.List;

public class MainDijkstra{

    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("E", "D", 43);
        g.ajouterArc("A", "D", 87);

        // Calculer le chemin le plus court avec algorithme de Dijkstra
        Dijkstra d = new Dijkstra();
        Valeur valeurs = d.resoudre(g, "A");
        System.out.println(valeurs);

        // Afficher les chemins pour des nœuds donnés
        String[] noeudsDestionations = {"B", "C", "D", "E"};
        for (String destination : noeudsDestionations) {
            List<String> chemin = valeurs.calculerChemin(destination);
            System.out.println("Chemin de A" + " à " + destination + " : " + chemin);
        }
    }
}

