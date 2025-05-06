package io.github.hoangtuan2k5.dsa.math.medium.src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegerToRomanTest {
    
    @Test
    public void testBasicCase1() {
        IntegerToRoman solution = new IntegerToRoman();
        int num = 3;
        String expected = "III";
        
        assertEquals(expected, solution.intToRoman(num));
    }
    
    @Test
    public void testBasicCase2() {
        IntegerToRoman solution = new IntegerToRoman();
        int num = 58;
        String expected = "LVIII";
        
        assertEquals(expected, solution.intToRoman(num));
    }
    
    @Test
    public void testBasicCase3() {
        IntegerToRoman solution = new IntegerToRoman();
        int num = 1994;
        String expected = "MCMXCIV";
        
        assertEquals(expected, solution.intToRoman(num));
    }
    
    @Test
    public void testMinValue() {
        IntegerToRoman solution = new IntegerToRoman();
        int num = 1;
        String expected = "I";
        
        assertEquals(expected, solution.intToRoman(num));
    }
    
    @Test
    public void testMaxValue() {
        IntegerToRoman solution = new IntegerToRoman();
        int num = 3999;
        String expected = "MMMCMXCIX";
        
        assertEquals(expected, solution.intToRoman(num));
    }
    
    @Test
    public void testSubtractionCases() {
        IntegerToRoman solution = new IntegerToRoman();
        
        // Test all the subtraction cases
        assertEquals("IV", solution.intToRoman(4));
        assertEquals("IX", solution.intToRoman(9));
        assertEquals("XL", solution.intToRoman(40));
        assertEquals("XC", solution.intToRoman(90));
        assertEquals("CD", solution.intToRoman(400));
        assertEquals("CM", solution.intToRoman(900));
    }
    
    @Test
    public void testRepeatedSymbols() {
        IntegerToRoman solution = new IntegerToRoman();
        
        // Test repetition of symbols
        assertEquals("III", solution.intToRoman(3));     // I repeated 3 times
        assertEquals("XXX", solution.intToRoman(30));    // X repeated 3 times
        assertEquals("CCC", solution.intToRoman(300));   // C repeated 3 times
        assertEquals("MMM", solution.intToRoman(3000));  // M repeated 3 times
    }
    
    @Test
    public void testComplexNumbers() {
        IntegerToRoman solution = new IntegerToRoman();
        
        // Test various complex combinations
        assertEquals("MMCDXLIV", solution.intToRoman(2444));  // Combines M, CD, XL, IV
        assertEquals("MCDLXXXVII", solution.intToRoman(1487));  // Combines M, CD, L, XXX, V, II
        assertEquals("DCCLXIV", solution.intToRoman(764));  // Combines D, CC, L, X, IV
    }
}