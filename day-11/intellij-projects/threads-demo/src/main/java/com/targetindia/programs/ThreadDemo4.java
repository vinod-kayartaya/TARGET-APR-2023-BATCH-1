package com.targetindia.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Vector;

@Slf4j
public class ThreadDemo4 {
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Start of ThreadDemo3.main()");
        List<String> list = new Vector<>();

        Thread t1 = new Thread(()-> sentenceToWords(list, "jack jill went up the hill"), "t01");
        t1.start();
        Thread t2 = new Thread(()-> sentenceToWords(list, "the quick brown fox jumped over the lazy poor dog"),  "t02");
        t2.start();

        t1.join(); // the current thread (main, in this case) is timed-waiting until t1 is terminated
        t2.join();
        System.out.println(list);
        System.out.println("End of ThreadDemo3.main()");
    }

    @SneakyThrows // converts all checked exceptions being thrown into unchecked exceptions
    static void sentenceToWords(List<String> list, String sentence){
        String[] ar = sentence.split("\s");
        for(String a: ar){
            list.add(a);
            log.trace("adding {} to the list", a);
            Thread.sleep(1);
        }
    }

}


