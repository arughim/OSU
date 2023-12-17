import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack2;

/**
 * Answers for homework 19.
 *
 * @author Arun Ghimire
 *
 */

public final class Homework19Stack extends Stack2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework19Stack() {
    }

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    @Override
    public void flip() {
        Stack<String> st = this.newInstance();

        for (String element : st) {
            st.push(element);
        }
        this.transferFrom(st);
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

        Stack<String> st = new Stack2<String>();

        st.push("one");
        st.push("two");
        st.push("three");
        st.push("four");
        st.push("five");

        out.println(st);
        st.flip();
        out.println(st);

        in.close();
        out.close();
    }

}
