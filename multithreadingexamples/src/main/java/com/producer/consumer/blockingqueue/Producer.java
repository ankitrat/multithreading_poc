package com.producer.consumer.blockingqueue;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue=queue;
    }

    public void run() {
       while(true){
           String str= produce();
           try{
               queue.put(str);
               System.out.println("Produced by: "+Thread.currentThread().getName()+" "+str);
//               Thread.sleep(1000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
    }

    public String produce(){
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                .build();
        String str=generator.generate(5);
        return str;
    }
}
