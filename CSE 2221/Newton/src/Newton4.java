import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A simple program that calculates the square root of a number entered by the
 * user within a certain relative error which is also provided by the user. As
 * long as all the inputs are positive, the program will repeatedly compute the
 * next root until a negative input. This iteration of the program takes a
 * negative input as a queue to end the program.
 *
 * @author Arun Ghimire
 *
 */
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     *
     * @param epsilon
     *            positive number representing margin of error to calculate the
     *            root within
     * @return estimate of square root
     *
     */
    private static double sqrt(double x, double epsilon) {
        double r = x;
        double guess = (r + x / r) / 2;
        while (Math.abs((guess * guess - r) / r) > epsilon * epsilon) {
            guess = (r / guess + guess) / 2;
        }
        return guess;
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
            out.print("Enter a positive number: ");
            double n = in.nextDouble();

            if (Double.compare(n, 0) == 0) {
                out.println("The square root of 0 is 0");
            } else if (Double.compare(n, 0) < 0) {
                repeat = false;
            } else {
                out.print("Enter the epsilon: ");
                double epsilon = in.nextDouble();
                out.println(
                        "The square root of " + n + " is " + sqrt(n, epsilon));
            }
        }

        in.close();
        out.close();
    }

}
