package com.producer.consumer.blockingqueue;

import java.util.concurrent.*;

public class ProducerConsumerPattern {

    public static void main(String[] args) throws Exception {
        BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<String>(10);

        /*Thread t1 = new Thread(new Producer(sharedQueue));
        Thread t2 = new Thread(new Consumer(sharedQueue),"Worker1");
        Thread t3= new Thread(new Consumer(sharedQueue),"Worker2");
        t1.start();
        t2.start();
        t3.start();*/

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(new Producer(sharedQueue));
        executorService.execute(new Consumer(sharedQueue));
        executorService.execute(new Consumer(sharedQueue));
        executorService.execute(new Consumer(sharedQueue));

//        executorService.shutdown();

    }
}