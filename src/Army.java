import java.util.ArrayList;
import java.util.List;

public class Army {
    private String name;
    private int maxPoints;
    private String faction;
    private List<Group> groups;
    private int usedPoints;

    // Constructors

    public Army(String name, int maxPoints, String faction) {
        this.name = name;
        this.maxPoints = maxPoints;
        this.usedPoints = 0;
        this.faction = faction;
        this.groups = new ArrayList<>();
        System.out.println("Votre armée est crée");

    }

    // Getters & Setters

    public int getUsedPoints() {
        return usedPoints;
    }

    public void setUsedPoints(int usedPoints) {
        this.usedPoints = usedPoints;
    }

    public void updateUsedPoints(int toAdd) {
        this.usedPoints += toAdd;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public Group getGroup(int index) {
        if (index >= 0 && index < groups.size()) {
            return groups.get(index);
        }
        System.out.println("Index invalide. Aucun groupe trouvé.");
        return null;
    }

    public void setGroups(List<Group> List_Groupes) {
        this.groups = List_Groupes;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    // Other Methods

    public void addGroup(Group newGroup) {

        this.groups.add(newGroup);

    }

    public boolean removeGroup(int index) {
        if (index >= 0 && index < groups.size()) {
            groups.remove(index);
            return true;
        }
        return false;
    }

    public void print() {

        System.out.println("====================");
        System.out.println("Nom de l'armée : " + this.name + ";");
        System.out.println("Faction : " + this.faction + ";");
        System.out.println("Points maximum : " + this.maxPoints);
        System.out.println("Points utilisés : " + this.usedPoints);
        System.out.println("====================");

        if (groups.isEmpty()) {
            System.out.println("Aucun groupe disponible dans cette armée !");
        } else {
            System.out.println("Liste des groupes de l'armée : ");
            for (int i = 0; i < groups.size(); i++) {
                System.out.println("--------------------");
                System.out.println("Index du groupe : " + i);
                System.out.println("--------------------");
                groups.get(i).print(); // Appelle la méthode print du groupe
                System.out.println();
            }
        }
    }

}
