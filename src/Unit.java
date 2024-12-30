public abstract class Unit {
    private String name;
    private int cost;

    public Unit(String name, int cost) {
        this.name = name;
        this.cost = cost;
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract void print();

}
