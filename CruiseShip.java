public class CruiseShip extends Ship {
    private int maxPassengers;

    public CruiseShip(String name, String yearBuilt, int maxPassengers) {
        super(name, yearBuilt);
        this.maxPassengers = maxPassengers;
    }

    // Copy constructor
    public CruiseShip(CruiseShip other) {
        super(other.getName(), other.getYearBuilt());
        this.maxPassengers = other.maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        return "Cruise Ship Name: " + getName() + ", Max Passengers: " + maxPassengers;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }
}
