package com.targetindia.programs;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        // int nums[], ages[], months[];
        // int[] nums, ages, months;

        // int[] nums;
        int[] nums = {98, 87, 65};
        System.out.println("nums is " + nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("nums[%d] = %d\n", i, nums[i]);
        }

        // error: cannot access nums, until it is initialized
        // System.out.println("nums contains: " + nums);

        // To initialize array, there are few options
        nums = new int[3];
        System.out.println("nums is " + nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("nums[%d] = %d\n", i, nums[i]);
        }

        nums = new int[]{12, 34, 56, 78, 90};
        System.out.println("nums is " + nums);
        int i = 0;
        for (int n : nums) {
            // index is not available by default in the enhanced for loop
            System.out.printf("nums[%d] = %d\n", i++, n);
        }

        System.out.println("nums is " + Arrays.toString(nums));
    }
}
