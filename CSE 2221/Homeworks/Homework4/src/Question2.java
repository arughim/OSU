import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A Simple program that generates a given number of x and y coordinates and
 * checks if they are within a circle of radius 1.0 centered at the point (1.0,
 * 1.0).
 *
 * @author Arun Ghimire
 *
 */
public final class Question2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Question2() {
    }

    /**
     * Generates n pseudo-random points in the [0.0,2.0) x [0.0,2.0) square and
     * returns the number that fall in the circle of radius 1.0 centered at the
     * point (1.0, 1.0).
     *
     * @param n
     *            the number of points to generate
     * @return the number of points that fall in the circle
     */
    private static int numberOfPointsInCircle(int n) {

        Random rnd = new Random1L();
        final int circleRadius = 1;

        int points = 0;
        int i = 0;
        while (i < n) {
            double x = (rnd.nextDouble() * 2);
            double y = (rnd.nextDouble() * 2);

            double distance = Math.sqrt((1 - x) * (1 - x) + (1 - y) * (1 - y));
            if (distance <= circleRadius) {
                points++;
            }
            i++;
        }

        return points;
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

        out.print("Enter n: ");
        int n = in.nextInteger();

        out.println(
                numberOfPointsInCircle(n) + " points fall within the circle");

        in.close();
        out.close();
    }

}
