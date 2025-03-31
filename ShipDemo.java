import java.util.ArrayList;

    public class ShipDemo {
        public static void main(String[] args) {
            // Create an array of Ship objects
            Ship[] ships = new Ship[3];
            ships[0] = new CruiseShip("Voyager", "2000", 3000);
            ships[1] = new CargoShip("Titan", "1998", 50000);
            ships[2] = new CruiseShip("Explorer", "2005", 4000);

            // Step through array calling display() method
            System.out.println("Using array:");
            for (Ship ship : ships) {
                ship.display();
            }

            // Create an ArrayList of Ship objects
            ArrayList<Ship> shipList = new ArrayList<>();
            shipList.add(new CruiseShip("Serenade", "2010", 3500));
            shipList.add(new CargoShip("Colossus", "2015", 60000));

            // Test copy constructors
            CruiseShip copyCruiseShip = new CruiseShip((CruiseShip) shipList.get(0));
            CargoShip copyCargoShip = new CargoShip((CargoShip) shipList.get(1));

            shipList.add(copyCruiseShip);
            shipList.add(copyCargoShip);

            // Step through ArrayList calling toString() method
            System.out.println("\nUsing ArrayList:");
            for (Ship ship : shipList) {
                System.out.println(ship.toString());
            }
        }
    }


