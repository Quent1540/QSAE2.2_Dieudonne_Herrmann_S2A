package org.example.fichiers;

import org.example.fichiers.Arc;
import org.example.fichiers.Arcs;
import org.example.fichiers.GrapheListe;
public class BellmanFord implements Algorithme {
    public Valeur resoudre(GrapheListe g, String depart){
        Valeur valeurs = new Valeur();
        boolean modification=true;
        for (String noeud : g.getNoeuds()){
            valeurs.setValeur(noeud, Double.MAX_VALUE);
            valeurs.setParent(noeud, null);
        }
        valeurs.setValeur(depart,0);
        while (modification){
            modification = false;
            for (String noeud : g.getNoeuds()){
                double distanceNoeud = valeurs.getValeur(noeud);
                for (Arc arc : g.suivants(noeud)){
                    double NouvelleDistance = distanceNoeud + arc.getCout();
                    if (NouvelleDistance < valeurs.getValeur(arc.getDest())){
                        valeurs.setValeur(arc.getDest(), NouvelleDistance);
                        valeurs.setParent(arc.getDest(), noeud);
                        modification = true;
                    }
                }
            }
        }
        return valeurs;
    }
}