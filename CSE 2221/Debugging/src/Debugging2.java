import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Debugging program.
 *
 * @author Arun Ghimire
 */
public final class Debugging2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Debugging2() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        double x = 456.0;
        double y = 100.0 * 4.56;
        if (x == y) {
            out.println("equal");
        } else {
            out.println("not equal");
        }
        out.close();
    }

}
