import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Homework 5 question #1.
 *
 * @author Arun Ghimrie
 *
 */
public final class Question1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Question1() {
    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static int getPositiveInteger(SimpleReader in, SimpleWriter out) {
        int number = 0;
        while (number < 1) {
            out.print("Enter a number greater than 0 to start the series: ");
            String input = in.nextLine();
            if (FormatChecker.canParseInt(input)) {
                number = Integer.parseInt(input);
            } else {
                out.println("Invalid Number");
                out.print("Please try Again: ");
            }
        }
        return number;
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
            int number = getPositiveInteger(in, out);
            generateSeries(number, out);

            out.print("Do you want to calculate another series?: ");
            String answer = in.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                repeat = false;
            }
        }

        in.close();
        out.close();
    }

}
