package com.heniv181.ArmstrongNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-18.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        while (scanner.hasNextLine()){
            Integer number = Integer.parseInt(scanner.nextLine());
            //System.out.print(number + " : " );
            System.out.println(isArmstrong(number) ? "True" : "False");    //It the number on this line a Armstrong number?
        }


    }


    private static boolean isArmstrong(int n) {

        /*    Definition: Armstrong
         *    153  (3 digits) : 1^3 + 5^3 + 3^3 = 153
         *    6 (1 digit) : 6^1 = 6
         *
         */

        int sum = 0;

        int length = (int) Math.floor(Math.log10(n)) + 1;   //Get number of digits in the number.
        assert length > 0;

        int reminder = n;
        int base = 10;
        for (int i = 0; i < length; i++) {
            sum += Math.pow(reminder % base, length);      //Add the digit^length to the sum.
            reminder /= 10;

        }

        return sum == n;

    }
}