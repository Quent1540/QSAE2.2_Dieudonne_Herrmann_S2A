package org.example.fichiers;
import java.util.List;

public interface Graphe {
    int getIndice(String n);
    void ajouterArc(String depart, String destination, double cout);
}