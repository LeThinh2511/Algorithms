package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-08
 */

public class FullBagException extends RuntimeException {
    public FullBagException() {
        super("Full Bag Exception: Failed to add item to the Bag which is full.");
    }
}
