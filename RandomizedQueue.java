/**
 * Created by tsaidani on 27/03/2018.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private Item[] a;         // array of items
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        n = 0;
    } // construct an empty randomized queue
    public boolean isEmpty() { return n == 0; }    // is the randomized queue empty?
    public int size() { return n; } // returns the number of items on the randomized queue
    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        // textbook implementation
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
        // alternative implementation
        // a = java.util.Arrays.copyOf(a, capacity);
    }

    public void enqueue(Item item) {
        if (n == a.length) resize(2*a.length);    // double size of array if necessary
        a[n++] = item;                            // add item
    } // add the item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("RandomizedQueue underflow");
        Item item = a[n-1];
        a[n-1] = null;                              // to avoid loitering
        n--;
        // shrink size of array if necessary
        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    } // remove and return a random item
    public Item sample() {Item item = null; return item;} // return a random item (but not remove it)
    public Iterator<Item> iterator() {return null;} // return an independent iterator over items in random order
    public static void main(String [] args) {
        StdOut.println("hello world from randomized queue");
    } // unit testing (optional)

}
