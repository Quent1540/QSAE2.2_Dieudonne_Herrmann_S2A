package org.example.fichiers;

import java.util.*;

import org.example.fichiers.Arc;
import org.example.fichiers.Arcs;
import org.example.fichiers.GrapheListe;

public class Dijkstra implements Algorithme{

    public Valeur resoudre(GrapheListe g, String depart) {
        // Début
        Valeur valeurs = new Valeur();
        // Q <- {} // utilisation d’une liste de noeuds à traiter
        ArrayList<String> Q = new ArrayList<>(g.getNoeuds());

        // Pour chaque sommet v de G faire
        for (String noeud : g.getNoeuds()) {
            // v.valeur <- Infini
            valeurs.setValeur(noeud, Double.MAX_VALUE);
            // v.parent <- Indéfini
            valeurs.setParent(noeud, null);
            // Q <- Q U {v} // ajouter le sommet v à la liste Q
        }

        // A.valeur <- 0
        valeurs.setValeur(depart, 0.0);

        // Tant que Q est un ensemble non vide faire
        while (!Q.isEmpty()) {
            // u <- un sommet de Q telle que u.valeur est minimal
            String u = null;
            double minDistance = Double.MAX_VALUE;
            for (String noeud : Q) {
                if (valeurs.getValeur(noeud) < minDistance) {
                    minDistance = valeurs.getValeur(noeud);
                    u = noeud;
                }
            }

            if (u == null) {
                break;
            }

            // enlever le sommet u de la liste Q
            Q.remove(u);

            // Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
            for (Arc arc : g.suivants(u)) {
                String v = arc.getDest();
                if (Q.contains(v)) {
                    // d <- u.valeur + poids(u,v)
                    double alt = valeurs.getValeur(u) + arc.getCout();
                    // Si d < v.valeur
                    if (alt < valeurs.getValeur(v)) {
                        // le chemin est plus interessant
                        // Alors v.valeur <- d
                        valeurs.setValeur(v, alt);
                        // v.parent <- u
                        valeurs.setParent(v, u);
                    }
                }
            }
        }
        return valeurs;
    }
}                       // Fin
