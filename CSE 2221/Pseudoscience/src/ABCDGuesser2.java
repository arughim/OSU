import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 *
 * This Java program approximates a given number "μ" using four parameters from
 * the deJager numbers ("a," "b," "c," and "d") and four user-provided values
 * ("w," "x," "y," and "z"). It finds the best parameter values to minimize the
 * error between the approximation and "μ".
 *
 * @author Arun Ghimire
 *
 */
public final class ABCDGuesser2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        double num = 0.0;
        boolean repeat = true;

        while (repeat) {
            out.print("Enter a positive real number: ");
            String input = in.nextLine();

            if (FormatChecker.canParseDouble(input)) {
                num = Double.parseDouble(input);
                if ((Double.compare(num, 0) < 1)) {
                    out.print("Try again! ");
                } else {
                    repeat = false;
                }
            }
        }
        return num;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */

    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        double num = 0.0;
        boolean repeat = true;

        while (repeat) {
            out.print("Enter a positive real number greater than 1: ");
            String input = in.nextLine();
            if (FormatChecker.canParseDouble(input)) {
                num = Double.parseDouble(input);
                if ((Double.compare(num, 1) < 1)) {
                    out.print("Try again! ");
                } else {
                    repeat = false;
                }
            }
        }
        return num;
    }

    /**
     * Computes a best estimate using the deJager method, a number closest to mu
     * that is provided by the user.
     *
     * @param muInput
     *            value to get close as possible to through the program
     * @param wInput
     *            personal value w input by the user
     * @param xInput
     *            personal value x input by the user
     * @param yInput
     *            personal value y input by the user
     * @param zInput
     *            personal value z input by the user
     * @param out
     *            the output stream
     */
    private static void deJagerCalculation(double muInput, double wInput,
            double xInput, double yInput, double zInput, SimpleWriter out) {

        double mu = muInput;
        double w = wInput;
        double x = xInput;
        double y = yInput;
        double z = zInput;

        double a = 0.0, b = 0.0, c = 0.0, d = 0.0;
        double bestA = 0.0, bestB = 0.0, bestC = 0.0, bestD = 0.0;
        double estimate = 0.0;
        double bestEstimate = 0.0;
        double error = 0.0;
        double bestError = Double.MAX_VALUE;

        final double[] deJager = { -5.0, -4, 0, -3.0, -2.0, -1, (-1.0 / 2.0),
                (-1.0 / 3.0), (-1.0 / 4.0), 0, (-1 / 4), (1.0 / 3.0),
                (1.0 / 2.0), 1.0, 2.0, 3.0, 4.0, 5.0 };

        for (int aIndex = 0; aIndex < deJager.length; aIndex++) {
            for (int bIndex = 0; bIndex < deJager.length; bIndex++) {
                for (int cIndex = 0; cIndex < deJager.length; cIndex++) {
                    for (int dIndex = 0; dIndex < deJager.length; dIndex++) {
                        a = deJager[aIndex];
                        b = deJager[bIndex];
                        c = deJager[cIndex];
                        d = deJager[dIndex];

                        estimate = Math.pow(w, a) * Math.pow(x, b)
                                * Math.pow(y, c) * Math.pow(z, d);
                        error = Math.abs(estimate - mu);

                        if (error < bestError) {
                            bestError = error;
                            bestEstimate = estimate;
                            bestA = a;
                            bestB = b;
                            bestC = c;
                            bestD = d;
                        }
                    }
                }
            }
        }

        out.println();
        out.println("Best Estimate: " + bestEstimate);
        out.println("Best a: " + bestA);
        out.println("Best b: " + bestB);
        out.println("Best c: " + bestC);
        out.println("Best d: " + bestD);

        double relativeError = Math.abs(bestError / mu) * 100.0;
        out.println("Relative Error: " + relativeError + "%");
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

        out.print("For μ to approximate - ");
        double mu = getPositiveDouble(in, out);
        out.print("For personal number W - ");
        double w = getPositiveDoubleNotOne(in, out);
        out.print("For personal number X: ");
        double x = getPositiveDoubleNotOne(in, out);
        out.print("For personal number Y: ");
        double y = getPositiveDoubleNotOne(in, out);
        out.print("For personal number Z: ");
        double z = getPositiveDoubleNotOne(in, out);

        deJagerCalculation(mu, w, x, y, z, out);

        in.close();
        out.close();
    }

}
