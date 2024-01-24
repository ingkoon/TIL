package com.os.semaphore;

import java.util.Queue;

public class Consumer extends Thread{
    Buffer b;
    int n;
    public Consumer(Buffer b, int n){
        this.b = b;
        this.n = n;
    }

    public void run(){
        int item;
        for(int i = 0; i < n; i++) {
            System.out.println("con");
            item = b.remove();
        }
    }
}
