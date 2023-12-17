import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Answers to homework 15.
 *
 * @author Arun Ghimire
 *
 */
public final class Homework15 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework15() {
    }

    /**
     * Reports the smallest integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return the smallest integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * min is in entries(q) and
     * for all x: integer
     *     where (x is in entries(q))
     *   (min <= x)
     * </pre>
     */
    private static int min(Queue<Integer> q) {
        int min = 0;

        int i = 0;
        while (i < q.length()) {
            int digit = q.dequeue();
            if (digit < min) {
                min = digit;
            }
            q.enqueue(digit);
            i++;
        }
        System.out.println("Min: " + min);
        return min;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMax(Queue<Integer> q) {
        int min = q.front();
        int max = q.front();
        int[] ans = { min, max };

        int i = 0;
        while (i < q.length()) {
            int digit = q.dequeue();
            if (digit < min) {
                min = digit;
                ans[0] = min;
            }
            if (digit > max) {
                max = digit;
                ans[1] = max;
            }
            q.enqueue(digit);
            i++;
        }

        System.out.println("Min: " + ans[0] + ", Max: " + ans[1]);
        return ans;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMaxNoah(Queue<Integer> q) {
        int min = q.front();
        int max = q.front();
        int[] ans = { min, max };

        int i = 0;
        while (i < q.length()) {
            int digit = q.dequeue();
            if (ans[0] < digit) {
                ans[0] = digit;
            }
            if (ans[1] > digit) {
                ans[1] = digit;
            }
            q.enqueue(digit);
            i++;
        }
        System.out.println("Noah -> Min: " + ans[0] + ", Max: " + ans[1]);
        return ans;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        Queue<Integer> q = new Queue1L<Integer>();
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(1);
        q.enqueue(0);
        q.enqueue(-1);
        q.enqueue(-3);
        q.enqueue(-5);

        out.println(q);
        min(q);
        minAndMax(q);
        minAndMaxNoah(q);

        in.close();
        out.close();
    }

}
