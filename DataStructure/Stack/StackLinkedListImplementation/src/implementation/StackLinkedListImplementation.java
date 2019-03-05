package implementation;

import java.util.Iterator;

/**
 * Author: thinhle
 * Date: 2019-03-05
 */

public class StackLinkedListImplementation<Item> implements Iterable<Item> {
    private LinkedList<Item> linkedList = new LinkedList<>();

    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    public int size() {
        return this.linkedList.size();
    }

    public void push(Item item) {
        this.linkedList.insertAtTheBeginning(item);
    }

    public Item pop() {
        return this.linkedList.removeAtTheBeginning();
    }

    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int index = linkedList.size();

            @Override
            public boolean hasNext() {
                return index < linkedList.size();
            }

            @Override
            public Item next() {
                return linkedList.get(index);
            }
        };
    }
}
