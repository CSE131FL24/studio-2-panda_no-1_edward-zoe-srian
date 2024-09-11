package studio2;

import java.util.Scanner;

public class PI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of dart throws: ");
        int numThrows = scanner.nextInt();

        int dartsInsideCircle = 0;

        for (int i = 0; i < numThrows; i++) {
            double x = Math.random(); 
            double y = Math.random(); 

            if (Math.sqrt(x * x + y * y) <= 1) {
                dartsInsideCircle++;
            }
        }


        double piEstimate = 4.0 * dartsInsideCircle / numThrows;
        System.out.println("Estimated Pi: " + piEstimate);

        scanner.close();
    }
}