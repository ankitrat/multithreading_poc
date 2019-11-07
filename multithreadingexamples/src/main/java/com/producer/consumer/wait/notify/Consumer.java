package com.producer.consumer.wait.notify;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<String> queue;
    int size=10;

    public Consumer(Queue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true){
            synchronized (queue){
                while (queue.size()==0){
                    try {
                        System.out.println("Queue is empty");
                        queue.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                String str=queue.remove();
                System.out.println("Consumed: "+str);
                queue.notifyAll();
            }
        }
    }
}
