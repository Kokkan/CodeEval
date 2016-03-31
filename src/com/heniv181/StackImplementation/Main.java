package com.heniv181.StackImplementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Henrik on 2016-03-26.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(args[0]);
        Scanner scanner = new Scanner(new FileReader(file));

        IntegerStack stack;
        while (scanner.hasNextLine()) {
            stack = getStackFromLine(scanner.nextLine());

            String result = "";
            //Loop through stack, print every alternate space delimited integer.

            Integer value;
            int i = 0;
            while ((value = stack.pop()) != null) {
                if (i % 2 == 0)
                    result += value + " ";
                i++;
            }

            result += "\n";

            System.out.println(result.trim());
        }


    }


    /**
     * Returns a IntergerStack object from a String of numbers. Space delimited.
     *
     * @param line
     * @return IntegerStack reference.
     */
    private static IntegerStack getStackFromLine(String line) {

        Scanner wordReader = new Scanner(line);
        IntegerStack stack = new IntegerStack();

        while (wordReader.hasNext()) {
            stack.push(wordReader.nextInt());

        }

        return stack;

    }

}

/**
 * A stack of Integers in the form of a single-linked list of Nodes.
 */
class IntegerStack {

    private Node firstNode = null;

    /**
     * Add a value to the top of the stack in the form of a Node containing a value and a
     * reference to the next object (Node) in the stack.
     * @param n the value to the contained in the Node.
     */
    public void push(int n) {
        Node newNode = new Node(n);
        newNode.next = firstNode;
        firstNode = newNode;

    }

    /**
     * Returns the value in the Node and removes it from the top of the stack.
     * @return the value contained in the Node.
     */
    public Integer pop() {

        Integer value = null;

        if (firstNode != null) {
            value = firstNode.value;
            firstNode = firstNode.next;
        } else
            return null;

        return value;

    }


    public String toString() {

        String values = "[ ";
        Node pointer = firstNode;

        while (pointer != null) {
            values += pointer.value + " ";
            pointer = pointer.next;
        }

        values += "]";

        return values;


    }

    /**
     * Node object in the list, containing a value and a reference to the next node.
     */
    class Node {
        int value;
        Node next;

        Node(int v) {
            value = v;
        }


    }


}
