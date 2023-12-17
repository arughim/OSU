import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Arun Ghimire
 *
 */
public final class Question5 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Question5() {
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

        out.print("Enter a number to estimate PI: ");
        int areaBound = in.nextInteger();
        int sum = 0;
        int n = 1;
        int m = 1;
        while (n * n < areaBound) {
            while (m * m < areaBound) {
                sum = sum + n * n + m * m;
                m++;
            }
            n++;
        }

        in.close();
        out.close();
    }

}
