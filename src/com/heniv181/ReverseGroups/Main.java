package com.heniv181.ReverseGroups;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Rearranges a String of numbers in the form of:  1,2,3,4,5;2 to 2,1,4,3,5 where 2 is the length of each group.
 * If the length is longer than the last group, it is left alone.
 *
 * Created by Henrik on 2016-03-29.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        int[] set;

        while (scanner.hasNextLine()){

            String line = scanner.nextLine();
            String[] numbers = line.split("[;,]");
            set = new int[numbers.length];

            for(int i = 0; i < numbers.length; i++){
                set[i] = Integer.parseInt(numbers[i]);
            }

            /*System.out.println(Arrays.toString(numbers));
            System.out.println(Arrays.toString(Arrays.copyOfRange(set,0,set.length-1)));
            System.out.println(set[set.length-1]);*/

            reverseGroup(Arrays.copyOfRange(set,0,set.length-1), set[set.length-1]);
        }




    }



    private static void reverseGroup(int[] set, int scope) {
        //System.out.println(Arrays.toString(set));

        for (int i = 0; i < set.length / scope; i++) {

            int[] temp = new int[scope];
            int index = i * scope;

            //Forward
            for (int j = 0; j < scope; j++) {
                temp[j] = set[index + j];
            }

            //Reverse
            for (int j = 0; j < scope; j++) {
                set[index + j] = temp[scope-j-1];
            }

            //System.out.println(Arrays.toString(temp));

        }
        String result = Arrays.toString(set);
        System.out.println(result.substring(1,result.length()-1).replaceAll("\\s+",""));
    }


}
