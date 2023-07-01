package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class ListDemo {

    public static void main(String[] args) {
        List<Integer> nums = new Stack<>();
        // add some random number
        for (int i = 0; i < 5; i++) {
            nums.add((int) (1 + Math.random() * 100));
        }

        // different ways to loop over an Iterable object
        // 1. enhanced for loop (a.k.a for-each loop); since 1.5
        for (int num : nums) {
            System.out.println("num is " + num);
        }
        System.out.println();

        // 2. use the standard for loop
        for (int i = 0, j = nums.size(); i < j; i++) {
            System.out.printf("nums.get(%d) is %d%n", i, nums.get(i));
        }
        System.out.println();

        // 3. use the Iterator of an Iterable
        Iterator<Integer> it = nums.iterator(); // An Iterable produces an Iterator
        while (it.hasNext()) {
            int n = it.next();
            System.out.printf("n = %d%n", n);
        }
        System.out.println();

        int n = 35;
        if(nums.contains(n)){
            System.out.printf("%d is found in nums%n", n);
        }
        else {
            System.out.printf("%d does not exist in nums%n", n);
        }

        // insert a number to the beginning
        nums.add(0, 333);
        System.out.printf("nums is %s%n", nums);

        nums.add(nums.size(), 444); // same as nums.add(444);
        System.out.printf("nums is %s%n", nums);

        nums.add(nums.size()/2, 555); // add to the middle
        System.out.printf("nums is %s%n", nums);

        List<Integer> anotherNums = nums.subList(2, 5);
        System.out.println("anotherNums = " + anotherNums);

    }

    public static void main2(String[] args) {
        List data = new ArrayList(); // heterogeneous collection of data
        data.add(1234);
        data.add("Vinod");
        data.add(new Date());
        data.add(10 > 20);

        log.trace("data is {}", data);

        for (Object obj : data) {
            System.out.println("obj is " + obj + " of type " + obj.getClass().getName());
        }

        // homogeneous collection
        List<String> names = new ArrayList<>();
        names.add("Vinod");
        names.add("Shyam");

        List<Integer> nums = new ArrayList<>();
        nums.add(123);
        nums.add(345);

    }

    public static void main1(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        Object obj = names; // Object is one of the supertypes
        Iterable<String> it = names; // ArrayList IS-A Iterable
        Collection<String> col = names; // ArrayList IS-A Collection
        List<String> list = names; // ArrayList IS-A List

    }
}
