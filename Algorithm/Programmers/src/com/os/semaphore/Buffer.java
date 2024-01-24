package com.os.semaphore;

import java.util.concurrent.Semaphore;

public class Buffer {
    int[] buf;
    int size;
    int count;
    int in;
    int out;
    Semaphore mutex, full, empty;

    public Buffer(int size) {
        buf = new int[size];
        this.size = size;
        count = in = out = 0;
        mutex = new Semaphore(1);
        full = new Semaphore(0);
        empty = new Semaphore(size);
    }

    void insert(int item) {
        try {
            empty.acquire();
            mutex.acquire();
            buf[in] = item;
            in = (in + 1) % size;
            count++;
            mutex.release();
            full.release();
        } catch (Exception e) {}
    }

    int remove() {
        try {
            full.acquire();
            mutex.acquire();
            int item = buf[out];
            out = (out + 1) % size;
            count--;
            mutex.release();
            empty.release();
            return item;
        } catch (Exception e) {}
        return -1;
    }
}
