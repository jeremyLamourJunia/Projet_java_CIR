public class Véhicules extends Unité{
    public int capacité;
    public Véhicules(String nom,int coût,int capacité){
        super(nom,coût);
        this.capacité=capacité;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }
    @Override
    public String toString() {
        return "Unité 'Véhicule' => Nom : "+nom+" ; Capacité : "+capacité+" ; Coût de l'unité "+coût;
    }
}
