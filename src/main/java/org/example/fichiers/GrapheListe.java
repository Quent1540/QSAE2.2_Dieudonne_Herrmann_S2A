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

    public ArrayList<Arcs> getAdjacence(){
        return adjacence;
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
        String res = "";

        for (int i = 0; i < noeuds.size(); i++){
            String noeud = noeuds.get(i);
            Arcs arcss = adjacence.get(i);
            res += noeud + " -> ";

            List<Arc> arcs = arcss.getArcs();
            for(int j = 0; j < arcs.size(); j++){
                Arc arc = arcs.get(j);
                res += arc.getDest() + "(" + arc.getCout() + ")";
                if(j < arcs.size() - 1){
                    res += " ";
                }
            }

            res += "\n";
        }

        return res;
    }
}
