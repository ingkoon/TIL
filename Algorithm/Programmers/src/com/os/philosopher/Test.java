package com.os.philosopher;

import java.util.concurrent.Semaphore;

public class Test {
    static final int num = 5; // number of philosphers & chopsticks
    public static void main(String[] args) {
        int i;
        /* chopsticks */
        Semaphore[] stick = new Semaphore[num];
        for (i=0; i<num; i++)
            stick[i] = new Semaphore(1);
        /* philosophers */
        Philosopher[] phil = new Philosopher[num];
        for (i=0; i<num; i++)
            phil[i] = new Philosopher(i, stick[i], stick[(i+1)%num]);
        /* let philosophers eat and think */
        for (i=0; i<num; i++)
            phil[i].start();
    }
}