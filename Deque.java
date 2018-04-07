/**
 * Created by tsaidani on 10/02/2018.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;


public class Deque<Item> implements Iterable<Item> {
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;

    }
    private Node<Item> first;
    private Node<Item> last;
    private int n;
    public Deque() {
        first = null;
        last = null;
        n = 0;
    }                           // construct an empty deque
    public boolean isEmpty() {return n == 0;}                 // is the deque empty?
    public int size() { return n;}                        // return the number of items on the deque
    public void addFirst(Item item) {
        if(item == null) {
            throw new java.lang.IllegalArgumentException("argument must be non null");
        }
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        if(isEmpty()) {
            first.next = null;
            first.prev = null;
            last = first;
        }
        else {
            oldfirst.prev = first;
            first.next = oldfirst;
        }
        n++;
    }          // add the item to the front
    public void addLast(Item item) {
        if(item == null) {
            throw new java.lang.IllegalArgumentException("argument must be non null");
        }
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;

        if(isEmpty()) {
            last.next = null;
            last.prev = null;
            first = last;

        }
        else {
            oldlast.next = last;
            last.prev = oldlast;
        }
        n++;
    }          // add the item to the end
    public Item removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException("Deque underflow");
        }
        Node<Item> oldfirst = first;
        Item ret = first.item;
        first = first.next;
        first.prev = null;
        oldfirst = null;
        n--;
        return ret;
    }               // remove and return the item from the front
    public Item removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("Deque underflow");
        }
        Node<Item> oldlast = last;
        Item ret = last.item;
        last = last.prev;
        oldlast = null;
        n--;
        return ret;
    }                // remove and return the item from the end
    public Iterator<Item> iterator() { return new ListIterator(); }        // return an iterator over items in order from front to end
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
    public static void main(String[] args)
    {
        StdOut.println("hello world it's Dequeue class");
        Deque<String> dq = new Deque<String>();

        dq.addFirst("1");
        dq.addFirst("2");
        dq.addLast("3");
        dq.addLast("4");

        for(String s: dq) {
            StdOut.println(s);
        }

        StdOut.println("dq size is:"+dq.size());

        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeFirst());
        StdOut.println(dq.removeLast());
        StdOut.println(dq.removeLast());
        //StdOut.println(dq.removeLast());

        dq.addLast(null);





    }// unit testing (optional)
}
