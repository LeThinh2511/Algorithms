package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-10
 */

public class StackOverflowException extends RuntimeException {
    public StackOverflowException() {
        super("Stack Overflow Exception: Failed to push item to a full Stack.");
    }
}
