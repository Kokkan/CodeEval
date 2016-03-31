package com.heniv181;

import java.util.Scanner;

class Scribbles {

    public static void main(String[] args) {


        Scanner scanner = new Scanner("input");

        while(scanner.hasNextLine()) {
            String lineOne = scanner.nextLine();
            String lineTwo = scanner.nextLine();
            String lineThree = scanner.nextLine();
            //calculateSomething(lineOne, lineTwo, lineThree);
        }


    }

    private static int[] getPolynomialFactors(String line) {
        Scanner splitter = new Scanner(line);

        int[] p = new int[4];
        int counter=0;

        while (splitter.hasNextInt()){
            p[counter] = splitter.nextInt();
            counter++;
        }
        return  p;
    }


}