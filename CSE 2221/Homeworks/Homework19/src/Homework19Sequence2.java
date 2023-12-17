import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Answers for homework 19.
 *
 * @author Arun Ghimire
 *
 */

public final class Homework19Sequence2 extends Sequence1L {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework19Sequence2() {
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    @Override
    public void flip() {
        Sequence sq = this.newInstance();

        if (this.length() > 0) {
            Object element = this.remove(0);
            this.flip();
            this.add(0, element);
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

        Sequence sq = new Sequence1L();

        sq.add(0, "one");
        sq.add(1, "two");
        sq.add(2, "three");
        sq.add(3, "four");
        sq.add(4, "five");

        out.println(sq);
        sq.flip();
        out.println(sq);

        in.close();
        out.close();
    }

}
