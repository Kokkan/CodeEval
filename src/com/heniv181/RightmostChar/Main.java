package com.heniv181.RightmostChar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-27.
 */
public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {

            readAndSplitLine(scanner.nextLine());
        }

    }

    private static void readAndSplitLine(String inputLine) {

        Scanner splitter = new Scanner(inputLine);
        splitter.useDelimiter(",");

        String line = splitter.next();
        String character = splitter.next().trim();

        printCharIndex(line, character);

    }

    private static void printCharIndex(String line, String character) {

        for (int i = line.length() - 1; i > 0; i--) {

            if (line.charAt(i) == character.charAt(0)) {
                System.out.println(i);
                return;
            }

        }
        System.out.println("-1");     //Character does not exist in String.
    }


}
