package exercises.Exercise1334;

import java.util.Iterator;
import java.util.Random;

/**
 * Author: thinhle
 * Date: 2019-03-08
 */

public class Exercise1334 {
    public static void main(String args[]) {
        RandomBag<String> bag = new RandomBag<>(10);
        bag.add("Le");
        bag.add("Thinh");
        bag.add("Dep");
        bag.add("Trai");
        for (String string: bag) {
            System.out.println(string);
        }
    }
}

class RandomBag<Item> implements Iterable<Item> {
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
