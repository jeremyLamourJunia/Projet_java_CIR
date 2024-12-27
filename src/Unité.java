public abstract class Unité {
    public String nom;
    public int coût;
    public Unité(String nom,int coût){
        this.nom=nom;
        this.coût=coût;
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCoût() {
        return coût;
    }

    public void setCoût(int coût) {
        this.coût = coût;
    }

}
