import java.util.Scanner;

public class TestAvgGrd {

    // Method to calculate the average of five test scores
    public static double calcAverage(double score1, double score2, double score3, double score4, double score5) {
        return (score1 + score2 + score3 + score4 + score5) / 5.0;
    }

    // Method to determine the letter grade based on the score
    public static char determineGrade(double score) {
        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] scores = new double[5];

        // Prompt user to enter five test scores
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter test score " + (i + 1) + ": ");
            scores[i] = scanner.nextDouble();
        }

        // Calculate average score
        double average = calcAverage(scores[0], scores[1], scores[2], scores[3], scores[4]);

        // Display each score with its corresponding letter grade
        System.out.println("\nScore\tLetter Grade");
        for (double score : scores) {
            System.out.printf("%.2f\t%c%n", score, determineGrade(score));
        }

        // Display average score
        System.out.printf("\nAverage Score: %.2f%n", average);
        System.out.printf("Average Letter Grade: %c%n", determineGrade(average));

        scanner.close();
    }
}
