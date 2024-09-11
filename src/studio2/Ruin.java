
package studio2;

import java.util.Scanner;

public class Ruin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter start amount: ");
        int startAmount = scanner.nextInt();

        System.out.println("Enter win chance (0-1): ");
        double winChance = scanner.nextDouble();

        System.out.println("Enter win limit: ");
        int winLimit = scanner.nextInt();

        System.out.println("Enter number of simulations: ");
        int totalSimulations = scanner.nextInt();

        int totalLosses = 0;

        // Simulate each day
        for (int simulation = 1; simulation <= totalSimulations; simulation++) {
            int currentAmount = startAmount;
            int plays = 0;

            while (currentAmount > 0 && currentAmount < winLimit) {
                plays++;
                if (Math.random() < winChance) {
                    currentAmount++;  // Win $1
                } else {
                    currentAmount--;  // Lose $1
                }
            }

            if (currentAmount == 0) {
                System.out.println("Simulation " + simulation + ": " + plays + " LOSE");
                totalLosses++;
            } else {
                System.out.println("Simulation " + simulation + ": " + plays + " WIN");
            }
        }

        // Calculate ruin rate
        double ruinRate = (double) totalLosses / totalSimulations;
        System.out.println("Losses: " + totalLosses + " Simulations: " + totalSimulations);
        System.out.println("Ruin Rate from Simulation: " + ruinRate);

        // Calculate expected ruin rate
        double expectedRuinRate;
        if (winChance == 0.5) {
            expectedRuinRate = 1 - ((double) startAmount / winLimit);
        } else {
            double ratio = (1 - winChance) / winChance;
            expectedRuinRate = (Math.pow(ratio, startAmount) - Math.pow(ratio, winLimit)) / (1 - Math.pow(ratio, winLimit));
        }

        System.out.println("Expected Ruin Rate: " + expectedRuinRate);

        scanner.close();
    }
}