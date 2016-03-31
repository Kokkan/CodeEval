package com.heniv181.MultiplesOfANumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-05.
 */
public class MultiplesOfANumber {

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(f));
        Scanner scan = new Scanner(br);

        scan.useDelimiter(",");

//        while (scan.hasNext())
//            System.out.println(scan.next());


        while (scan.hasNext()) {

            Integer x = scan.nextInt();
            Integer n = scan.nextInt();
            scan.nextLine();
            System.out.print(x + " " + n + " -> ");


            int i = 0;
            while (x >= n * ++i) {
            }
            System.out.print(n + " * " + i + " = " + n * i + "\n");


        }


    }
}
