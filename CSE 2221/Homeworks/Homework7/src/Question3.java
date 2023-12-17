import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 7 question #3.
 *
 * @author Arun Ghimire.
 *
 */
public final class Question3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Question3() {
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
        int min = a[0];
        int max = a[0];
        int i = 0;
        while (i < a.length) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
            i++;
        }
        out.println(min);
        out.println(max);

        in.close();
        out.close();
    }

}
