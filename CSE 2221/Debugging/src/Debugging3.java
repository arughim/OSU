import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple Debugging program.
 *
 * @author Arun Ghimire
 */
public final class Debugging3 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Debugging3() {
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
        final int microsPerDay = 24 * 60 * 60 * 1000 * 1000;
        final int millisPerDay = 24 * 60 * 60 * 1000;
        out.println(microsPerDay / millisPerDay);
        out.close();
    }

}
