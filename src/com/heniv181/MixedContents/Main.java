package com.heniv181.MixedContents;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-03.
 */
public class Main {

    private static ArrayList<String> words;
    private static ArrayList<String> numbers;

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);

        Scanner scanner = new Scanner(new FileReader(file));
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            sortAndPrintLine(scanner.nextLine());
        }


    }

    public static void sortAndPrintLine(String line) {

        //Somewhere to put the types.
        words = new ArrayList<>();
        numbers = new ArrayList<>();

        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {

            String token = scanner.next();

            try {
                Integer.parseInt(token);
                numbers.add(token);      // Can parse int, it's a number.
            } catch (NumberFormatException e) {
                words.add(token);        // Could not parse as int, then treat it as a word.
            }


        }

        //Special string format for CodeEval
        String result = "";

        for (String s : words) {
            result += s + ",";
        }
        result =  (result.length() > 1) ? result.substring(0, result.length() - 1) + "|": result;
        for (String s : numbers) {
            result += s + ",";
        }
        result =  (result.length() > 1) ? result.substring(0, result.length() - 1) : result;

        System.out.println(result);


    }


}
