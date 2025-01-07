public class Vehicle extends Unit {
    private int capacity;
    private VehicleType type;

    public Vehicle(String name, int cost, VehicleType type) {
        super(name, cost);
        this.type = type;
        this.capacity=0;//pas de capacité pour les véhicules de combat
    }

    public Vehicle(String name, int cost, VehicleType type, int capacity) {
        super(name, cost);
        this.type = type;
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacité) {
        this.capacity = capacité;
    }

    @Override
    public void print() {
        System.out.println("--------------------");
        System.out.println("Unité : Véhicule de Type "+type);
        System.out.println("--------------------");
        System.out.println("Nom : " + super.getName());
        if(type==VehicleType.Transport){System.out.println("Capacité : " + this.capacity);}
        System.out.println("Coût : " + super.getCost() + " pts");
    }

}
