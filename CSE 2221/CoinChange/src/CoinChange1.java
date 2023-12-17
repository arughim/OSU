import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A simple program that calculates change into denominations.
 *
 * @author Arun Ghimire
 *
 */
public final class CoinChange1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange1() {
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

        out.print("Enter change ins cents: ");
        int change = in.nextInteger();

        final int dollar = 100, halfDollar = 50, quarter = 25, dime = 10,
                nickel = 5;

        int cents = 0;
        int rDollar = change / dollar;
        cents = change % dollar;
        int rHalfDollar = cents / halfDollar;
        cents = cents % halfDollar;
        int rQuarter = cents / quarter;
        cents = cents % quarter;
        int rDime = cents / dime;
        cents = cents % dime;
        int rNickel = cents / nickel;
        cents = cents % nickel;

        out.println("Dollars: " + rDollar);
        out.println("Half Dollars: " + rHalfDollar);
        out.println("Quarters: " + rQuarter);
        out.println("Dime: " + rDime);
        out.println("Nickel: " + rNickel);
        out.println("Cents: " + cents);

        in.close();
        out.close();
    }

}
