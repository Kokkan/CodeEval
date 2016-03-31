package com.heniv181.MthToTheLastElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-15.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        while (scanner.hasNextLine())
            printMth(scanner.nextLine());


    }

    private static void printMth(String line) {

        String[] letters = line.split(" ");

        //Last element in the line
        int index = Integer.parseInt(letters[letters.length - 1]);

        if (index <= letters.length && index > 0)
            System.out.println(letters[letters.length-1-index]);




    }
}
