package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.addAll(Arrays.asList(22, 27, 28, 38, 12, 13, 14, 15, 19, 12, 13, 12 ,13));
        log.trace("numbers = {}", numbers);

        Set<Integer> numbers1 = new LinkedHashSet<>();
        numbers1.addAll(Arrays.asList(22, 27, 28, 38, 12, 13, 14, 15, 19, 12, 13, 12 ,13));
        log.trace("numbers1 = {}", numbers1);

        Set<Integer> numbers2 = new TreeSet<>();
        numbers2.addAll(Arrays.asList(22, 27, 28, 38, 12, 13, 14, 15, 19, 12, 13, 12 ,13));
        log.trace("numbers2 = {}", numbers2);

        Set<String> names = new TreeSet<>();
        names.add("vinod");
        names.add("vinay");
        names.add("ravi");
        names.add("anand");
        names.add("vinod");
        names.add("arun");
        names.add("anand");
        log.trace("names = {}", names);
    }
}
