package com.heniv181.ReverseWords;

import java.io.*;

/**
 * Created by Henrik on 2016-03-03.
 */
public class ReverseWords {

    public static void main(String[] args) {

        File file = new File(args[0]);
        try {

            BufferedReader buff = new BufferedReader(new FileReader(file));
            String line;

            while((line = buff.readLine()) != null){

                //System.out.println(line);
                String[] words = line.split(" ");

                for (int i = words.length-1; i >= 0; i--){
                    System.out.print(words[i] + " ");
                }
                System.out.print("\n");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
