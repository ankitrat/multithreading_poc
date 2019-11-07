package com.producer.consumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue=queue;
    }

    public void run() {
        while (true){
            try{
                System.out.println("Consumed by  "+Thread.currentThread().getName()+" "+queue.take());
                Thread.sleep(1200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
