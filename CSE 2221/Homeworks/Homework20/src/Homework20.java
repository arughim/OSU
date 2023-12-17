import components.map.Map;
import components.map.Map1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Answers for homework 20.
 *
 * @author Arun Ghimire
 *
 */
public final class Homework20 {
    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework20() {
    }

    /**
     * Inputs a "menu" of words (items) and their prices from the given file and
     * stores them in the given {@code Map}.
     *
     * @param fileName
     *            the name of the input file
     * @param priceMap
     *            the word -> price map
     * @replaces priceMap
     * @requires <pre>
     * [file named fileName exists but is not open, and has the
     *  format of one "word" (unique in the file) and one price (in cents)
     *  per line, with word and price separated by ','; the "word" may
     *  contain whitespace but no ',']
     * </pre>
     * @ensures [priceMap contains word -> price mapping from file fileName]
     */
    private static void getPriceMap(String fileName,
            Map<String, Integer> priceMap) {
        SimpleReader file = new SimpleReader1L(fileName);

        while (!file.atEOS()) {
            String line = file.nextLine();
            String name = line.substring(0, line.indexOf(","));
            String price = line.substring(line.indexOf(",") + 1, line.length());

            priceMap.add(name, Integer.parseInt(price));
        }
        file.close();
    }

    /**
     * Input one pizza order and compute and return the total price.
     *
     * @param input
     *            the input stream
     * @param sizePriceMap
     *            the size -> price map
     * @param toppingPriceMap
     *            the topping -> price map
     * @return the total price (in cents)
     * @updates input
     * @requires <pre>
     * input.is_open and
     * [input.content begins with a pizza order consisting of a size
     *  (something defined in sizePriceMap) on the first line, followed
     *  by zero or more toppings (something defined in toppingPriceMap)
     *  each on a separate line, followed by an empty line]
     * </pre>
     * @ensures <pre>
     * input.is_open and
     * #input.content = [one pizza order (as described
     *              in the requires clause)] * input.content and
     * getOneOrder = [total price (in cents) of that pizza order]
     * </pre>
     */
    private static int getOneOrder(SimpleReader input,
            Map<String, Integer> sizePriceMap,
            Map<String, Integer> toppingPriceMap) {

        int total = 0;
        boolean loop = true;
        while (!input.atEOS() && loop) {
            String line = input.nextLine();
            if (line.isEmpty()) {
                loop = false;
            } else {
                if (sizePriceMap.hasKey(line)) {
                    int sizePrice = sizePriceMap.value(line);
                    total += sizePrice;
                }
                if (toppingPriceMap.hasKey(line)) {
                    int toppingPrice = toppingPriceMap.value(line);
                    total += toppingPrice;
                }
            }

        }
        System.out.println(total);
        return total;
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

        String sizeFileName = "https://web.cse.ohio-state.edu/software/2221/web-sw1/extras/instructions/pizza-orders/sizes.txt";
        String toppingFileName = "https://web.cse.ohio-state.edu/software/2221/web-sw1/extras/instructions/pizza-orders/toppings.txt";
        String orderFileName = "https://web.cse.ohio-state.edu/software/2221/web-sw1/extras/instructions/pizza-orders/orders.txt";

        Map<String, Integer> sizePriceMap = new Map1L<>();
        Map<String, Integer> toppingPriceMap = new Map1L<>();

        getPriceMap(sizeFileName, sizePriceMap);
        getPriceMap(toppingFileName, toppingPriceMap);

        SimpleReader input = new SimpleReader1L(orderFileName);
        getOneOrder(input, sizePriceMap, toppingPriceMap);

        in.close();
        out.close();
    }

}
