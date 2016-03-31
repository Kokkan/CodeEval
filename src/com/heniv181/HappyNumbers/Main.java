package com.heniv181.HappyNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Henrik on 2016-03-15.
 */
public class Main {

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {

        File file = new File(args[0]);
        Scanner scan = new Scanner(new FileReader(file));


        while (scan.hasNextLine()){
            String line = scan.nextLine();
            Set<String> history = new HashSet<>();

            if(isHappyNumber(line, history))
                System.out.println(1);
            else
                System.out.println(0);

        }

    }


    public static boolean isHappyNumber(String word, Set<String> history) throws NumberFormatException{

        Integer sum = 0;

        if(word.equals("1"))
            return true;
        else if (history.contains(word))
            return false;
        else {

            for (Character c : word.toCharArray()) {

                int n = Integer.parseInt(c.toString());
                sum += n * n;

            }

            history.add(word);

            return isHappyNumber(sum.toString(), history);

        }

    }
}
