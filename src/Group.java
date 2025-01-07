import java.util.ArrayList;
import java.util.List;

public class Group {
    public int somme_point;
    public String name;
    public List<Unit> units;

    // Constructors

    public Group(String nom) {
        this.name = nom;
        this.somme_point = 0;
        this.units = new ArrayList<>();
    }

    // Setters & Getters

    public int getSomme_point() {
        return somme_point;
    }

    public void setSomme_point(int somme_point) {
        this.somme_point = somme_point;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setList_unité(ArrayList<Unit> list_groupe) {
        this.units = list_groupe;
    }

    // Other methods

    public void addUnit(Unit newUnit, Army army) {

        int newSum = newUnit.getCost() + army.getUsedPoints();

        if (newSum <= army.getMaxPoints()) {
            units.add(newUnit);
            this.somme_point += newUnit.getCost();
            army.updateUsedPoints(newUnit.getCost());
            System.out.println("Infanterie/Véhicle ajouté(e) avec succès !");
        } else {
            System.out.println("L'unité coûte trop cher , dépassement du coup maximum de l'armée '"+army.getName()+"' !");
        }

    }

    public boolean removeUnit(int index) {
        if (index >= 0 && index <= this.units.size()) {
            this.units.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println("Nom du groupe : " + this.name + ";");
        System.out.println("Total de points : " + this.somme_point + ";");

        if (units.size() != 0) {
            System.out.println("Les unités de ce groupe sont : ");
            for (Unit unit : units) {
                unit.print();
                System.out.println();
            }
        } else {
            System.out.println("Ce groupe ne contient aucune unité.");
        }
    }

}
