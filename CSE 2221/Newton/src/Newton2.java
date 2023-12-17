import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A simple program that calculates the square root of a number entered by the
 * user within a certain relative error. After giving an answer, the program
 * repeatedly asks the user if they want to calculate a square again. The
 * program does not allow the input 0 to go through calculations, instead, it
 * just computes the result as 0.
 *
 * @author Arun Ghimire
 *
 */
public final class Newton2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r = x;
        final double epsilon = 0.01 * 0.01;
        double guess = (r + x / r) / 2;
        while (Math.abs((guess * guess - r) / r) > epsilon) {
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
        out.print("Do you want to calculate the root? ");
        String ans = in.nextLine();
        if (ans.equalsIgnoreCase("y")) {
            while (repeat) {
                out.print("Enter a positive number : ");
                double n = in.nextDouble();
                if (Double.compare(n, 0) == 0) {
                    out.println("The square root of 0 is 0");
                } else {
                    out.println("The square root of " + n + " is " + sqrt(n));
                }
                out.print("Do you want to calculate another root? ");
                String answer = in.nextLine();
                if (!answer.equalsIgnoreCase("y")) {
                    repeat = false;
                }
            }
        }
        in.close();
        out.close();
    }

}
