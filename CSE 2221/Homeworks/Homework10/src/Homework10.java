import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Answers for homework 10.
 *
 * @author Arun Ghimire
 *
 */
public final class Homework10 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework10() {
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("starting n1: " + n1);
        out.println("starting n1: " + n2);

        NaturalNumber temp = new NaturalNumber2();
        temp.copyFrom(n1);
        n1.copyFrom(n2);
        n2.copyFrom(temp);

        out.println("ending n1: " + n1);
        out.println("ending n2: " + n2);

        out.close();
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN2(NaturalNumber n1, NaturalNumber n2) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("starting number 1: " + n1);
        out.println("starting number 2: " + n2);

        NaturalNumber temp = new NaturalNumber2();
        temp.transferFrom(n1);
        n1.copyFrom(n2);
        n2.transferFrom(temp);

        out.println("ending n1: " + n1);
        out.println("ending n2: " + n2);

        out.close();
    }

    /**
     * Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        SimpleWriter out = new SimpleWriter1L();
        n.power(2);
        out.println("n squared is: " + n);
        out.close();
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

        //Question 1:
        out.println("FOR swapNN: ");
        out.print("Enter first number: ");
        NaturalNumber x = new NaturalNumber2(in.nextInteger());
        out.print("Enter second number: ");
        NaturalNumber y = new NaturalNumber2(in.nextInteger());
        swapNN(x, y);

        //Question 2:
        out.println("FOR swapNN2: ");
        out.print("Enter first number: ");
        NaturalNumber a = new NaturalNumber2(in.nextInteger());
        out.print("Enter second number: ");
        NaturalNumber b = new NaturalNumber2(in.nextInteger());
        swapNN2(a, b);

        //Question3:
        out.println("FOR square: ");
        out.print("Enter number to square: ");
        NaturalNumber s = new NaturalNumber2(in.nextInteger());
        square(s);

        in.close();
        out.close();
    }

}
