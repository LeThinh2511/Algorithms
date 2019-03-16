package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-03
 */

public class StackOverflowException extends RuntimeException {
    public StackOverflowException() {
        super("Stack overflow Exception: Failed to push item to the full stack.");
    }
}
