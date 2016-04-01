package com.heniv181.DecodeNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-04-01.
 */
public class Main {

    private static int combinations = 0;

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            countCombinations(line);
            System.out.println(/*line + " : " +*/ combinations);
            combinations = 0;   //Reset counter for next line.
        }


    }

    /**
     * Counts the number of combinations where the string can represent a set of letters,
     * by counting the number of recursive paths that reach the end of the string. It opens up a
     * new recursive branch if the first two numbers can form a higher letter of the alphabet.
     * 123 -> (1,2,3)(12,3) = (A,B,B)(L,C)
     *
     * @param line a string of integers, cannot be empty.
     */
    private static void countCombinations(String line) {


        if (line.length() < 1)   //Base case, one combination path done.
            combinations++;

        else {

            if (line.length() >= 2) {     //One or two candidates, recursive call.

                if (Integer.parseInt(line.substring(0, 2)) < 27) {   //Two digit candidates for a letter. Open up a new recursive branch.
                    countCombinations(line.substring(2));
                }
            }

            countCombinations(line.substring(1));      // Standard recursive branch/path.
        }


    }
}
