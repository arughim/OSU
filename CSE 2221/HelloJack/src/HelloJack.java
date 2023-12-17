import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This is a simple program that asks the user for their name and greets them.
 *
 * @author Arun Ghimire
 *
 */
public final class HelloJack {
    /**
     * No argument constructor--private to prevent instantiation.
     */
    private HelloJack() {
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

        out.print("Enter your name: ");
        String name = in.nextLine();

        out.println("Hello, " + name);

        in.close();
        out.close();
    }

}
