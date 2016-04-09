package com.heniv181.NumberPairs;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-04-06.
 */
public class Main {

    public static void main(String[] args) throws Exception {


        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        while (scanner.hasNextLine()) {
            String set = scanner.nextLine();
            String pairs = findPairs(parseLine(set));
            System.out.println(pairs);
        }


    }

    //Get a Candidate (a set of ints and an int sum.) from a String line.
    private static Candidate parseLine(String line) throws Exception {

        String[] stringNumbers = line.split("[,;]");

        int[] numbers = new int[stringNumbers.length - 1];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }

        int sum = (stringNumbers.length > 1) ? Integer.parseInt(stringNumbers[stringNumbers.length - 1]) : 0;

        return new Candidate(numbers, sum);

    }


    //Find the pairs in the set in the Candidate where 2 numbers in the set is equal to sum of the Candidate
    private static String findPairs(Candidate candidate) throws Exception {

        if (candidate.set.length <= 1)
            return "NULL";

        String pairs = "";
        int bottom = 0;
        int top = candidate.set.length - 1;

        //Check pairs from edge of array and step to center.
        while (top > bottom) {

            int sumOfPair = candidate.set[bottom] + candidate.set[top];

            if (sumOfPair < candidate.sum) {
                bottom++;

            } else if (sumOfPair == candidate.sum) {
                pairs = pairs.concat(candidate.set[bottom] + "," + candidate.set[top] + ";");
                bottom++;
                top--;

            } else if (sumOfPair > candidate.sum) {
                top--;

            } else {
                throw new Exception("This should not happen! If-case sieve broken.");
            }

        }

        if (pairs.isEmpty())
            return "NULL";
        else
            return pairs.substring(0, pairs.length() - 1);
    }

    private static class Candidate {

        Candidate(int[] set, int sum) {
            this.set = set;
            this.sum = sum;
        }

        int[] set;
        int sum;
    }


}
