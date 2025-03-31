import java.util.Scanner;

public class Conversion {

    // Method to convert meters to kilometers
    public static void showKilometers(double meters) {
        double kilometers = meters * 0.001;
        System.out.printf("%.2f meters is %.2f kilometers.%n", meters, kilometers);
    }

    // Method to convert meters to inches
    public static void showInches(double meters) {
        double inches = meters * 39.37;
        System.out.printf("%.2f meters is %.2f inches.%n", meters, inches);
    }

    // Method to convert meters to feet
    public static void showFeet(double meters) {
        double feet = meters * 3.281;
        System.out.printf("%.2f meters is %.2f feet.%n", meters, feet);
    }

    // Method to display the menu
    public static void menu() {
        System.out.println("Menu of Selections:");
        System.out.println("1. Convert to kilometers");
        System.out.println("2. Convert to inches");
        System.out.println("3. Convert to feet");
        System.out.println("4. Quit the program");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double meters;

        // Prompt user for distance in meters
        do {
            System.out.print("Enter a distance in meters (non-negative): ");
            meters = scanner.nextDouble();
            if (meters < 0) {
                System.out.println("Distance cannot be negative. Please try again.");
            }
        } while (meters < 0);

        int choice;
        do {
            menu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showKilometers(meters);
                    break;
                case 2:
                    showInches(meters);
                    break;
                case 3:
                    showFeet(meters);
                    break;
                case 4:
                    System.out.println("Quitting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
