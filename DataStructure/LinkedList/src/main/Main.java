package main;

import implementation.LinkedList;

/**
 * Author: thinhle
 * Date: 2019-03-04
 */

public class Main {
    public static void main(String args[]) {
        LinkedList<String> strings = new LinkedList<>();
        strings.insertAtTheBeginning("Le");
        strings.insertAtTheEnd("Thinh");
        strings.insert("Xin chao", 0);
        strings.insertAtTheEnd("Dep trai");
        strings.insert("test", 1);
        strings.removeAtTheEnd();
        strings.insert("Dep trai", 4);
        strings.removeAt(1);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
