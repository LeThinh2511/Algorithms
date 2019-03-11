package implementation;

import java.util.Iterator;

/**
 * Author: thinhle
 * Date: 2019-03-09
 */

public class CircularLinkedList<Item> implements Iterable<Item> {
    private Node last;
    private int size;

    public CircularLinkedList() {
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void insertAt(Item item, int index) {
        if (index < 0 || index > this.size) {
            throw new IndexCircularLinkedListOutOfBoundsException();
        }
        if (index == 0) {
            this.insertAtTheBeginning(item);
            return;
        }
        if (index == this.size) {
            this.insertAtTheEnd(item);
            return;
        }
        Node previousNode = this.getNodeAt(index - 1);
        Node nextNode = previousNode.next;
        Node newNode = new Node(item);
        previousNode.next = nextNode;
        newNode.next = nextNode;
        this.size += 1;
    }

    public void insertAtTheEnd(Item item) {
        Node newNode = new Node(item);
        if (this.isEmpty()) {
            this.last = newNode;
        } else if (this.size == 1) {
            this.last.next = newNode;
            newNode.next = this.last;
            this.last = newNode;
        } else {
            Node first = this.last.next;
            this.last.next = newNode;
            newNode.next = first;
            this.last = newNode;
        }
        this.size += 1;
    }

    public void insertAtTheBeginning(Item item) {
        Node newNode = new Node(item);
        if (this.isEmpty()) {
            this.last = newNode;
            this.size += 1;
            return;
        }
        if (this.size == 1) {
            this.last.next = newNode;
            newNode.next = this.last;
            this.size += 1;
            return;
        }
        Node first = this.last.next;
        this.last.next = newNode;
        newNode.next = first;
        this.size += 1;
    }

    public Item removeAt(int index) {
        if (this.size <= index || index < 0) {
            throw new IndexCircularLinkedListOutOfBoundsException();
        }
        if (index == 0) {
            return this.removeAtTheBeginning();
        }
        if (index == this.size - 1) {
            return this.removeAtTheEnd();
        }
        Node previousNode = this.getNodeAt(index - 1);
        Node node = previousNode.next;
        previousNode.next = node.next;
        if (index == this.size - 1) {
            this.last = previousNode;
        }
        this.size -= 1;
        return (Item) node.item;
    }

    public Item removeAtTheBeginning() {
        if (this.isEmpty()) {
            throw new RemoveEmptyLinkedListException();
        }
        if (this.size == 1) {
            Node node = this.last;
            this.last = null;
            this.size -= 1;
            return (Item) node.item;
        }
        if (this.size == 2) {
            Node node = this.last.next;
            this.last.next = null;
            this.size -= 1;
            return (Item) node.item;
        }
        Node node = this.last.next;
        this.last.next = node.next;
        this.size -= 1;
        return (Item) node.item;
    }

    public Item removeAtTheEnd() {
        if (this.isEmpty()) {
            throw new RemoveEmptyLinkedListException();
        }
        if (this.size == 1) {
            Node node = this.last;
            this.last = null;
            this.size -= 1;
            return (Item) node.item;
        }
        if (this.size == 2) {
            Node node = this.last;
            this.last = node.next;
            this.last.next = null;
            this.size -= 1;
            return (Item) node.item;
        }
        Node previousNode = this.getNodeAt(this.size - 1);
        Node node = this.last;
        this.last = previousNode;
        this.last.next = node.next;
        this.size -= 1;
        return (Item) node.item;
    }

    public Item getItemAt(int index) {
        if (this.size <= index || index < 0) {
            throw new IndexCircularLinkedListOutOfBoundsException();
        }
        if (this.size == 1) {
            return (Item) this.last.item;
        }
        Node currentNode = this.last.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return (Item) currentNode.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int count = size;
            private Node currentNode = last;

            @Override
            public boolean hasNext() {
                return this.count > 0;
            }

            @Override
            public Item next() {
                if (size == 1) {
                    this.count -= 1;
                    return (Item) last.item;
                } else {
                    currentNode = currentNode.next;
                    this.count -= 1;
                    return (Item) currentNode.item;
                }
            }
        };
    }

    private Node getNodeAt(int index) {
        if (this.size <= index || index < 0) {
            throw new IndexCircularLinkedListOutOfBoundsException();
        }
        if (this.size == 1) {
            return this.last;
        }
        Node currentNode = this.last.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
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
