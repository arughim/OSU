import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
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
public final class Hailstone1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone1() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        NaturalNumber num = new NaturalNumber2();
        num.copyFrom(n);

        NaturalNumber zero = new NaturalNumber2(0);
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(2);

        while (!num.equals(one)) {
            out.print(num + ", ");
            NaturalNumber check = new NaturalNumber2();
            check.copyFrom(num);
            if (check.divide(two).equals(zero)) {
                NaturalNumber temp = new NaturalNumber2();
                temp.copyFrom(num);

                temp = num.divide(two);

            } else {
                NaturalNumber three = new NaturalNumber2(3);
                num.multiply(three);
                num.increment();
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

        out.print("Enter natural number to start the series: ");
        NaturalNumber n = new NaturalNumber2(in.nextInteger());
        generateSeries(n, out);

        in.close();
        out.close();
    }

}
