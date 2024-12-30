public class Vehicle extends Unit {
    private int capacity;

    public Vehicle(String name, int cost, int capacité) {
        super(name, cost);
        this.capacity = capacité;
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
        System.out.println("Unité : Véhicule");
        System.out.println("--------------------");
        System.out.println("Nom : " + super.getName());
        System.out.println("Capacité : " + this.capacity);
        System.out.println("Coût : " + super.getCost() + " pts");
    }

}
