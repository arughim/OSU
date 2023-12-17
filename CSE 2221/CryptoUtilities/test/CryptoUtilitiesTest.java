import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Arun Ghimire
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_9_12() {
        NaturalNumber n = new NaturalNumber2(9);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(12);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_2147483646_2() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE - 1);
        NaturalNumber nExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_2147483647_9123() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(9123);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_2147483648_2() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE + 1);
        NaturalNumber nExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    public void testIsEven_2() {
        NaturalNumber n = new NaturalNumber2(2);
        NaturalNumber nExpected = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_2147483646() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE - 1);
        NaturalNumber nExpected = new NaturalNumber2(Integer.MAX_VALUE - 1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_2147483647() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber nExpected = new NaturalNumber2(Integer.MAX_VALUE);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_2147483648() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE + 1);
        NaturalNumber nExpected = new NaturalNumber2(Integer.MAX_VALUE + 1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }
    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_12_12_12() {
        NaturalNumber n = new NaturalNumber2(12);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(12);
        NaturalNumber pExpected = new NaturalNumber2(12);
        NaturalNumber m = new NaturalNumber2(12);
        NaturalNumber mExpected = new NaturalNumber2(12);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_10_2_3() {
        NaturalNumber n = new NaturalNumber2(10);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber pExpected = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(3);
        NaturalNumber mExpected = new NaturalNumber2(3);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_6_3_5() {
        NaturalNumber n = new NaturalNumber2(6);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(3);
        NaturalNumber pExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(5);
        NaturalNumber mExpected = new NaturalNumber2(5);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_2147483647() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(1);
        NaturalNumber pExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber mExpected = new NaturalNumber2(Integer.MAX_VALUE);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of witnessToCompositness
     */

    @Test
    public void testCompositeWitness_6_3() {
        NaturalNumber n = new NaturalNumber2(6);
        NaturalNumber w = new NaturalNumber2(3);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void testCompositeWitness_7_2() {
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber w = new NaturalNumber2(2);
        assertTrue(!CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void testCompositeWitness_15_2() {
        NaturalNumber n = new NaturalNumber2(15);
        NaturalNumber w = new NaturalNumber2(2);
        assertTrue(!CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void testCompositeWitness_100_30() {
        NaturalNumber n = new NaturalNumber2(100);
        NaturalNumber w = new NaturalNumber2(30);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void testCompositeWitness_2147483647_2() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        NaturalNumber w = new NaturalNumber2(2);
        assertTrue(!CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    @Test
    public void testCompositeWitness_2147483648_2() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE + 1);
        NaturalNumber w = new NaturalNumber2(2);
        assertTrue(CryptoUtilities.isWitnessToCompositeness(w, n));
    }

    /*
     * Tests of isPrime1
     */

    @Test
    public void isPrime1_2() {
        NaturalNumber n = new NaturalNumber2(2);
        assertTrue(CryptoUtilities.isPrime2(n));
    }

    @Test
    public void isPrime1_3() {
        NaturalNumber n = new NaturalNumber2(3);
        assertTrue(CryptoUtilities.isPrime2(n));
    }

    @Test
    public void isPrime1_4() {
        NaturalNumber n = new NaturalNumber2(4);
        assertTrue(!CryptoUtilities.isPrime2(n));
    }

    @Test
    public void isPrime1_2147483646() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE - 1);
        assertTrue(!CryptoUtilities.isPrime2(n));
    }

    @Test
    public void isPrime1_2147483647() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        assertTrue(CryptoUtilities.isPrime2(n));
    }

    @Test
    public void isPrime1_2147483648() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        assertTrue(!CryptoUtilities.isPrime2(n));
    }

    /*
     * Tests of isPrime2
     */

    @Test
    public void isPrime2_4() {
        NaturalNumber n = new NaturalNumber2(4);
        assertTrue(!CryptoUtilities.isPrime2(n));
    }

    @Test
    public void isPrime2_7() {
        NaturalNumber n = new NaturalNumber2(7);
        assertTrue(CryptoUtilities.isPrime2(n));
    }

    @Test
    public void isPrime2_99() {
        NaturalNumber n = new NaturalNumber2(99);
        assertTrue(!CryptoUtilities.isPrime2(n));

    }

    @Test
    public void isPrime2_2147483646() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE - 1);
        assertTrue(!CryptoUtilities.isPrime2(n));

    }

    @Test
    public void isPrime2_2147483647() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        assertTrue(CryptoUtilities.isPrime2(n));

    }

    @Test
    public void isPrime2_2147483648() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE + 1);
        assertTrue(!CryptoUtilities.isPrime2(n));

    }

    /*
     * Tests of generateNextLikelyPrime
     */

    @Test
    public void testGenerateNextLikelyToPrime_4() {
        NaturalNumber n = new NaturalNumber2(4);
        CryptoUtilities.generateNextLikelyPrime(n);
        NaturalNumber nExpected = new NaturalNumber2(5);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyToPrime_6() {
        NaturalNumber n = new NaturalNumber2(6);
        CryptoUtilities.generateNextLikelyPrime(n);
        NaturalNumber nExpected = new NaturalNumber2(7);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyToPrime_74() {
        NaturalNumber n = new NaturalNumber2(74);
        CryptoUtilities.generateNextLikelyPrime(n);
        NaturalNumber nExpected = new NaturalNumber2(79);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyToPrime_2147483646() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE - 1);
        CryptoUtilities.generateNextLikelyPrime(n);
        NaturalNumber nExpected = new NaturalNumber2(2147483647);
        assertEquals(nExpected, n);
    }

    @Test
    public void testGenerateNextLikelyToPrime_2147483647() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("2147483659", n.toString());
    }

    @Test
    public void testGenerateNextLikelyToPrime_2147483648() {
        NaturalNumber n = new NaturalNumber2(Integer.MAX_VALUE + 1);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("2147483659", n.toString());
    }
}
