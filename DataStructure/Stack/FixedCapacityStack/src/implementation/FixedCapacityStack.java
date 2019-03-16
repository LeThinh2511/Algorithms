package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-03
 */

public class FixedCapacityStack<Item> {
    private Item[] items;
    private int top;
    private int capacity;

    public FixedCapacityStack(int capacity) {
        this.items = (Item[]) new Object[capacity];
        this.top = 0;
        this.capacity = capacity;
    }

    public FixedCapacityStack(FixedCapacityStack<Item> stack) {
        this.items = (Item[]) new Object[stack.capacity()];
        this.capacity = stack.capacity();
        this.top = stack.top;
        for (int i = 0; i < stack.top; i++) {
            this.items[i] = stack.items[i];
        }
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public boolean isFull() {
        return items.length == top;
    }

    public void push(Item item) {
        if (this.isFull()) {
            throw new StackOverflowException();
        } else {
            this.items[top] = item;
            top += 1;
        }
    }

    public Item pop() {
        if (this.isEmpty()) {
            throw new PopEmptyStackException();
        } else {
            top -= 1;
            return this.items[top];
        }
    }
}
