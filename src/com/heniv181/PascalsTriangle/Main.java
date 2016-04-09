package com.heniv181.PascalsTriangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-04-09.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if (line.isEmpty())
                return;
            else {
                int depth = Integer.parseInt(line);
                printPythagorasTriangleAsLine(depth);

            }


        }


    }

    private static void printPythagorasTriangleAsLine(int depth) {


        int[][] pascalTriangle = new int[depth][];

        for (int i = 0; i < depth; i++) {

            pascalTriangle[i] = new int[i + 1];

            for (int j = 0; j < pascalTriangle[i].length; j++) {

                if (i == 0) {
                    pascalTriangle[i][j] = 1;

                } else if (j == pascalTriangle[i].length - 1) {
                    pascalTriangle[i][j] = 1;

                } else if (j == 0)
                    pascalTriangle[i][j] = 1;

                else {
                    pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];

                }
                System.out.print(pascalTriangle[i][j] + " ");

            }
            //System.out.print("\n");
        }
        System.out.print("\n");

       /* for(int[] r : pascalTriangle){
            System.out.println(Arrays.toString(r));
        }*/

    }
}
