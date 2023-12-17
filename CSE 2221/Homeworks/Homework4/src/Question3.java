import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,2.0)
 * interval that fall in radius of the circle.
 *
 * @author Arun Ghimire
 *
 */
public final class Question3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Question3() {
    }

    /**
     * Checks whether the given point (xCoord, yCoord) is inside the circle of
     * radius 1.0 centered at the point (1.0, 1.0).
     *
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     * @return true if the point is inside the circle, false otherwise
     */
    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        boolean flag = false;
        final int circleRadius = 1;
        double distance = Math.sqrt(
                (1 - xCoord) * (1 - xCoord) + (1 - yCoord) * (1 - yCoord));
        if (distance <= circleRadius) {
            flag = true;
        }
        return flag;
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
        int points = 0;
        int i = 0;
        while (i < n) {
            double x = (rnd.nextDouble() * 2);
            double y = (rnd.nextDouble() * 2);

            if (pointIsInCircle(x, y)) {
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
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        output.print("Number of points: ");
        int n = input.nextInteger();
        final int squareArea = 4;

        double estimate = (100.0 * numberOfPointsInCircle(n)) / n;
        output.println("Estimate of percentage: " + estimate + "%");

        double dartArea = estimate * squareArea;
        output.println("Estimate of area hit: " + dartArea / 100.0);

        input.close();
        output.close();
    }

}
