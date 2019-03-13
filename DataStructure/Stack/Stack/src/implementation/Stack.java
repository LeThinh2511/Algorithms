package implementation;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Author: thinhle
 * Date: 2019-03-10
 */

public class Stack<Item> implements Iterable<Item> {
    private Node top;
    private int remains;
    private int capacity;

    public Stack(int capacity) {
        this.remains = 0;
        this.top = null;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return this.remains == 0;
    }

    public boolean isFull() {
        return this.capacity == this.remains;
    }

    public int remains() {
        return this.remains;
    }

    public int capacity() {
        return this.capacity;
    }

    public void push(Item item) {
        if (this.isFull()) {
            throw new StackOverflowException();
        }
        Node newNode = new Node(item);
        if (this.isEmpty()) {
            this.top = newNode;
            this.remains += 1;
            return;
        }
        newNode.next = this.top;
        top = newNode;
        this.remains += 1;
    }

    public Item pop() {
        if (this.isEmpty()) {
            throw new PopItemFromEmptyStackException();
        }
        Node node = this.top;
        this.top = node.next;
        this.remains -= 1;
        return (Item) node.item;
    }

    public Stack clone() {
        Stack<Item> tempStack = new Stack(this.capacity);
        for (Item item : this) {
            tempStack.push(item);
        }
        Stack<Item> newStack = new Stack(this.capacity);
        for (Item item : tempStack) {
            newStack.push(item);
        }
        return newStack;
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node currentNode = top;
            private int size = remains;

            @Override
            public boolean hasNext() {
                if (this.size != remains) {
                    throw new ConcurrentModificationException();
                }
                return currentNode != null;
            }

            @Override
            public Item next() {
                if (this.size != remains) {
                    throw new ConcurrentModificationException();
                }
                Node node = currentNode;
                currentNode = currentNode.next;
                return (Item) node.item;
            }
        };
    }

    class Node<Item> {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }
}
