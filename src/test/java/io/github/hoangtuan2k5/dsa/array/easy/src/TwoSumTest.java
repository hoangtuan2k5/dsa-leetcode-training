package io.github.hoangtuan2k5.dsa.array.easy.src;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TwoSumTest {
    
    @Test
    public void testBasicCase() {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
    
    @Test
    public void testWithNegativeNumbers() {
        TwoSum solution = new TwoSum();
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] expected = {0, 2};
        
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
    
    @Test
    public void testWithZeroes() {
        TwoSum solution = new TwoSum();
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        int[] expected = {0, 3};
        
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
    
    @Test
    public void testMinimumLength() {
        TwoSum solution = new TwoSum();
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
    
    @Test
    public void testElementsInDifferentPositions() {
        TwoSum solution = new TwoSum();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
    
    @Test
    public void testLargerArray() {
        TwoSum solution = new TwoSum();
        int[] nums = {1, 5, 8, 13, 7, 22, 16, 4};
        int target = 20;
        int[] expected = {3, 4}; // 8 + 12 = 20
        
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
}