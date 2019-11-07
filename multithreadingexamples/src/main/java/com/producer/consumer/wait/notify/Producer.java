package com.producer.consumer.wait.notify;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<String> queue;
    int maxSize = 10;

    public Producer(Queue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String str = produce();
                System.out.println("Produced: "+str);
                queue.add(str);
                queue.notifyAll();
            }
        }
    }

    public String produce() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                .build();
        String str = generator.generate(5);
        return str;
    }
}
