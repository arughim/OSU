import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    /**
     * Tests for Overlap
     */

    @Test
    public void testOverlap1() {
        String str1 = "abc";
        String str2 = "def";
        int expected = 0;
        int testResult = StringReassembly.overlap(str1, str2);
        assertEquals(expected, testResult);
    }

    @Test
    public void testOverlap2() {
        String str1 = "abc";
        String str2 = "cba";
        int expected = 1;
        int testResult = StringReassembly.overlap(str1, str2);
        System.out.print(testResult);
        assertEquals(expected, testResult);
    }

    @Test
    public void testOverlap3() {
        String str1 = "aaabbbbbbbbbbbbbbbbbbbbbbbbbbb";
        String str2 = "bbbbbbbbbbbbbbbbbbbbbbbbbbccc";
        int expected = 26;
        int testResult = StringReassembly.overlap(str1, str2);
        assertEquals(expected, testResult);
    }

    /**
     * Tests for combination
     */

    @Test
    public void testCombination1() {
        String str1 = "arunghimire";
        String str2 = "arunghimire";
        int overlap = 11;
        String expected = "arunghimire";
        String result = StringReassembly.combination(str1, str2, overlap);
        assertEquals(expected, result);
    }

    @Test
    public void testCombination2() {
        String str1 = "thunderbolt";
        String str2 = "boltaction";
        int overlap = 4;
        String expected = "thunderboltaction";
        String result = StringReassembly.combination(str1, str2, overlap);
        assertEquals(expected, result);
    }

    @Test
    public void testCombination3() {
        String str1 = "Airplane";
        String str2 = "plane";
        int overlap = 5;
        String expected = "Airplane";
        String result = StringReassembly.combination(str1, str2, overlap);
        assertEquals(expected, result);
    }

    /**
     * Tests for addToSetAvoidingSubstrings
     */

    @Test
    public void testAddToSetAvoidingSubstrings1() {
        Set<String> strset = new Set1L<String>();
        strset.add("hello");
        strset.add("world");
        Set<String> strset2 = new Set1L<String>();
        strset2.add("hello");
        strset2.add("world");
        String str = "play";
        StringReassembly.addToSetAvoidingSubstrings(strset, str);
        strset2.add(str);
        assertEquals(strset, strset2);
    }

    @Test
    public void testAddToSetAvoidingSubstrings2() {
        Set<String> strset = new Set1L<String>();
        strset.add("apple");
        strset.add("banana");
        Set<String> strset2 = new Set1L<String>();
        strset2.add("apple");
        strset2.add("banana");
        String str = "orange";
        StringReassembly.addToSetAvoidingSubstrings(strset, str);
        strset2.add(str);
        assertEquals(strset, strset2);
    }

    @Test
    public void testAddToSetAvoidingSubstrings3() {
        Set<String> strset = new Set1L<String>();
        strset.add("cat");
        strset.add("dog");
        Set<String> strset2 = new Set1L<String>();
        strset2.add("cat");
        strset2.add("dog");
        String str = "fish";
        StringReassembly.addToSetAvoidingSubstrings(strset, str);
        strset2.add(str);
        assertEquals(strset, strset2);
    }

    /**
     * Tests for printWithLineSeparators
     */
    @Test
    public void printWithLineSeparatorsTest1() {
        SimpleWriter out = new SimpleWriter1L();
        String test1 = " Heklo ~ There";
        StringReassembly.printWithLineSeparators(test1, out);
        out.close();
    }

    @Test
    public void printWithLineSeparatorsTest2() {
        SimpleWriter out = new SimpleWriter1L();
        String test1 = " ~~~My name~~~~~is Arun~~~Ghimire";
        StringReassembly.printWithLineSeparators(test1, out);
        out.close();
    }

    @Test
    public void printWithLineSeparatorsTest3() {
        SimpleWriter out = new SimpleWriter1L();
        String test1 = " ~~~~~~~~~~~~~~~~~~~~~~~I am currently~~~Attending OSU~~";
        StringReassembly.printWithLineSeparators(test1, out);
        out.close();
    }
}
