import java.util.ArrayList;
import java.util.List;

public class Groupes {
   public int somme_point;
   public String nom;
   public List<Unité> list_unité = new ArrayList<>();
   public Groupes(String nom){
       this.nom = nom;
       this.somme_point = 0;
   }

    public int getSomme_point() {
        return somme_point;
    }

    public void setSomme_point(int somme_point) {
        this.somme_point = somme_point;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Unité> getList_unité() {
        return list_unité;
    }

    public void setList_unité(ArrayList<Unité> list_groupe) {
        this.list_unité = list_groupe;
    }

    public void ajouter(Unité groupe){
        list_unité.add(groupe);
        int somme = 0;
        for( Unité s:list_unité){
            somme+=s.coût;
        }
        setSomme_point(somme);
    }

    public void print(){
       System.out.println("Le nom du groupe : "+this.nom +" ; la somme de point : "+this.somme_point+" ; Les unités sont : ");
        for(Unité s:list_unité){
            System.out.println("    "+ s+"\n");
        }
    }
}
