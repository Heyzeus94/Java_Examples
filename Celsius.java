public class Celsius {
    // Method to convert Fahrenheit to Celsius
    public static double celsius(double fahrenheit) {
        return 5.0 / 9.0 * (fahrenheit - 32);
    }

    public static void main(String[] args) {
        // Print the table header
        System.out.printf("%-15s %-15s%n", "Fahrenheit", "Celsius");
        System.out.println("---------------------------");

        // Loop through Fahrenheit temperatures from 0 to 20
        for (int fahrenheit = 0; fahrenheit <= 20; fahrenheit++) {
            double celsius = celsius(fahrenheit);
            System.out.printf("%-15d %-15.2f%n", fahrenheit, celsius);
        }
    }
}

