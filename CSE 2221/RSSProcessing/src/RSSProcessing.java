import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * This program inputs an XML RSS (version 2.0) feed from a given URL and
 * outputs various elements of the feed to the console.
 *
 * @author Arun Ghimire
 *
 */
public final class RSSProcessing {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSProcessing() {
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of the {@code XMLTree} matching the
     *         given tag or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures <pre>
     * getChildElement =
     *  [the index of the first child of the {@code XMLTree} matching the
     *   given tag or -1 if not found]
     * </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";

        boolean search = true;
        int child = -1;
        int i = 0;
        if (xml.isTag()) {
            while (i < xml.numberOfChildren() && search) {
                if (xml.child(i).label().equals(tag)) {
                    child = i;
                    search = false;
                }
                i++;
            }
        }
        return child;
    }

    /**
     * Processes one news item and outputs the title, or the description if the
     * title is not present, and the link (if available) with appropriate
     * labels.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @requires [the label of the root of item is an <item> tag] and
     *           out.is_open
     * @ensures out.content = #out.content * [the title (or description) and
     *          link]
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item")
                : "" + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        int titleIndex = getChildElement(item, "title");
        int descriptionIndex = getChildElement(item, "description");
        int linkIndex = getChildElement(item, "link");

        if (titleIndex != -1) {
            out.println("Title: " + item.child(titleIndex).child(0));
        }
        if (descriptionIndex != -1) {
            out.println("Title: " + item.child(descriptionIndex).child(0));
        }
        if (linkIndex != -1) {
            out.println("Link: " + item.child(linkIndex).child(0));
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter the URL of an RSS 2.0 news feed: ");
        String url = in.nextLine();

        XMLTree xml = new XMLTree1(url);
        XMLTree channel = xml.child(0);

        int titleIndex = getChildElement(channel, "title");
        int descriptionIndex = getChildElement(channel, "description");
        int linkIndex = getChildElement(channel, "link");
        out.println("Channel Title: " + channel.child(titleIndex).child(0));
        out.println("Channel Link: " + channel.child(linkIndex).child(0));
        out.println("Channel Description: "
                + channel.child(descriptionIndex).child(0));

        out.println();
        int j = 0;
        while (j < channel.numberOfChildren()) {
            if (channel.child(j).label().equals("item")) {
                XMLTree item = channel.child(j);
                processItem(item, out);
                out.println();
            }
            j++;
        }

        in.close();
        out.close();
    }

}