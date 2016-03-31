package com.heniv181.FizzBuzz;

import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));

        String line;
        while ((line = buffer.readLine()) != null) {

            line = line.trim();
            String[] words = line.split(" ");

            int fizz = Integer.parseInt(words[0]);
            int buzz = Integer.parseInt(words[1]);
            int max = Integer.parseInt(words[2]);

            for (int i = 1; i <= max; i++){

                if(i % fizz == 0 && i % buzz == 0 )
                    System.out.print("FB ");
                else if(i % fizz == 0)
                    System.out.print("F ");
                else if(i % buzz == 0)
                    System.out.print("B ");
                else
                    System.out.print(i + " ");


            }
            System.out.print("\n");

        }
    }
}
