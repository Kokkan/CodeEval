package com.heniv181.MultiplicationTables;

/**
 * Created by Henrik on 2016-03-14.
 */
public class MultiplicationTables {

    private static final int HIGH = 12;

    public static void main(String[] args) {


        for (int i = 1; i <= HIGH; i++) {

            for (int j = 1; j <= HIGH; j++) {

                System.out.format("%4s",i*j);

            }
            System.out.println();
        }

    }
}
