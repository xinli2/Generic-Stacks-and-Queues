/*
 * This interface is specific to queues of integers.
 * Make it generic!
 *
 * Note that the below comments were copied over from our non-generic
 * version of this interface. One of the changes you need to make to
 * the comments is that they say to return -1 for some error handling
 * cases. Since you are now returning an object, and not an integer, you
 * now need to return null. This is addressed in the PA spec as well.
 */
interface QueueInterface<E> {

    /*
     * Add an element to the back of the queue.
     */
    void enqueue(E value);

    /*
     * Remove and return the front element in the queue.
     * 
     * If the user attempts to dequeue from an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return -1.
     */
    E dequeue();

    /*
     * Return (but do NOT remove) the front element of the queue.
     * 
     * If the user tries to peek on an empty queue, ignore the
     * request (i.e. make no changes to your queue) and return -1.
     */
    E peek();

    /*
     * Returns true if the queue has no elements.
     */
    boolean isEmpty();

    /*
     * Returns the number of elements in the queue.
     */
    int size();

    /*
     * Removes all elements from the queue.
     */
    void clear();
}
