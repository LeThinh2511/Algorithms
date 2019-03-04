package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-03
 */

public class FixedCapacityStack<Item> {
    private Item[] items;
    private int top;

    public FixedCapacityStack(int capacity) {
        this.items = (Item[]) new Object[capacity];
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public boolean isFull() {
        return items.length == top;
    }

    public void push(Item item) {
        if (this.isFull()) {
            throw new StackOverflowException("Stack overflow Exception: Failed to push item to the full stack.");
        } else {
            this.items[top] = item;
            top += 1;
        }
    }

    public Item pop() {
        if (this.isEmpty()) {
            throw new PopEmptyStackException("Pop empty stack exception: Failed to pop item from empty stack.");
        } else {
            top -= 1;
            return this.items[top];
        }
    }
}