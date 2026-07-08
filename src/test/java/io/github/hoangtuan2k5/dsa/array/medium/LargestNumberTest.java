package io.github.hoangtuan2k5.dsa.array.medium;

import junit.framework.TestCase;

public class LargestNumberTest extends TestCase {
    public void testLargestNumber() {
        LargestNumber solution = new LargestNumber();

        assertEquals("210", solution.largestNumber(new int[] {10, 2}));
        assertEquals("9534330", solution.largestNumber(new int[] {3, 30, 34, 5, 9}));
    }

    public void testLargestNumberWithOnlyZeros() {
        LargestNumber solution = new LargestNumber();

        assertEquals("0", solution.largestNumber(new int[] {0, 0}));
    }
}
