package com.heniv181.FibonacciSeries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-17.
 */
public class Main {


    public static void main(String[] args) throws FileNotFoundException {


        File file = new File(args[0]);
        Scanner scan = new Scanner(new FileReader(file));

        while (scan.hasNextLine())
           System.out.println( fibonnaci(Integer.parseInt(scan.nextLine())) );

    }



    public static int fibonnaci(int n) {

        if(n < 0)
            throw new NumberFormatException("Negative number not allowed!");
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonnaci(n-1) + fibonnaci(n-2);


    }
}
