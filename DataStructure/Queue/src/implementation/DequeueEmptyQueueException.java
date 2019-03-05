package implementation;

/**
 * Author: thinhle
 * Date: 2019-03-05
 */

public class DequeueEmptyQueueException extends RuntimeException {
    private static String localizedDescription = "Dequeue Empty Queue Exception: Failed to dequeue empty queue.";
    public DequeueEmptyQueueException() {
        super(localizedDescription);
    }
}
