import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 5 question #3.
 *
 * @author Arun Ghimrie
 *
 */
public final class Question3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Question3() {
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

        //Question 3A
        int i = 0;
        int evenSum = 0;
        while (i <= 100) {
            if (i % 2 == 0) {
                evenSum += i;
            }
            i++;
        }
        out.println("Sum of all evens: " + evenSum);

        //Question 3B
        int j = 0;
        int sumSquare = 0;
        while (j * j <= 100) {
            sumSquare = sumSquare + (j * j);
            j++;
        }
        out.println("Sum of all squares: " + sumSquare);

        //Question 3C
        int k = 0;
        out.print("Powers of 2: ");
        while (k <= 20) {
            out.print(Math.pow(2, k) + " ");
            k++;
        }

        //Question 3D
        out.println();
        int a = 0;
        int b = 100;
        int oddSum = 0;
        while (a < b) {
            if (a % 2 != 0) {
                oddSum += a;
            }
            a++;
        }
        out.println("Sum of all odds: " + oddSum);

        //Question 3E
        int oddRightPositionSum = 0;
        int digit1 = 432677;
        while (digit1 != 0) {
            int number1 = (digit1 % 10);
            oddRightPositionSum += number1;
            digit1 = digit1 / 100;
        }
        out.println("Sum of all right odd position: " + oddRightPositionSum);

        //Question 3F
        int oddLeftPositionSum = 0;
        int digit2 = 432677;
        int temp1 = digit2;

        if (String.valueOf(temp1).length() % 2 == 0) {
            out.println("even");
            while (digit2 != 0) {
                digit2 = digit2 / 10;
                int number2 = digit2 % 10;
                digit2 = digit2 / 10;
                oddLeftPositionSum += number2;
                out.println(number2);
            }
        } else {
            while (digit2 != 0) {
                int number2 = digit2 % 10;
                oddLeftPositionSum += number2;
                digit2 = digit2 / 100;
                out.println(number2);
            }
        }
        out.println("Sum of all left odd position: " + oddLeftPositionSum);

        in.close();
        out.close();
    }
}
