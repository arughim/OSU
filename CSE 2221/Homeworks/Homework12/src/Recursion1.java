import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Answer for homework 12.
 *
 * @author Arun Ghimire
 */
public final class Recursion1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Recursion1() {
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        int count = 0;
        if (!n.isZero()) {
            int digit = n.divideBy10();
            count = numberOfDigits(n);
            count++;
            n.multiplyBy10(digit);
        }
        return count;

    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        int sum = 0;
        if (!n.isZero()) {
            int digit = n.divideBy10();
            sum = digit + sumOfDigits(n);
            n.multiplyBy10(digit);
        }
        return sum;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigitsNN(NaturalNumber n) {
        NaturalNumber sum = new NaturalNumber2();

        if (!n.isZero()) {
            NaturalNumber digit = new NaturalNumber2(n.divideBy10());
            sum.copyFrom(digit);
            sum.add(sumOfDigitsNN(n));
            n.multiplyBy10(digit.toInt());
        }

        return sum;
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    private static void divideBy2(NaturalNumber n) {

    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        boolean flag = true;

        if (s.length() < 1) {
            flag = false;
        } else if (s.length() > 1) {
            char left = s.charAt(0);
            char right = s.charAt(s.length() - 1);

            String sub = s.substring(1, s.length() - 1);
            flag = isPalindrome(sub);

            if (left != right) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("For number of digits, enter digit: ");
        NaturalNumber n1 = new NaturalNumber2(in.nextInteger());
        int result1 = numberOfDigits(n1);
        out.println(result1);

        out.print("For sum of digits, enter digit: ");
        NaturalNumber n2 = new NaturalNumber2(in.nextInteger());
        int result2 = sumOfDigits(n2);
        out.println(result2);

        out.print("For sum of digits natural numbers, enter digit: ");
        NaturalNumber n3 = new NaturalNumber2(in.nextInteger());
        NaturalNumber result3 = new NaturalNumber2(sumOfDigitsNN(n3));
        out.println(result3);

        out.print("For divide by 2, enter digit: ");
        NaturalNumber n4 = new NaturalNumber2(in.nextInteger());
        divideBy2(n4);

        out.print("For palindrome check, enter string: ");
        String s1 = in.nextLine();
        boolean result5 = isPalindrome(s1);
        out.println(result5);

        in.close();
        out.close();

    }

}
