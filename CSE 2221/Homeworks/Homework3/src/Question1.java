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
public final class Question1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Question1() {
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
        out.print("Enter n: ");
        int n = in.nextInteger();

        int i = 0;
        out.print("Squares: ");
        while (i * i < n) {
            out.print(i * i + " ");
            i++;
        }

        out.println();
        int j = 1;
        out.print("Tens: ");
        while (j < n) {
            final int ten = 10;
            if (j % ten == 0) {
                out.print(j + " ");
            }
            j++;
        }

        out.println();
        int k = 1;
        out.print("Powers: ");
        while (Math.pow(2, k) < n) {
            out.print(Math.pow(2, k) + " ");
            k++;
        }
        in.close();
        out.close();
    }

}
