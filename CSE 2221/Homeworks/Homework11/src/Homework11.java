import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Answers for homework 11.
 *
 * @author Arun Ghimire (ghimire.36)
 *
 */
public final class Homework11 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework11() {
    }

    /**
     * Returns {@code n} to the power {@code p}.
     *
     * @param n
     *            the number to which we want to apply the power
     * @param p
     *            the power
     * @return the number to the power
     * @requires Integer.MIN_VALUE <= n ^ (p) <= Integer.MAX_VALUE and p >= 0
     * @ensures power = n ^ (p)
     */
    private static int power(int n, int p) {
        int pow = 1;
        pow = (int) Math.pow(n, p);
        return pow;
    }

    /**
     * Returns the {@code r}-th root of {@code n}.
     *
     * @param n
     *            the number to which we want to apply the root
     * @param r
     *            the root
     * @return the root of the number
     * @requires n >= 0 and r > 0
     * @ensures root ^ (r) <= n < (root + 1) ^ (r)
     */
    private static int root(int n, int r) {
        int lowEnough = 0;
        int tooHigh = n + 1;
        while (tooHigh - lowEnough > 1) {
            int guess = (lowEnough + tooHigh) / 2;
            int pow = power(guess, r);
            if (pow <= n) {
                lowEnough = guess;
            } else {
                tooHigh = guess;
            }
        }
        return lowEnough;
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

        out.print("Enter n for root: ");
        int n = in.nextInteger();
        out.print("Enter r for root: ");
        int r = in.nextInteger();
        out.println(root(n, r));

        in.close();
        out.close();
    }

}
