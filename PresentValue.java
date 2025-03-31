import java.util.Scanner;

public class PresentValue {

    // Method to calculate present value
    public static double presentValue(double futureValue, double annualRate, int years) {
        return futureValue / Math.pow(1 + annualRate, years);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for future value, interest rate, and years
        System.out.print("What is the desired future value? ");
        double futureValue = scanner.nextDouble();

        System.out.print("What is the annual interest rate? ");
        double annualRate = scanner.nextDouble();

        System.out.print("For how many years? ");
        int years = scanner.nextInt();

        // Calculate present value
        double presentValue = presentValue(futureValue, annualRate, years);

        // Display output
        System.out.printf("You need to invest $%.2f%n", presentValue);

        scanner.close();
    }
}