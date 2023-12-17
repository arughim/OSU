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
public final class Hailstone4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone4() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer while also counting the length of the series and keeping track of
     * the max value within the series.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int starterNum = n, length = 1, max = 0;

        while (starterNum > 1) {
            out.print(starterNum + ", ");

            if (starterNum % 2 == 0) {
                starterNum = starterNum / 2;
            } else {
                starterNum = 3 * starterNum + 1;
            }

            if (starterNum > max) {
                max = starterNum;
            }
            length++;
        }
        out.println(1);
        out.println("Series Length: " + length);
        out.println("Series Max: " + max);

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

        boolean repeat = true;
        while (repeat) {
            out.print("Enter a number greater than 0 to start the series: ");
            int userNum = in.nextInteger();
            generateSeries(userNum, out);

            out.print("Do you want to calculate another series?: ");
            String answer = in.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                repeat = false;
            }

        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
