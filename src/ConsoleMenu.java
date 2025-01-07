import java.util.Scanner;

public class ConsoleMenu {
    private ArmyManager armyManager = new ArmyManager(); // Gère plusieurs armées
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            printMainMenu();
            int choice = promptInt("Votre choix");

            switch (choice) {
                case 1 -> createArmy();
                case 2 -> {
                    System.out.println();
                    armyManager.print();
                    break;
                }
                case 3 -> manageArmy(); // Gestion d'une armée spécifique
                case 4 -> deleteArmy(); // Suppression d'une armée
                case 5 -> {
                    System.out.println("Fin de la création. Au revoir !");
                    return;
                }
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n" + //
                "░██╗░░░░░░░██╗░█████╗░██████╗░░██████╗░░█████╗░███╗░░░███╗███████╗\n" + //
                "░██║░░██╗░░██║██╔══██╗██╔══██╗██╔════╝░██╔══██╗████╗░████║██╔════╝\n" + //
                "░╚██╗████╗██╔╝███████║██████╔╝██║░░██╗░███████║██╔████╔██║█████╗░░\n" + //
                "░░████╔═████║░██╔══██║██╔══██╗██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░\n" + //
                "░░╚██╔╝░╚██╔╝░██║░░██║██║░░██║╚██████╔╝██║░░██║██║░╚═╝░██║███████╗\n" + //
                "░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝╚═╝░░╚═╝░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝");
        System.out.println("Menu principal:");
        System.out.println("1. Créer une armée");
        System.out.println("2. Afficher les armées");
        System.out.println("3. Gérer une armée");
        System.out.println("4. Supprimer une armée");
        System.out.println("5. Quitter");
    }

    // Army console functions

    private void createArmy() {
        System.out.println("=== Création d'une armée ===");
        String name = promptString("Nom de l'armée");
        String faction = promptString("Faction");
        int maxPoints = promptInt("Points maximum");
        while(maxPoints<0){
            System.out.println("Le nombre de points maximum doit être positif.");
            maxPoints = promptInt("Points maximum");
        }   

        Army newArmy = new Army(name, maxPoints, faction);
        armyManager.addArmy(newArmy);

        System.out.println("Armée '" + name + "' créée avec succès !");
    }

    private void deleteArmy() {
        System.out.println("=== Suppression d'une armée ===");
        armyManager.print(); // Affiche toutes les armées
        int index = promptInt("Index de l'armée à supprimer");

        if (armyManager.removeArmy(index)) {
            System.out.println("Armée supprimée avec succès.");
        } else {
            System.out.println("Index invalide. Impossible de supprimer l'armée.");
        }
    }

    private void manageArmy() {
        System.out.println("=== Gestion d'une armée ===");
        armyManager.print(); // Affiche les armées disponibles
        int index = promptInt("Sélectionner l'index de l'armée");

        Army selectedArmy = armyManager.selectArmy(index);
        if (selectedArmy == null) {
            System.out.println("Index invalide. Retour au menu principal.");
            return;
        }

        boolean managing = true;
        while (managing) {
            printArmyMenu(selectedArmy);
            int choice = promptInt("Votre choix");

            switch (choice) {
                case 1 -> createGroup(selectedArmy); // Ajouter un groupe
                case 2 -> selectedArmy.print(); // Afficher les détails de l'armée
                case 3 -> manageGroup(selectedArmy); // Gérer les unités d'un groupe
                case 4 -> deleteGroup(selectedArmy); // Supprimer un groupe
                case 5 -> managing = false; // Retour au menu principal
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private void printArmyMenu(Army army) {
        System.out.println("\n=== Gestion de l'armée : " + army.getName() + " ===");
        System.out.println("1. Ajouter un groupe");
        System.out.println("2. Afficher les détails");
        System.out.println("3. Gérer les unités d'un groupe");
        System.out.println("4. Supprimer un groupe");
        System.out.println("5. Retour au menu principal");
    }

    // Group console functions

    private void createGroup(Army army) {
        System.out.println("=== Création d'un groupe ===");
        String groupName = promptString("Nom du groupe");
        Group newGroup = new Group(groupName);
        army.addGroup(newGroup);

        System.out.println("Groupe '" + groupName + "' ajouté à l'armée '" + army.getName() + "'.");
    }

    private void deleteGroup(Army army) {
        army.print(); // Affiche les groupes de l'armée
        int groupIndex = promptInt("Index du groupe à supprimer");

        if (army.removeGroup(groupIndex)) {
            System.out.println("Groupe supprimé avec succès.");
        } else {
            System.out.println("Index invalide. Impossible de supprimer le groupe.");
        }
    }

    private void manageGroup(Army army) {
        army.print(); // Affiche les groupes de l'armée
        int groupIndex = promptInt("Sélectionner l'index du groupe");

        Group selectedGroup = army.getGroup(groupIndex);
        if (selectedGroup == null) {
            System.out.println("Index invalide. Retour au menu de gestion d'armée.");
            return;
        }

        boolean managing = true;
        while (managing) {
            printGroupMenu(selectedGroup);
            int choice = promptInt("Votre choix");

            switch (choice) {
                case 1 -> createUnit(selectedGroup, army); // Ajouter une unité
                case 2 -> selectedGroup.print(); // Afficher les unités du groupe
                case 3 -> deleteUnit(selectedGroup); // Supprimer une unité
                case 4 -> managing = false; // Retour au menu de gestion d'armée
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private void printGroupMenu(Group group) {
        System.out.println("\n=== Gestion du groupe : " + group.getName() + " ===");
        System.out.println("1. Ajouter une unité");
        System.out.println("2. Afficher les unités");
        System.out.println("3. Supprimer une unité");
        System.out.println("4. Retour au menu précédent");
    }

    // Unit console functions

    private void createUnit(Group group, Army army) {
        System.out.println("=== Création d'une unité ===");
        String unitName = promptString("Nom de l'unité");

        int unitCost = promptInt("Coût de l'unité");
        while(unitCost<0){
            System.out.println("Le coût de l'unité doit être positif.");
            unitCost = promptInt("Coût de l'unité");
        }
        System.out.println("Type d'unité :");
        System.out.println("1. Infanterie");
        System.out.println("2. Véhicule");
        int type = promptInt("Votre choix");

        switch (type) {
            case 1 -> {
                InfantryType infantryType = selectInfantryType();
                Infantry newInfantry = new Infantry(unitName, unitCost, infantryType);
                group.addUnit(newInfantry, army);
            }
            case 2 -> {
            
                System.out.println("Type de transport");
                System.out.println("1. Attaque");
                System.out.println("2. Transport");
                int chooseType = promptInt("Votre choix");
                switch(chooseType){
                    case 1 -> {
                        Vehicle newVehicle = new Vehicle(unitName, unitCost,VehicleType.Attaque);
                        group.addUnit(newVehicle, army);
                    }
                    case 2 -> {
                        int transportCapacity = promptInt("Capacité de transport du véhicule");
                        while(transportCapacity<0){
                            System.out.println("Le capacité du véhicule doit être positif.");
                            transportCapacity = promptInt("Capacité de transport du véhicule");
                        }
                        Vehicle newVehicle = new Vehicle(unitName, unitCost,VehicleType.Transport, transportCapacity);
                        group.addUnit(newVehicle, army);
                    }
                    default -> System.out.println("Choix invalide. Type de véhicule non créé.");
                }
                
               
            }
            default -> System.out.println("Choix invalide. Unité non créée.");
        }
    }

    private void deleteUnit(Group group) {
        group.print(); // Affiche les unités du groupe
        int unitIndex = promptInt("Index de l'unité à supprimer");

        if (group.removeUnit(unitIndex)) {
            System.out.println("Unité supprimée avec succès.");
        } else {
            System.out.println("Index invalide. Impossible de supprimer l'unité.");
        }
    }

    // Scanner functions

    private InfantryType selectInfantryType() {
        System.out.println("Sélectionnez un type d'infanterie :");
        InfantryType[] types = InfantryType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i]);
        }

        int choice = promptInt("Votre choix");
        if (choice < 1 || choice > types.length) {
            System.out.println("Choix invalide. Sélection par défaut : SOLDAT.");
            return InfantryType.SOLDAT;
        }

        return types[choice - 1];
    }

    private String promptString(String prompt) {
        System.out.print(prompt + ": ");
        return sc.nextLine();
    }

    private int promptInt(String prompt) {
        System.out.print(prompt + ": ");
        while (!sc.hasNextInt()) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            System.out.print(prompt + ": ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}
