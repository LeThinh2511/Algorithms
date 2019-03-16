package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-04
 */

public class LinkedListIndexOutOfBoundsException extends RuntimeException {
    public LinkedListIndexOutOfBoundsException() {
        super("Index out of bound exception: Failed to access item from invalid index.");
    }
}
