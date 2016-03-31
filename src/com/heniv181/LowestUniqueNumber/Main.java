package com.heniv181.LowestUniqueNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-25.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        File f = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(f));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            ArrayList<Integer> list = new ArrayList<>();
            for (String s : line.split(" ")) {
                list.add(Integer.parseInt(s));
            }

            HashMap<Integer, Integer> map = mapIntsFromString(line);

            int lowestIndex = list.indexOf(getLowestUniqueValue(map));

            System.out.println((lowestIndex == -1) ? 0 : ++lowestIndex);   //Index starts on 1 for some stupid reason.
        }


    }


    private static int getLowestUniqueValue(HashMap<Integer, Integer> map) {

        int min = Integer.MAX_VALUE;    //Can only get smaller.

        for (Map.Entry entry : map.entrySet()) {
            int key = (int) entry.getKey();          // Key is the number, value the occurrences of that value.
            if (entry.getValue().equals(1)) {        // Map contains only one of this type, hence is unique in set.
                min = ((key < min) ? key : min);
            }
        }

        if (min == Integer.MIN_VALUE)   //No unique values found, return 0 (it's not a possible value of the set).
            min = 0;

        return min;
    }

    private static HashMap<Integer, Integer> mapIntsFromString(String line) {

        HashMap<Integer, Integer> map = new HashMap<>();

        Scanner scanInt = new Scanner(line);

        while (scanInt.hasNext()) {
            int i = scanInt.nextInt();
            Integer value = map.get(i);

            if (value == null)
                map.put(i, 1);
            else
                map.put(i, ++value);


        }

        return map;
    }
}
