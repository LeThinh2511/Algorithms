package main;

import implementation.FixedCapacityStack;
import implementation.PopEmptyStackException;
import implementation.StackOverflowException;

/**
 * Author: thinhle
 * Date: 2019-03-03
 */

public class Main {
    public static void main(String args[]) {
        FixedCapacityStack<String> stackOfStrings = new FixedCapacityStack(5);
        stackOfStrings.push("Le Thinh");
        stackOfStrings.push("Le Thinh 1");
        stackOfStrings.pop();
        stackOfStrings.push("Le Thinh 2");
        stackOfStrings.push("Le Thinh 3");
        while (!stackOfStrings.isEmpty()) {
            System.out.println(stackOfStrings.pop());
        }
    }
}
