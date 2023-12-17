import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 7 question #4.
 *
 * @author Arun Ghimire
 *
 */
public final class Question4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Question4() {
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

        int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
        boolean isOrdered = false;
        int i = 0;
        while (i < a.length - 1) {
            if (a[i] < a[i + 1]) {
                isOrdered = false;
            }
            i++;
        }
        out.print(isOrdered);
        in.close();
        out.close();
    }

}
