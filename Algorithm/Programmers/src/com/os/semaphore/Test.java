package com.os.semaphore;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] arg){
        Buffer b = new Buffer(100);
        Producer p = new Producer(b, 10000);
        Consumer c = new Consumer(b, 10000);
        p.start();
        c.start();
        try{
            p.join();
            c.join();
        } catch(InterruptedException e){
            System.out.println("Number of items in the buf is " + b.count);
        }
        System.out.println("Number of items in the buf is " + b.count);
    }
}
