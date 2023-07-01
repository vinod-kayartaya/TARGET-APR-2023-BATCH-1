package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

@Slf4j
public class BasicCollectionOperations {
    public static void main(String[] args) {

        Collection<Integer> nums;
        nums = new LinkedList<>();
        nums.add(100);
        nums.add(290);
        nums.add(456);
        log.trace("nums is {}", nums);
        log.trace("nums.size() is {}", nums.size());
        nums.add(495);
        log.trace("nums is {}", nums);

        Collection<Integer> anotherNums = Arrays.asList(33, 44, 55);
        nums.addAll(anotherNums);
        log.trace("nums is {}", nums);

//        for(int i=1; i<=1000; i++){
//            nums.add((int) (100+Math.random()*100));
//        }
//        log.trace("nums is {}", nums);

        int x = 222;
        if(nums.remove(x)){
            log.trace("{} was removed", x);
        }
        else {
            log.trace("{} was not in the collection", x);
        }
        log.trace("nums is {}", nums);

    }
}
