import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Homework 5 question #6.
 *
 * @author Arun Ghimire (ghimire.36)
 */
public final class Question6 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Question6() {
    }

    //Question 6a
    boolean allTheSame(int x, int y, int z) {
        boolean flag = false;
        if (x == y && y == z) {
            flag = true;
        }
        return flag;
    }

    //Question 6b
    boolean allDifferent(int x, int y, int z) {
        boolean flag = false;
        if (x != y && y != z) {
            flag = true;
        }
        return flag;
    }

    //Question 6c
    boolean sorted(int x, int y, int z) {
        boolean flag = false;
        if (x < y && y < z) {
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

        out.println();
        in.close();
        out.close();
    }

}
