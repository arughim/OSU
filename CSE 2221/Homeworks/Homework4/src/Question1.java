import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This is the solution to question #1.
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
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.println("Enter the X Coordinate: ");
        double x = in.nextDouble();
        out.println("Enter the Y Coordinate: ");
        double y = in.nextDouble();

        out.println(pointIsInCircle(x, y));

        in.close();
        out.close();
    }

}
