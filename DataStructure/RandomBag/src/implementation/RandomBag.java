package implementation;

import java.util.Iterator;
import java.util.Random;

/**
 * Author: thinhle
 * Date: 2019-03-08
 */

public class RandomBag<Item> implements Iterable<Item> {
    private Node first;
    private int capacity;
    private int remains;

    public RandomBag(int capacity) {
        this.first = null;
        this.capacity = capacity;
        this.remains = 0;
    }

    public boolean isFull() {
        return this.remains == this.capacity;
    }

    public boolean isEmpty() {
        return this.remains == 0;
    }

    public int remains() {
        return this.remains;
    }

    public void add(Item item) {
        if (this.isFull()) {
            throw new FullBagException();
        }
        Node newNode = new Node(item);
        newNode.next = this.first;
        this.first = newNode;
        this.remains += 1;
    }

    public Item pick() {
        if (this.isEmpty()) {
            throw new PickEmptyBagException();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(this.remains);
        Node node;
        if (randomIndex == 0) {
            node = this.first;
            this.first = this.first.next;
        } else if (randomIndex == this.remains - 1) {
            Node previousNode = this.getNodeAt(randomIndex - 1);
            node = previousNode.next;
            previousNode.next = null;
        } else {
            Node previousNode = this.getNodeAt(randomIndex - 1);
            node = previousNode.next;
            previousNode.next = node.next;
        }
        this.remains -= 1;
        return (Item) node.item;
    }

    public RandomBag<Item> clone() {
        int capacity = this.capacity;
        RandomBag<Item> newRandomBag = new RandomBag<>(capacity);
        Node<Item> currentNode = this.first;
        while (currentNode != null) {
            Item item = currentNode.item;
            newRandomBag.add(item);
            currentNode = currentNode.next;
        }
        return newRandomBag;
    }

    public void mix(RandomBag<Item> randomBag) {
        if (this.remains + randomBag.remains > this.capacity) {
            throw new FullBagException();
        }
        Node<Item> currentNode = this.first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = randomBag.first;
        this.remains += randomBag.remains();
        randomBag.remains = 0;
        randomBag.first = null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator<>();
    }

    private Node getNodeAt(int index) {
        Node currentNode = this.first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    class BagIterator<Item> implements Iterator<Item> {
        int[] indexes;
        int remainsIndexes;

        public BagIterator() {
            this.indexes = new int[remains];
            for (int i = 0; i < remains; i++) {
                indexes[i] = i;
            }
            this.remainsIndexes = remains;
        }

        @Override
        public boolean hasNext() {
            return this.remainsIndexes > 0;
        }

        @Override
        public Item next() {
            Random random = new Random();
            int randomIndex = random.nextInt(this.remainsIndexes);
            Node node = getNodeAt(this.indexes[randomIndex]);
            this.remainsIndexes -= 1;
            this.indexes[randomIndex] = this.indexes[this.remainsIndexes];
            return (Item) node.item;
        }
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
