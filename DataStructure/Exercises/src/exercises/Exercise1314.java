package exercises;

/**
 * Author: thinhle
 * Date: 2019-03-07
 */

public class Exercise1314 {

    public static void main(String args[]) {
        // Test here
    }
}


// Cycle Array

class ResizingArrayQueueOfStrings {
    private String[] strings;
    private int size;
    private int headIndex;

    public ResizingArrayQueueOfStrings() {
        this.strings = new String[1];
        this.size = 0;
        this.headIndex = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void enqueue(String string) {
        if (this.isFull()) {
            this.resize(this.size * 2);
        }
        int index = (this.size + headIndex) % this.strings.length;
        this.strings[index] = string;
        this.size += 1;
    }

    public String dequeue() {
        if (this.isEmpty()) {
            throw new DequeueEmptyQueueException();
        }
        String string = this.strings[headIndex];
        this.strings[headIndex] = null;
        this.headIndex = (this.headIndex + 1) % this.strings.length;
        this.size -= 1;
        if (this.size < this.strings.length / 2) {
            this.resize(this.strings.length / 2);
        }
        return string;
    }

    public void print() {
        for (int i = 0; i < this.strings.length; i++) {
            System.out.print(this.strings[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    private boolean isFull() {
        return this.size == this.strings.length;
    }

    private void resize(int capacity) {
        String[] newStrings = new String[capacity];
        for (int i = 0; i < this.size; i++) {
            newStrings[i] = this.strings[(i + headIndex) % this.strings.length];
        }
        this.strings = newStrings;
        this.headIndex = 0;
    }
}

class DequeueEmptyQueueException extends RuntimeException {
    public DequeueEmptyQueueException() {
        super("Dequeue Empty Queue Exception: Failed to dequeue empty Queue.");
    }
}
