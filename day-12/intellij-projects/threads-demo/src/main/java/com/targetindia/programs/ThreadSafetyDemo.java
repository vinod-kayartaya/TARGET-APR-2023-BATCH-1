package com.targetindia.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ThreadSafetyDemo {

    static synchronized void createAndStoreWords(String sentence, List<String> list) {
        log.trace("got this sentence to be converted into words: '{}'", sentence);
        String[] words = sentence.split("\s");
        log.trace("adding all words to the list one by one...");
        for (String word : words) {
            list.add(word);
            log.trace("word '{}' is added to the words list in the thread '{}'",
                    word, Thread.currentThread().getName());
        }
        log.trace("added all words to the list successfully");
    }

    static void createAndStoreWords1(String sentence, List<String> list) {
        log.trace("got this sentence to be converted into words: '{}'", sentence);
        String[] words = sentence.split("\s");
        log.trace("adding all words to the list one by one...");
        synchronized (list) {
            for (String word : words) {
                list.add(word);
                log.trace("word '{}' is added to the words list in the thread '{}'",
                        word, Thread.currentThread().getName());
            }
        }
        log.trace("added all words to the list successfully");
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Today's weather is good since it rained here in Bangalore",
                "The quick brown fox jumps over the lazy dog",
                "my name is vinod",
                "when writable objects are shared with multiple threads, race condition happens"
        };
        List<String> words = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (String sentence : sentences) {
            log.trace("starting to convert sentence to words for the sentence: {}", sentence);
            Thread t = new Thread(() -> {
                log.trace("working on sentence = {}", sentence);
                createAndStoreWords(sentence, words);
                log.trace("working on sentence.toUpperCase() = {}", sentence.toUpperCase());
                createAndStoreWords(sentence.toUpperCase(), words);
            });
            threads.add(t);
            t.start();
        }

        Thread dt = new Thread(() -> {
            for (int i = 0; ; i++) {
                log.trace("in thread '{}' value of i is {}", Thread.currentThread().getName(), i);
            }
        });
        dt.setDaemon(true);
        dt.start();

        // wait for all "threads" to come and join this thread
        threads.forEach(ThreadSafetyDemo::join);

        log.trace("words = {}", words);
        log.trace("End of main()");
    }

    @SneakyThrows
    static void join(Thread t) {
        t.join();
    }
}
