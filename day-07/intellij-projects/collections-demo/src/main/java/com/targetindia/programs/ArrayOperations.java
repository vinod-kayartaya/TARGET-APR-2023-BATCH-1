package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayOperations {

    public static void main(String[] args) {
        int[] nums = new int[10];
        nums[0] = 12;
        nums[1] = 22;

        log.trace("nums is {}", nums);
        nums[2] = 123;
        log.trace("nums is {}", nums);
        log.trace("nums.length is {}", nums.length);

        int size = 3;
        size = insertFirst(99, nums, size);
        log.trace("nums is {}", nums);
        size = insertFirst(567, nums, size);
        log.trace("nums is {}", nums);
        size = insertFirst(234, nums, size);
        log.trace("nums is {}", nums);
        size = insertFirst(99, nums, size);
        log.trace("nums is {}", nums);
        size = insertFirst(567, nums, size);
        log.trace("nums is {}", nums);
        size = insertFirst(234, nums, size);
        log.trace("nums is {}", nums);
        size = insertFirst(99, nums, size);
        log.trace("nums is {}", nums);
        size = insertFirst(567, nums, size);
        log.trace("nums is {}", nums);
        size = insertFirst(234, nums, size);
        log.trace("nums is {}", nums);
    }

    static int insertFirst(int num, int[] nums, int size) {
        if (size == nums.length) {
            size = nums.length - 1;
        }
        for (int i = size - 1; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        nums[0] = num;
        return size + 1;
    }
}
