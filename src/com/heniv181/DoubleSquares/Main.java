package com.heniv181.DoubleSquares;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-22.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {

            int num = Integer.parseInt(scanner.nextLine());
            System.out.println(numberOfComplements(num));
        }


    }

    /**
     * Used to find the sum of two squares (a and b) such that a^2 + b^2.
     * @param a first addend to be squared
     * @param b second addend to be squared
     * @return the sum of the squares of the addends.
     */
    public static double sumOfSquares(int a, int b) {

        return Math.pow(a, 2) + Math.pow(b, 2);

    }

    /**
     * Used to find the number of perfect pair of squares such that N = a^2 + b^2
     * @param N the sum of the squares.
     * @return number of squares for N.
     */
    public static int numberOfComplements(int N) {

        int high = (int) Math.sqrt(N);
        int low = 0;
        int counter = 0;

        while (high >= low) {

            if (sumOfSquares(high, low) == N) {
                counter++;
                high--;
                low = 0;
            } else if (sumOfSquares(high, low) > N) {
                high--;
            } else {
                //(sumOfSquares(high, low) < N)
                low++;
            }
        }

        return counter;

    }

}
