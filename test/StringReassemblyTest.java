import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @author Jordyn Liegl
 */
public class StringReassemblyTest {

    /**
     * Tests of combination.
     */

    /**
     * challenging because there is no overlap.
     */

    @Test
    public void testCombination_HELLO_WORLD_0() {
        String str1 = "HELLO";
        String str1Expected = "HELLO";
        String str2 = "WORLD";
        String str2Expected = "WORLD";
        int i = 0;
        int iExpected = 0;
        String ansExpected = "HELLOWORLD";
        String ansActual = StringReassembly.combination(str1, str2, i);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(iExpected, i);
        assertEquals(ansExpected, ansActual);
    }

    /**
     * boundary because there is only one character overlap.
     */

    @Test
    public void testCombination_ABC_CDE_1() {
        String str1 = "ABC";
        String str1Expected = "ABC";
        String str2 = "CDE";
        String str2Expected = "CDE";
        int i = 1;
        int iExpected = 1;
        String ansExpected = "ABCDE";
        String ansActual = StringReassembly.combination(str1, str2, i);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(iExpected, i);
        assertEquals(ansExpected, ansActual);
    }

    /**
     * routine because it's a sentence with multiple characters overlapping.
     */

    @Test
    public void testCombination_MYNAMEISJORDYN_JORDYNLIEGL_6() {
        String str1 = "MY NAME IS JORDYN";
        String str1Expected = "MY NAME IS JORDYN";
        String str2 = "JORDYN LIEGL";
        String str2Expected = "JORDYN LIEGL";
        int i = 6;
        int iExpected = 6;
        String ansExpected = "MY NAME IS JORDYN LIEGL";
        String ansActual = StringReassembly.combination(str1, str2, i);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
        assertEquals(iExpected, i);
        assertEquals(ansExpected, ansActual);
    }

    /**
     * Tests of addToSetAvoidingSubstrings.
     */

    /**
     * boundary because it's the simple Hello World statement with one
     * substring.
     */

    @Test
    public void testAddToSetAvoidingSubstrings_HELLOWORLD_HELLO() {
        String str1 = "HELLO";
        String str1Expected = "HELLO";
        Set<String> strSet = new Set1L<>();
        strSet.add("HELLO");
        strSet.add("WORLD");
        Set<String> strSetExpected = new Set1L<>();
        strSetExpected.add("WORLD");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str1);
        assertEquals(str1Expected, str1);
        assertEquals(strSetExpected, strSet);
    }

    /**
     * challenging because there are two strings ending in the same suffix.
     */

    @Test
    public void testAddToSetAvoidingSubstrings_SMALLSIZE_PRIZE() {
        String str1 = "PRIZE";
        String str1Expected = "PRIZE";
        Set<String> strSet = new Set1L<>();
        strSet.add("SMALL");
        strSet.add("SIZE");
        Set<String> strSetExpected = new Set1L<>();
        strSetExpected.add("SMALL");
        strSetExpected.add("SIZE");
        strSetExpected.add("PRIZE");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str1);
        assertEquals(str1Expected, str1);
        assertEquals(strSetExpected, strSet);
    }

    /**
     * routine because there is an overlap but nothing to change the set.
     */

    @Test
    public void testAddToSetAvoidingSubstrings_1000_000() {
        String str1 = "000";
        String str1Expected = "000";
        Set<String> strSet = new Set1L<>();
        strSet.add("1000");
        Set<String> strSetExpected = new Set1L<>();
        strSetExpected.add("1000");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str1);
        assertEquals(str1Expected, str1);
        assertEquals(strSetExpected, strSet);
    }

    /**
     * Tests of linesFromInput.
     */

    /**
     * boundary because it's an empty set.
     */
    @Test
    public void testLinesFromInput_EMPTY() {
        SimpleReader input = new SimpleReader1L("data/empty.txt");
        Set<String> ans = new Set1L<>();
        Set<String> ansExpected = StringReassembly.linesFromInput(input);
        assertEquals(ansExpected, ans);
    }

    /**
     * challenging because there are quite a few lines with a non common order.
     */
    @Test
    public void testLinesFromInput_ALPHABETBACKWARDS() {
        SimpleReader input = new SimpleReader1L("data/zyx.txt");
        Set<String> ans = new Set1L<>();
        ans.add("ZYXWV");
        ans.add("UTSRQ");
        ans.add("PONML");
        ans.add("KJIHG");
        ans.add("FEDCB");
        ans.add("A");
        Set<String> ansExpected = StringReassembly.linesFromInput(input);
        assertEquals(ansExpected, ans);
    }

    /**
     * routine because it's just simple colors.
     */
    @Test
    public void testLinesFromInput_COLORS() {
        SimpleReader input = new SimpleReader1L("data/colors.txt");
        Set<String> ans = new Set1L<>();
        ans.add("red");
        ans.add("orange");
        ans.add("yellow");
        ans.add("green");
        ans.add("blue");
        Set<String> ansExpected = StringReassembly.linesFromInput(input);
        assertEquals(ansExpected, ans);
    }

    /**
     * Tests of printWithLineSeparators.
     */

    /**
     * routine because it's a standard introductory sentence.
     */
    @Test
    public void testPrintWithLineSeparators_HELLOMYNAMEISJORDYN() {
        SimpleWriter out = new SimpleWriter1L();
        out.print("");
        String str = "Hello~my~name~is~Jordyn";
        StringReassembly.printWithLineSeparators(str, out);
        out.close();
    }

    /**
     * challenging because the separators are in random places.
     */
    @Test
    public void testPrintWithLineSeparators_() {
        SimpleWriter out = new SimpleWriter1L();
        out.print("");
        String str = "Putt~ingsepara~t~orsinrando~mplaces";
        StringReassembly.printWithLineSeparators(str, out);
        out.close();
    }

    /**
     * boundary because it's a few characters spaced in a pattern.
     */
    @Test
    public void testPrintWithLineSeparators_123() {
        SimpleWriter out = new SimpleWriter1L();
        out.print("");
        String str = "~1~2~3~";
        StringReassembly.printWithLineSeparators(str, out);
        out.close();
    }

}
