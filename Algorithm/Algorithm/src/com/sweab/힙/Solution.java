package com.sweab.힙;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int TC = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        for (int tc = 1; tc <= TC; tc++) {
            int N = sc.nextInt();
            sb.append("#").append(tc).append(' ');
            pq.clear();
            for (int i = 0; i < N; i++) {
                int operator = sc.nextInt();
                if (operator == 1) {
                    int input = sc.nextInt();
                    pq.add(input);
                } else {
                    int output = -1;
                    if (pq.size() > 0) {
                        output = pq.poll();
                    }
                    sb.append(output).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}