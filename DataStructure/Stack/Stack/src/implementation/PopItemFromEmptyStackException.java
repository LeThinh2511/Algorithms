package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-10
 */

public class PopItemFromEmptyStackException extends RuntimeException {
    public PopItemFromEmptyStackException() {
        super("Pop Item From Empty Stack Exception: Failed to pop item from empty Stack.");
    }
}
