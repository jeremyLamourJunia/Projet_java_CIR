import java.util.ArrayList;
import java.util.List;

public class ArmyManager {
    private List<Army> armies;

    public ArmyManager() {
        this.armies = new ArrayList<>();
    }

    public void addArmy(Army army) {
        armies.add(army);
    }

    public Army selectArmy(int index) {
        return this.armies.get(index);
    }

    public Boolean removeArmy(int index) {
        if (index >= 0 && index < this.armies.size()) {
            this.armies.remove(index);
            return true;
        }
        return false;

    }

    public void print() {
        if (armies.isEmpty()) {
            System.out.println("Aucune armée disponible !");
        } else {
            System.out.println("Liste des armées : ");
            for (int i = 0; i < armies.size(); i++) {
                System.out.println("--------------------");
                System.out.println("index de l'armée : " + i);
                System.out.println("--------------------");
                armies.get(i).print();
            }
        }

    }

}
