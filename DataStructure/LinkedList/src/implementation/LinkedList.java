package implementation;

import java.util.Iterator;

/**
 * Author: thinhle
 * Date: 2019-03-04
 */

public class LinkedList<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void insert(Item item, int index) {
        if (index > this.size || index < 0) {
            throw new LinkedListIndexOutOfBoundsException("Index out of bound exception: Failed to insert item to invalid index.");
        }
        if (index == 0) {
            this.insertAtTheBeginning(item);
        } else if (index == this.size) {
            this.insertAtTheEnd(item);
        } else {
            Node newNode = new Node(item);
            Node previousNode = this.getNodeAt(index - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
            this.size += 1;
        }
    }

    public void insertAtTheBeginning(Item item) {
        Node newNode = new Node(item);
        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            newNode.next = this.first;
            this.first = newNode;
        }
        this.size += 1;
    }

    public void insertAtTheEnd(Item item) {
        Node newNode = new Node(item);
        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            int endIndex = this.size - 1;
            Node endNode = this.getNodeAt(endIndex);
            endNode.next = newNode;
        }
        this.size += 1;
    }

    public Item removeAt(int index) {
        if (index >= this.size || index < 0) {
            throw new LinkedListIndexOutOfBoundsException("Index out of bound exception: Failed to remove item from invalid index.");
        }
        if (index == 0) {
            return this.removeAtTheBeginning();
        } else if (index == this.size - 1) {
            return this.removeAtTheEnd();
        } else {
            Node previousNode = this.getNodeAt(index - 1);
            Node node = previousNode.next;
            previousNode.next = node.next;
            this.size -= 1;
            return (Item) node.item;
        }
    }

    public Item removeAtTheBeginning() {
        if (this.isEmpty()) {
            throw new LinkedListIndexOutOfBoundsException("Index out of bound exception: Failed to remove item from empty linked list");
        }
        Node firstNode = this.first;
        this.first = this.first.next;
        this.size -= 1;
        return (Item) firstNode.item;
    }

    public Item removeAtTheEnd() {
        if (this.isEmpty()) {
            throw new LinkedListIndexOutOfBoundsException("Index out of bound exception: Failed to remove item from empty linked list");
        }
        if (this.size == 1) {
            Node endNode = this.first;
            this.first = null;
            this.size -= 1;
            return (Item) endNode.item;
        }
        int endIndex = this.size - 1;
        Node previousNode = this.getNodeAt(endIndex - 1);
        Node endNode = previousNode.next;
        previousNode.next = null;
        this.size -= 1;
        return (Item) endNode.item;
    }

    public Item get(int index) {
        Node node = this.getNodeAt(index);
        return (Item) node.item;
    }

    public void reverseRecursive() {
        if (this.first == null) {
            return;
        }
        if (this.first.next == null) {
            return;
        }
        Node oldFirstNode = this.first;
        Node secondNode = this.first.next;
        this.first = this.first.next;
        this.reverseRecursive();
        oldFirstNode.next = null;
        secondNode.next = oldFirstNode;
    }

    public void reverse() {
        if (this.first == null) {
            return;
        }
        Node newFirstNode = this.first;
        Node secondNode = this.first.next;
        this.first = secondNode;
        newFirstNode.next = null;
        while (this.first.next != null) {
            secondNode = secondNode.next;
            this.first.next = newFirstNode;
            newFirstNode = this.first;
            this.first = secondNode;
        }
        this.first.next = newFirstNode;
    }

    private Node getNodeAt(int index) {
        if (index >= this.size) {
            throw new LinkedListIndexOutOfBoundsException("Index out of bound exception: Failed to get item from invalid index.");
        }
        Node currentNode = this.first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
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

        Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }
}
