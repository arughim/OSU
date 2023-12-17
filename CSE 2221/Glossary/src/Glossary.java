import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A simple program that reads text from a given input file that includes terms
 * and definitions. Then the program creates an HTML page for each term with the
 * definition below it.
 *
 * @author Arun Ghimire
 *
 */

public final class Glossary {

    /**
     * Compare {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Glossary() {
    }

    /**
     * Creates "dictionary" of terms and their definition from the given file
     * and stores them in the given {@code Map}.
     *
     * @param termsFile
     *            the name of the input file
     * @param dictionary
     *            the name of {@code Map}
     * @replaces dictionary
     * @requires <pre>
     *          [file named termsFile exists but is not open, and has the
     *           format of one "term" (unique in the file) in one line and one
     *           "definition" in the next line. The previous definition and the
     *           next term are separated by an empty line in the file. The
     *           "definition" may contain " ", or ",".] </pre>
     * @ensures [termsMap contains term and definition from file fileName]
     */
    private static void getTermsMap(String termsFile,
            Map<String, String> dictionary) {
        SimpleReader file = new SimpleReader1L(termsFile);

        String term = "";
        String definition = "";
        while (!file.atEOS()) {
            String line = file.nextLine();
            if (line.isEmpty()) {
                if (!term.isEmpty() && !definition.isEmpty()) {
                    dictionary.add(term, definition);
                    term = "";
                    definition = "";
                }

            } else {
                if (term.isEmpty()) {
                    term = line;
                } else {
                    definition += line + " ";
                }
            }
        }
        file.close();
    }

