import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A simple program that calculates change into denominations using arrays.
 *
 * @author Arun Ghimire
 *
 */
public final class CoinChange2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange2() {
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

        out.print("Enter change in cents: ");
        int change = in.nextInteger();

        String[] valueNames = { "Dollars: ", "Half Dollars: ", "Quarters: ",
                "Dimes: ", "Nickels: ", "Cents: " };
        final int[] values = { 100, 50, 25, 10, 5, 1 };
        int[] money = { 0, 0, 0, 0, 0, 0 };

        int i = 0;
        while (i < values.length) {
            money[i] = change / values[i];
            change = change % values[i];
            out.println(valueNames[i] + money[i]);
            i++;
        }
        in.close();
        out.close();
    }

}
