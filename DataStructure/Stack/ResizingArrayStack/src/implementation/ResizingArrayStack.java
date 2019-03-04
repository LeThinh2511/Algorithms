package implementation;

import java.util.Iterator;

/**
 * Author: thinhle
 * Date: 2019-03-04
 */

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] items;
    private int top;

    public ResizingArrayStack() {
        this.items = (Item[]) new Object[1];
        this.top = 0;
    }

    public void push(Item item) {
        if (this.top == this.items.length) {
            if (this.items.length == 0) {
                this.resize(1);
            } else {
                this.resize(this.top * 2);
            }
        }
        this.items[top] = item;
        top += 1;
    }

    public Item pop() {
        if (this.isEmpty()) {
            throw new PopEmptyStackException("Pop Empty Stack Exception: Failed to pop item from empty stack.");
        } else {
            Item item = this.items[top - 1];
            top -= 1;
            if (this.top * 2 == this.items.length) {
                this.resize(this.items.length / 2);
            }
            return  item;
        }
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public int size() {
        return top;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < this.top; i++) {
            temp[i] = this.items[i];
        }
        this.items = temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    class ReverseArrayIterator implements Iterator<Item> {
        private int index = top;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public Item next() {
            return items[--index];
        }
    }
}
