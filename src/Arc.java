public class Arc {
    //attributs
    private String dest;
    private double cout;

    // constructeur
    public Arc(String dest, double cout) {
        this.dest = dest;
        this.cout = cout;
    }

    public String getDest() {
        return dest;
    }

    public double getCout() {
        return cout;
    }
}