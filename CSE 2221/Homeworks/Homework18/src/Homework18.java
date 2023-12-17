import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Answers for homework 18.
 *
 * @author Arun Ghimire
 *
 */

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.compareTo(s2) < 0) {
            return 1;
        } else if (s1.compareTo(s2) > 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

/**
 *
 */
public final class Homework18 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework18() {
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * perms(q * <removeMin>, #q)  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {

        String min = "";
        int i = 0;
        while (i < q.length()) {
            String current = q.dequeue();
            if (order.compare(current, min) <= 0) {
                min = current;

            }
            q.enqueue(current);
            i++;
        }

        Queue<String> temp = q.newInstance();

        while (q.length() != 0) {
            String current = q.dequeue();
            if (!current.equals(min)) {
                temp.enqueue(current);
            }
        }
        q.transferFrom(temp);
        return min;
    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [#q ordered by the relation computed by order.compare]
     */
    public static void sort(Queue<String> q, Comparator<String> order) {
        if (q.length() != 0) {
            String str = removeMin(q, order);
            sort(q, order);
            q.enqueue(str);
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        Queue<String> q = new Queue1L<String>();
        StringComparator comp = new StringComparator();

        q.enqueue("black");
        q.enqueue("blue");
        q.enqueue("white");
        q.enqueue("green");
        q.enqueue("yellow");
        q.enqueue("blue");
        q.enqueue("green");

        out.println(q);
        out.println("Min: " + removeMin(q, comp));
        out.println(q);
        sort(q, comp);
        out.println(q);

        in.close();
        out.close();
    }

}
