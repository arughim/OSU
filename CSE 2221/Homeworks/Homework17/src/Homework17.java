import components.queue.Queue;
import components.queue.Queue1L;
import components.queue.Queue2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Answers for homework 17.
 *
 * @author Arun Ghimire
 */
public class Homework17<T> extends Queue2<T> {
    @Override
    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flip() {
        if (this.length() != 0) {
            int i = 0;
            while (i < this.length()) {
                T temp = this.dequeue();
                this.enqueue(temp);
                i++;
            }
        }
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @param q
     *            the queue
     * @param <T>
     *            the type of element entered in q
     * @updates q
     * @ensures q = rev(#q)
     */
    public static <T> void flip(Queue<T> q) {
        if (q.length() != 0) {
            T temp = q.dequeue();
            flip(q);
            q.enqueue(temp);
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

        Queue q = new Queue1L();
        q.enqueue(5);
        q.enqueue("three");
        q.enqueue(1.01);
        q.enqueue(0);
        q.enqueue(-1);
        q.enqueue(-3);
        q.enqueue(-5);

        out.println(q);
        q.flip();
        out.println(q);
        flip(q);
        out.println(q);

        in.close();
        out.close();
    }

}
