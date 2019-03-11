package implementation;

import java.util.Iterator;

/**
 * Author: thinhle
 * Date: 2019-03-11
 */

public class CatenableQueue<Item> implements Iterable<Item> {
    private CircularLinkedList<Item> linkedList;

    public CatenableQueue() {
        this.linkedList = new CircularLinkedList<>();
    }

    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    public int size() {
        return this.linkedList.size();
    }

    public void enqueue(Item item) {
        this.linkedList.insertAtTheEnd(item);
    }

    public Item dequeue() {
        return this.linkedList.removeAtTheBeginning();
    }

    public void concatenate(CatenableQueue<Item> queue) {
        while (!queue.isEmpty()) {
            Item item = queue.dequeue();
            this.enqueue(item);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return this.linkedList.iterator();
    }
}
