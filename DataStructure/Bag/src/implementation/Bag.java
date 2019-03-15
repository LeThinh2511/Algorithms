package implementation;

import java.util.Iterator;

/**
 * Author: thinhle
 * Date: 2019-03-06
 */

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    public Bag() {
        this.first = null;
        this.size = 0;
    }

    public Bag(Bag bag) {
        Node<Item> currentNode = bag.first;
        while (currentNode != null) {
            Item item = currentNode.item;
            this.add(item);
            currentNode = currentNode.next;
        }
        this.size = bag.size();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(Item item) {
        Node newNode = new Node(item);
        if (this.isEmpty()) {
            this.first = newNode;
            this.size += 1;
            return;
        }
        newNode.next = first;
        this.first = newNode;
        this.size += 1;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node currentNode = first;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Item next() {
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
