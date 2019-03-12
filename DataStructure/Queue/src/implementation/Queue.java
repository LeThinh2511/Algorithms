package implementation;

import java.util.Iterator;

/**
 * Author: thinhle
 * Date: 2019-03-05
 */

public class Queue<Item> implements Iterable<Item> {
    private Node headNode;
    private Node tailNode;
    private int size;

    public Queue() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    public Queue(Queue<Item> queue) {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
        for (Item item : queue) {
            this.enqueue(item);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(Item item) {
        Node<Item> newNode = new Node<>(item);
        if (this.isEmpty()) {
            this.headNode = newNode;
            this.tailNode = newNode;
            this.size += 1;
            return;
        }
        this.tailNode.next = newNode;
        tailNode = tailNode.next;
        this.size += 1;
    }

    public Item dequeue() {
        if (this.isEmpty()) {
            throw new DequeueEmptyQueueException();
        }
        Node<Item> oldHeadNode = this.headNode;
        this.headNode = this.headNode.next;
        this.size -= 1;
        return oldHeadNode.item;
    }

    public void concatenate(Queue<Item> queue) {
        if (queue == null) {
            return;
        }
        this.tailNode.next = queue.headNode;
        this.tailNode = queue.tailNode;
        this.size += queue.size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private Node<Item> currentNode = headNode;
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
