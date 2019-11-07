package com.producer.consumer.wait.notify;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerPattern {
    public static void main(String[] args) {
        final Queue<String> queue = new LinkedList<String>();

        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Consumer(queue));
        t1.start();
        t2.start();
    }
}
