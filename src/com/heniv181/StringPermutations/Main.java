package com.heniv181.StringPermutations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-19.
 * <p>
 * URL=https://www.codeeval.com/public_sc/14/
 */
public class Main {

    private static ArrayList<String> permutations;


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));


        while (scanner.hasNext()) {

            permutations = new ArrayList<String>();

            char[] chars = scanner.nextLine().toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            dividePerm("", sorted);
            String result = "";
            for (int i = 0; i < permutations.size(); i++) {
                result += permutations.get(i) + ",";
            }
            System.out.println(result.substring(0, result.length()-1));
        }
    }


    private static String removeChar(String sorted, int index) {

        return sorted.substring(0, index) + sorted.substring(index + 1);
    }

    private static void dividePerm(String output, String reminder) {

        if (reminder.isEmpty()) {
            permutations.add(output + reminder);
            //System.out.print(output + reminder + ",");
            return;
        }

        for (int i = 0; i < reminder.length(); i++) {

            dividePerm(output + reminder.charAt(i), removeChar(reminder, i));

        }


    }


}
