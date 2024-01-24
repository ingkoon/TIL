package com.os.semaphore;



import java.util.Queue;

public class Producer extends Thread{
    Buffer b;
    int n ;
    public Producer(Buffer b, int n){
        this.b = b;
        this.n = n;
    }
    public void run(){

        for(int i = 0; i < n; i++){
            System.out.println("pro");
            b.insert(i);
        }

    }
}
