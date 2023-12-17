import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Debugging program.
 *
 * @author Arun Ghimire
 */
public final class Debugging4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Debugging4() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println(12345 + 5432l);
        out.close();
    }

}
