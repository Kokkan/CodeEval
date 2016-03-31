package com.heniv181.FindAWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-20.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(Paths.get(args[0]));

        while (sc.hasNext()) {
             decodeLine(sc.nextLine());
        }

    }

    private static void decodeLine(String code) {
        String[] split = code.split("\\|");

        Scanner scanner = new Scanner(split[1]);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (scanner.hasNext()) {
            numbers.add(scanner.nextInt());
        }

        for (Integer n : numbers) {
            System.out.print(code.charAt(n-1));

        }
        System.out.println();
    }


}
