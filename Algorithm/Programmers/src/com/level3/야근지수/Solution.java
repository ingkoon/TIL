package com.level3.야근지수;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
