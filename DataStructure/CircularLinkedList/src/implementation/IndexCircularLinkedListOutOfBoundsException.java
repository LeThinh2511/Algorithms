package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-09
 */

public class IndexCircularLinkedListOutOfBoundsException extends RuntimeException {
    public IndexCircularLinkedListOutOfBoundsException() {
        super("Index out of bound: Failed to access item at invalid index.");
    }
}
