package exercises.Exercise1334;

/**
 * Author: thinhle
 * Date: 2019-03-08
 */

public class PickEmptyBagException extends RuntimeException {
    public PickEmptyBagException() {
        super("Picking Empty Bag Exception: Failed to pick item from empty bag.");
    }
}
