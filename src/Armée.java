import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Armée extends Gestion{
    public int somme_max_point;
    public String nom;
    public String faction;
    public List<Groupes> List_Groupes= new ArrayList<>();

    public Armée(String nom, int somme_max_point, String faction) {
        this.nom = nom;
        this.somme_max_point = somme_max_point;
        this.faction = faction;
        System.out.println("Votre armée est crée");
    }

    public int getSomme_max_point() {
        return somme_max_point;
    }

    public void setSomme_max_point(int somme_max_point) {
        this.somme_max_point = somme_max_point;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Groupes> getList_Groupes() {
        return List_Groupes;
    }

    public void setList_Groupes(List<Groupes> List_Groupes) {
        List_Groupes = List_Groupes;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }
    public void print(){
        System.out.println("Le nom de l'armée est : "+this.nom +" ; la somme somme max : "+this.somme_max_point);
        if(List_Groupes.size()!=0){
            System.out.println("Les différents groupes de l'armée sont : ");
            for(Groupes s:List_Groupes){
                s.print();
                System.out.println("\n");
            }
        }

    }
    public void ajouter(Groupes groupe_ajouter){
        int somme_armée=0;
        for( Groupes s:List_Groupes){
            somme_armée+=s.somme_point;
        }
        if( this.somme_max_point > (somme_armée+ groupe_ajouter.somme_point)){
            this.List_Groupes.add(groupe_ajouter);
        }
        else{
            throw new IllegalArgumentException("Vous ne pouvez pas ajouter le groupe à l'armée car la somme de point dépasse les point max de l'armée");
        }

    }
}
