package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-03
 */

public class PopEmptyStackException extends RuntimeException {
    public PopEmptyStackException() {
        super("Pop empty stack exception: Failed to pop item from empty stack.");
    }
}
