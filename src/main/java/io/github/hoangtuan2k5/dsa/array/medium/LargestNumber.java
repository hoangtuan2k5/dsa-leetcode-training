package io.github.hoangtuan2k5.dsa.array.medium;

import java.util.Arrays;
import java.util.Comparator;

// LeetCode 179. Largest Number
// Tags: Array, Sorting, Greedy
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] arr = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(arr, new LargestNumberComparator());

        if (arr[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }

        return sb.toString();
    }

    private static class LargestNumberComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            String ab = String.valueOf(a) + b;
            String ba = String.valueOf(b) + a;

            return ba.compareTo(ab);
        }
    }
}
