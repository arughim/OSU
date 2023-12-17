import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A simple program that checks the validity of a password entered by the user
 * based on.
 *
 * @author Arun Ghimire
 *
 */
public final class CheckPassword {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CheckPassword() {
    }

    /**
     * Checks if the given String contains a digit.
     *
     * @param str
     *            the String to check
     * @return true if str contains a digit, false otherwise
     */
    private static boolean containsDigit(String str) {
        boolean flag = false;
        int i = 0;
        while (i < str.length()) {
            char letter = str.charAt(i);
            if (Character.isDigit(letter)) {
                flag = true;
            }
            i++;
        }
        return flag;
    }

    /**
     * Checks if the given String contains a lowers case letter.
     *
     * @param str
     *            the String to check
     * @return true if str contains a lower case letter, false otherwise
     */
    private static boolean containsLowerCaseLetter(String str) {
        boolean flag = false;
        int i = 0;
        while (i < str.length()) {
            char letter = str.charAt(i);
            if (Character.isLowerCase(letter)) {
                flag = true;
            }
            i++;
        }
        return flag;
    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param str
     *            the String to check
     * @return true if str contains an upper case letter, false otherwise
     */
    private static boolean containsUpperCaseLetter(String str) {
        boolean flag = false;

        int i = 0;
        while (i < str.length()) {
            char letter = str.charAt(i);
            if (Character.isUpperCase(letter)) {
                flag = true;
            }
            i++;
        }
        return flag;
    }

    /**
     * Checks whether the given String satisfies the OSU criteria for a valid
     * password. Prints an appropriate message to the given output stream.
     *
     * @param passwordCandidate
     *            the String to check
     * @param out
     *            the output stream
     */
    private static void checkPassword(String passwordCandidate,
            SimpleWriter out) {

        String password = passwordCandidate;
        final int requiredLength = 8;

        if (password.length() >= requiredLength) {
            out.println("Password Length: satisfied");
            out.println(
                    "Contains Uppercase: " + containsUpperCaseLetter(password));
            out.println(
                    "Contains Lowercase: " + containsLowerCaseLetter(password));
            out.println("Contains Digit: " + containsDigit(password));

            int strength = 0;
            if (containsUpperCaseLetter(password)) {
                strength = strength + 1;
            }
            if (containsLowerCaseLetter(password)) {
                strength = strength + 1;
            }
            if (containsDigit(password)) {
                strength = strength + 1;
            }

            out.println();
            if (strength >= 2) {
                out.println("Valid Password");
            } else {
                out.println("Invalid Password");
            }

        } else {
            out.println("Password Length: invalid");
        }
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
        out.print("Please enter a password: ");
        String password = in.nextLine();

        checkPassword(password, out);

        in.close();
        out.close();
    }

}