    /**
     * Creates a queue of terms retrieved from the given {@code Map}.
     *
     * @param dictionary
     *            the name of {@code Map}
     * @replaces terms
     * @requires <pre>
     *          [map named dictionary exists but is not open, and has the
     *           format of (key, value) as ("term", "definition)] </pre>
     * @return the queue containing "terms" generated from the keys of
     *         {@code Map}
     * @ensures[queue containing all of the keys of the map]
     */
    private static Queue<String> getTermsQueue(Map<String, String> dictionary) {
        Queue<String> terms = new Queue1L<String>();
        for (Map.Pair<String, String> element : dictionary) {
            terms.enqueue(element.key());
        }
        return terms;
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * perms(q * <removeMin>, #q)  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {
        assert q != null : "Violation of: q is not null";
        assert order != null : "Violation of: order is not null";

        String min = q.dequeue();
        int i = 0;
        while (i < q.length()) {
            String current = q.dequeue();
            if (order.compare(current, min) < 0) {
                q.enqueue(min);
                min = current;
            } else {
                q.enqueue(current);
            }
            i++;
        }
        return min;
    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [#q ordered by the relation computed by order.compare]
     */
    public static void sort(Queue<String> q, Comparator<String> order) {
        if (q.length() != 0) {
            String str = removeMin(q, order);
            sort(q, order);
            q.enqueue(str);
        }
    }

    /**
     * Processes the given definition by replacing occurrences of terms in the
     * provided queue with HTML links. Each term is replaced with a
     * case-insensitive link in the format <a href="term.html">term</a>.
     *
     * @param terms
     *            the queue of terms to be replaced
     * @param definition
     *            the definition string to be processed
     * @return the processed definition with terms replaced by HTML links
     * @ensures the processed definition contains HTML links for each term in
     *          the queue, replacing the corresponding occurrences in the
     *          original definition
     * @requires terms and definition are not null and terms appear in a sorted
     *           alphabetical order
     */
    private static String processDefinition(Queue<String> terms,
            String definition) {
        assert terms != null : "Violation of: terms is not null";
        assert definition != null : "Violation of: definition is not null";

        String processedDefinition = definition;
        String[] words = definition.split("\\W+");

        for (int i = 0; i < words.length; i++) {
            String word = words[i].trim();

            for (String term : terms) {
                if (word.equalsIgnoreCase(term)) {
                    String link = "<a href=\"" + term + ".html\">" + term
                            + "</a>";
                    word = word.replace(term, link);
                    processedDefinition = processedDefinition.replace(term,
                            word);
                }
            }
            words[i] = word;
        }
        return processedDefinition;
    }

    /**
     * Generates the HTML header for the given index page.
     *
     * @param indexPath
     *            The output stream.
     * @requires the output stream is not null
     *
     */
    public static void indexHeader(SimpleWriter indexPath) {
        assert indexPath != null : "Violation of: output stream is not null";

        indexPath.println("<html>");
        indexPath.println("<head>");
        indexPath.println("<title>Glossary</title>");
        indexPath.println("</head>");
        indexPath.println("<body>");
        indexPath.println("<h2>Glossary</h2>");
        indexPath.println("<hr>");
        indexPath.println("<h3>Index</h3>");
        indexPath.println("<ul>");
    }

    /**
     * Indexes the body content for each term in the provided terms queue and
     * writes corresponding HTML files. Generates an index file with links to
     * each term's HTML file.
     *
     * @param dictionary
     *            the map containing terms and definitions
     * @param terms
     *            the queue of terms to be indexed
     * @param indexPath
     *            the SimpleWriter for writing the index file
     * @param folderPath
     *            the folder path where HTML files will be generated
     * @requires dictionary, terms, indexPath, and folderPath are not null, and
     *           terms appear in a sorted alphabetical order
     * @ensures HTML files are generated for each term in the terms queue, and
     *          an index file is created with links to each term's HTML file
     */
    private static void indexBody(Map<String, String> dictionary,
            Queue<String> terms, SimpleWriter indexPath, String folderPath) {
        assert dictionary != null : "Violation of: output stream is not null";
        assert terms != null : "Violation of: output stream is not null";
        assert indexPath != null : "Violation of: output stream is not null";
        assert folderPath != null : "Violation of: output stream is not null";

        for (String element : terms) {
            String term = element;

            String fileName = term.toLowerCase().replace(" ", "_") + ".html";
            indexPath.println(
                    "  <li><a href='" + fileName + "'>" + term + "</a></li>");

            SimpleWriter termFile = new SimpleWriter1L(
                    folderPath + "/" + fileName);

            termFile.println("<html>");
            termFile.println("<head><title>");
            termFile.print(term);
            termFile.println("</title></head>");

            termFile.println("<body>");
            termFile.println("<h2><b><i><font color=\"red\">");
            termFile.print(term);
            termFile.println("</font></i></b></h2>");

            termFile.println("<blockquote>");

            String definition = dictionary.value(term);
            termFile.print(processDefinition(terms, definition));

            termFile.println("</blockquote>");

            termFile.println("<hr> ");
            termFile.println("<p> ");
            termFile.println("Return to");
            termFile.println("<a href='index.html'>index</a>" + ".");
            termFile.println("</p> ");
            termFile.println("</body>");
            termFile.println("</html>");
            termFile.close();
        }

    }

    /**
     * Generates the HTML header for the given index page.
     *
     * @param indexPath
     *            The output stream.
     * @requires the output stream is not null
     */
    private static void indexFooter(SimpleWriter indexPath) {
        assert indexPath != null : "Violation of: output stream is not null";

        indexPath.println("</ul>");
        indexPath.println("</body>");
        indexPath.println("</html>");
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
        Comparator<String> comp = new StringLT();

        out.println("Enter the address of the input file: ");
        String termsFile = in.nextLine();
        out.println("Enter the path of the output folder: ");
        String folderPath = in.nextLine();
        SimpleWriter indexPath = new SimpleWriter1L(folderPath + "/index.html");

        Map<String, String> dictionary = new Map1L<String, String>();
        Queue<String> terms = new Queue1L<String>();
        getTermsMap(termsFile, dictionary);
        terms.append(getTermsQueue(dictionary));
        terms.sort(comp);

        indexHeader(indexPath);
        indexBody(dictionary, terms, indexPath, folderPath);
        indexFooter(indexPath);

        in.close();
        out.close();
    }

}
