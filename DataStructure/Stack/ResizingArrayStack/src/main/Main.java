package main;

import implementation.ResizingArrayStack;

/**
 * Author: thinhle
 * Date: 2019-03-04
 */

public class Main {
    public static void main(String args[]) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        String item;
        System.out.println("size: " + stack.size());
        stack.push("Le Thinh");
        System.out.println("size: " + stack.size());
        stack.push("Le Thinh 1");
        System.out.println("size: " + stack.size());
        stack.push("Le thinh 2");
        System.out.println("size: " + stack.size());

        System.out.println("List: ");
        for (String string : stack) {
            System.out.println(string);
        }

        item = stack.pop();
        System.out.println("size: " + stack.size() + item);
        item = stack.pop();
        System.out.println("size: " + stack.size() + item);
        item = stack.pop();
        System.out.println("size: " + stack.size() + item);
    }
}
