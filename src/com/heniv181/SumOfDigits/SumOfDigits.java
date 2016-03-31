package com.heniv181.SumOfDigits;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-14.
 */
public class SumOfDigits {

    public static void main(String[] args) {



        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(new FileReader(file));

            while (scanner.hasNext()) {

                String line = scanner.nextLine();
                Integer sum = 0;

                for (Character c : line.toCharArray()) {
                    sum += Integer.parseInt(c.toString());

                }

                System.out.println(sum);


            }


        } catch (FileNotFoundException | NumberFormatException | NullPointerException e) {
            e.printStackTrace();
        }


    }

}
