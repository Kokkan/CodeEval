package com.heniv181.Testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-14.
 */
public class Testing {

    public static void main(String[] args) {

        try {

            File file = new File(args[0]);
            Scanner scan = new Scanner(new FileReader(file));

            while (scan.hasNextLine()) {

                String line = scan.nextLine();
                String words[] = line.split(" \\| ");

                int diff = 0;

                for (int i = 0; i <= words[0].length()-1; i++) {

                    if (words[0].charAt(i) != words[1].charAt(i)) {
                        diff++;
                    }

                }

                if(diff == 0)
                    System.out.println("Done");
                else if(diff <= 2)
                    System.out.println("Low");
                else if(diff <= 4)
                    System.out.println("Medium");
                else if(diff <= 6)
                    System.out.println("High");
                else
                    System.out.println("Critical");

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
