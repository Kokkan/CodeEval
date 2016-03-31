package com.heniv181.LongestLines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Henrik on 2016-03-21.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, NumberFormatException {


        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        Comparator<String> lengthsComparator = (s1, s2) -> s1.length() - s2.length();
        TreeSet<String> lines = new TreeSet<>(lengthsComparator);

        int linesToPrint = Integer.parseInt(scanner.nextLine());

        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }

        Iterator<String> iterator = lines.descendingIterator();

        while (iterator.hasNext() && linesToPrint > 0) {
            System.out.println(iterator.next());
            linesToPrint--;

        }

    }

}
