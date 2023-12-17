import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Answers to Homework 13.
 *
 * @author Arun Ghimire
 *
 */
public final class Homework13 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework13() {
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        NaturalNumber result = new NaturalNumber2(1);
        if (!n.isZero()) {
            NaturalNumber temp = new NaturalNumber2(1);
            temp.copyFrom(n);
            NaturalNumber digit = new NaturalNumber2(temp.divideBy10());
            digit.multiply(productOfDigits1(temp));
            result.copyFrom(digit);
        }
        System.out.println(result);
        n.clear();
        return result;
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {
        NaturalNumber result = new NaturalNumber2(1);
        if (!n.isZero()) {
            NaturalNumber temp = new NaturalNumber2(1);
            temp.copyFrom(n);
            int iDigit = temp.divideBy10();
            NaturalNumber digit = new NaturalNumber2(iDigit);
            digit.multiply(productOfDigits2(temp));
            result.copyFrom(digit);
        }
        System.out.println(result);
        return result;

    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {
        int number = 0;
        if (n.canConvertToInt() && !n.isZero()) {
            int digit = n.divideBy10();
            String num = "" + digit;
            number = Integer.valueOf(num);
            toInt(n);
            n.multiplyBy10(digit);
        }
        System.out.print(number);
        return number;
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree}, false
     *         otherwise
     * @ensures <pre>
     * findTag =
     *    [true if the given tag appears in the given {@code XMLTree}, false otherwise]
     * </pre>
     */
    private static boolean findTag(XMLTree xml, String tag) {
        boolean hasTag = false;
        if (xml.isTag() && xml.label().equals(tag)) {
            hasTag = true;
        }

        int i = 0;
        while (i < xml.numberOfChildren()) {
            XMLTree child = xml.child(i);
            if (findTag(child, tag)) {
                hasTag = true;
            }
        }
        System.out.println(hasTag);
        return hasTag;
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

        out.print("For product of digits 1, enter digits: ");
        NaturalNumber input1 = new NaturalNumber2(in.nextLine());
        productOfDigits1(input1);

        out.print("For product of digits, enter digits: ");
        NaturalNumber input2 = new NaturalNumber2(in.nextLine());
        productOfDigits2(input2);

        out.print("For to int, enter digits: ");
        NaturalNumber input3 = new NaturalNumber2(in.nextLine());
        toInt(input3);

        out.print("For to find tag, enter xml address: ");
        XMLTree input5 = new XMLTree1(in.nextLine());
        out.print("For to find tag, enter tag: ");
        String input6 = in.nextLine();
        findTag(input5, input6);

        in.close();
        out.close();
    }

}
