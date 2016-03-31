package com.heniv181.SetIntersection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Henrik on 2016-03-20.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        int i = 1;
        while (scanner.hasNextLine()) {

           // System.out.print(i + ": ");
            mapAndPrintIntersection(scanner.nextLine());
            i++;

        }


    }



    private static void mapAndPrintIntersection(String line) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        Scanner scan = new Scanner(line);
        scan.useDelimiter("[,*;*]");

        while (scan.hasNext()) {

            int key = scan.nextInt();
            int count = map.containsKey(key) ? map.get(key) : 0;
            map.put(key, count + 1);

        }



        String result = "";
        for (Integer n : map.keySet()) {
            if (map.get(n) > 1)
                result += n + ",";
        }
        if (result.length() > 1) {
            result = result.substring(0, result.length() - 1);

        }

        //Damn CodeEval ... why the fuck no trailing ',' in the anwser?
        System.out.println(result);


        //  System.out.println(result.substring(0, result.length()-1));
    }
}
