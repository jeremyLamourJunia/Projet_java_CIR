import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // test des unités
//        Unité Unitéinfanterie = new Infanterie("infanterie1",12,Type_infanterie.SOLDAT);
////        System.out.println(Unitéinfanterie);
//        Unité UnitéVéhicule = new Véhicules("Véhicule1",11,13);
////        System.out.println(UnitéVéhicule);
//        //test des groupes
//        Groupes groupe1= new Groupes("icigorupe1",Unitéinfanterie);
////        groupe1.print();
//        groupe1.ajouter(UnitéVéhicule);
////       groupe1.print();
//        //test des armées
//        Armée armée1=new Armée("Frabçaise",25,"Terre");
//        armée1.ajouter(groupe1);
//        armée1.print("Groupe",0);

        //création de l'armée
        System.out.println("Bonjour, bienvenu dans Wargame");
        System.out.println("Rentrer le nom de votre armée");
        Scanner myObj = new Scanner(System.in);
        String nom = myObj.nextLine();
        System.out.println("Rentrer le faction de votre armée");
        String faction = myObj.nextLine();
        System.out.println("Rentrer le nombre de point max de votre armée");
        int somme_max_point = myObj.nextInt();
        Armée armée1 = new Armée(nom, somme_max_point, faction);

        //fonctionnalité après la création
        int fonction = 0;
        while (fonction != 4) {
            System.out.println("Voulez vous créer Créer (1), Supprimer (2), Afficher (3) ou Sortir(4)");
            fonction = myObj.nextInt();
            switch (fonction) {
                case 1:
                    // création des types
                    System.out.println("Voulez vous créer un groupe (1) ou une unité (2)");
                    int type = myObj.nextInt();
                    myObj.nextLine();//pour consommer la ligne
                    switch (type) {
                        case 1:
                            System.out.println("Rentrer le nom de votre groupe");
                            String nom_groupe = myObj.nextLine();
                            Groupes groupe = new Groupes(nom_groupe);
                            armée1.ajouter(groupe);
                            break;
                        case 2:
                            if (armée1.List_Groupes.size() != 0) {
                                System.out.println("Rentrer le nom de votre unité ");
                                String nom_unité = myObj.nextLine();
                                System.out.println("Rentrer le coût de l'unité ");
                                int coût_unité = myObj.nextInt();
                                myObj.nextLine();
                                System.out.println("Voulez-vous une infanterie (1) ou un véhicule (2) ");
                                int type_unité = myObj.nextInt();
                                myObj.nextLine();
                                switch (type_unité) {
                                    case 1:
                                        System.out.println("Rentrer le Type de l'infanterie");
                                        System.out.print("Entrez le type d'infanterie (SOLDAT, LOURD, SPECIAL, CHEF) : ");
                                        String type_infanterie_string = myObj.nextLine().toUpperCase(); // Convertir en majuscules pour correspondre aux noms de l'énumération
                                        Type_infanterie type_infanterie = Type_infanterie.valueOf(type_infanterie_string);
                                        Unité Unitéinfanterie = new Infanterie(nom_unité, coût_unité, type_infanterie);
                                        //ajout au groupe
                                        System.out.println("A quelle groupe voulez vous ajouter l'unité, rentrer l'indice");
                                        int indice_groupe = myObj.nextInt();
                                        if (armée1.List_Groupes.size() - 1 >= indice_groupe) {
                                            int somme_armée=0;
                                            for( Groupes s:armée1.List_Groupes){
                                                somme_armée+=s.somme_point;
                                            }
                                            if(Unitéinfanterie.coût+somme_armée<=armée1.somme_max_point){
                                                armée1.List_Groupes.get(indice_groupe).ajouter(Unitéinfanterie);
                                            }

                                        } else {
                                            throw new IllegalArgumentException("Index out");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Rentrer la capacité du véhicule");
                                        int capacité_véhicule = myObj.nextInt();
                                        Unité Unitévéhicule = new Véhicules(nom_unité, coût_unité, capacité_véhicule);
                                        //ajout au groupe
                                        System.out.println("A quelle groupe voulez vous ajouter l'unité, rentrer l'indice");
                                        int indice_groupe2 = myObj.nextInt();
                                        if (armée1.List_Groupes.size() - 1 >= indice_groupe2 ) {
                                            int somme_armée=0;
                                            for( Groupes s:armée1.List_Groupes){
                                                somme_armée+=s.somme_point;
                                            }
                                            if(Unitévéhicule.coût+somme_armée<=armée1.somme_max_point){
                                                armée1.List_Groupes.get(indice_groupe2).ajouter(Unitévéhicule);
                                            }
                                            else{
                                                throw new IllegalArgumentException("Le coût de l'unité ajouter est supérieur à la somme max de l'armée donc c'est impossible de rajouter cette unité à l'armée");
                                            }
                                        } else {
                                            throw new IllegalArgumentException("Index out");
                                        }
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Syntaxe incorrect");
                                }
                            } else {
                                System.out.println("Vous devez créer un groupe (1) avant de créer une unité ");
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Syntaxe incorrect");
                    }
                    break;
                case 2:
                    //suppression
                    System.out.println("Voulez vous supprimer un groupe (1) ou une unité (2)");
                    int type_suppression = myObj.nextInt();
                    myObj.nextLine();//pour consommer la ligne
                    switch (type_suppression) {
                        case 1:
                            System.out.println("Rentrer l'indice du groupe à supprimer");
                            int indice_groupe_suppresion = myObj.nextInt();
                            myObj.nextLine();//pour consommer la ligne
                            if(armée1.List_Groupes.size()-1>=0){
                                armée1.List_Groupes.remove(indice_groupe_suppresion);
                            }
                            else{
                                throw new IllegalArgumentException("Index out l'indice du groupe à supprimer");
                            }
                            break;
                        case 2:
                            System.out.println("Rentrer l'indice du groupe à supprimer");
                            int indice_groupe_suppresion_pourunité = myObj.nextInt();
                            myObj.nextLine();//pour consommer la ligne
                            if(armée1.List_Groupes.size()-1>=0){
                                System.out.println("Rentrer l'indice de l'unité à supprimer");
                                int indice_unité_suppresion = myObj.nextInt();
                                if(armée1.List_Groupes.get(indice_groupe_suppresion_pourunité).list_unité.size()-1>=indice_unité_suppresion){
                                    //on enlève les points de l'unité au groupe
                                    armée1.List_Groupes.get(indice_groupe_suppresion_pourunité).somme_point=armée1.List_Groupes.get(indice_groupe_suppresion_pourunité).somme_point- armée1.List_Groupes.get(indice_groupe_suppresion_pourunité).list_unité.get(indice_unité_suppresion).coût;
                                   //on enlève l'unité du groupe
                                    armée1.List_Groupes.get(indice_groupe_suppresion_pourunité).list_unité.remove(indice_unité_suppresion);

                                }
                                else{
                                    throw new IllegalArgumentException("Index out pour l'indice de l'unité à supprimer");
                                }
                            }
                            else{
                                throw new IllegalArgumentException("Index out pour l'indice du groupe à supprimer");
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Syntaxe incorrect");
                    }
                    break;
                case 3:
                    //affichage des types
                    System.out.println("Voulez vous afficher l'Armée (1), un groupe (2) ou une unité (3)");
                    int type_affichage = myObj.nextInt();
                    switch (type_affichage) {
                        case 1:
                            armée1.print();
                            break;
                        case 2:
                            System.out.println("Entrée l'indice du groupe en question");
                            int a = myObj.nextInt();
                            armée1.List_Groupes.get(a).print();
                            break;
                        case 3:
                            System.out.println("Entrée l'indice du groupe en question");
                            int index_groupe = myObj.nextInt();
                            if (armée1.List_Groupes.size() - 1 >= index_groupe) {
                                System.out.println("Entrée l'indice de l'unité");
                                int index_unité = myObj.nextInt();
                                if (armée1.List_Groupes.get(index_groupe).list_unité.size() - 1 >= index_unité) {
                                    armée1.List_Groupes.get(index_groupe).list_unité.get(index_unité);
                                } else {
                                    throw new IllegalArgumentException("Index out pour unité");
                                }
                            } else {
                                throw new IllegalArgumentException("Index out pour groupe");
                            }


                        default:
                            throw new IllegalArgumentException("Syntaxe incorrect");
                    }
                    break;
                case 4:
                    System.out.println("Fin de la création");
                    break;
                default:
                    throw new IllegalArgumentException("Syntaxe incorrect");


            }


        }
    }
}