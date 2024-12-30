public class Infantry extends Unit {
    InfantryType type_infanterie;

    public Infantry(String nom, int coût, InfantryType type_infanterie) {
        super(nom, coût);
        this.type_infanterie = type_infanterie;
    }

    public InfantryType getType_infanterie() {
        return type_infanterie;
    }

    public void setType_infanterie(InfantryType type_infanterie) {
        this.type_infanterie = type_infanterie;
    }

    @Override
    public void print() {
        System.out.println("--------------------");
        System.out.println("Unité : Infanterie");
        System.out.println("--------------------");
        System.out.println("Nom : " + super.getName());
        System.out.println("Type : " + type_infanterie);
        System.out.println("Coût : " + super.getCost() + " pts");
    }

}
