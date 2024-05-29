package org.example.fichiers;

public class Main{
    public static void main(String[] args){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("E", "D", 43);
        g.ajouterArc("A", "D", 87);
        System.out.println(g.toString());

        BellmanFord b = new BellmanFord();
        Valeur valeurs = b.resoudre(g, "A");
        System.out.println(valeurs);
    }
}