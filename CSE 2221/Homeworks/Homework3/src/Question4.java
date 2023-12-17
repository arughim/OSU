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

        out.print("Enter a number to estimate PI: ");
        int num = in.nextInteger();
        double est = 0.0;
        int p = 0;
        while (p < num) {
            est = est + Math.pow(-1, p) / (2 * p + 1);
            p++;
        }
        out.print("PI Estimate: " + est * 4);

        in.close();
        out.close();
    }

}
