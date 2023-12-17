import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Arun Ghimrie
 *
 */
public final class Hailstone1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int starterNum = n;

        while (starterNum > 1) {
            out.print(starterNum + ", ");

            if (starterNum % 2 == 0) {
                starterNum = starterNum / 2;
            } else {
                starterNum = 3 * starterNum + 1;
            }
        }
        out.println(1);
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

        out.print("Enter a number greater than 0 to start the series: ");
        int userNum = in.nextInteger();
        generateSeries(userNum, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
