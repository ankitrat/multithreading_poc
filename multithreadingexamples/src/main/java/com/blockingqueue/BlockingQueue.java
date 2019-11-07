package com.blockingqueue;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {
    private List<T> queue = new LinkedList<T>();
    private int size;

    public BlockingQueue(int size) {
        this.size = size;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (this.queue.size() >= this.size) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    public synchronized T dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.size) {
            notifyAll();
        }
        return this.queue.remove(0);

    }
}
