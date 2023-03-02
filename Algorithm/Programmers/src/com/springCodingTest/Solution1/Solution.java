package com.springCodingTest.Solution1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

        int[][] input1 = {{100, 100, 500}, {1000, 1000, 100}};

        int[][] input2 = {{10, 19, 800}, {20, 39, 200}, {100, 199, 500}};
        System.out.println(solution(input1));
    }
    static int solution(int[][] lotteries){
        int answer = 0;
        PriorityQueue<Lottery> queue = new PriorityQueue<Lottery>(new Comparator<Lottery>() {
            @Override
            public int compare(Lottery o1, Lottery o2) {
                double l1 = Math.round(((double) o1.hits / (double)(o1.consumers +1)*10000));
                double l2 = Math.round(((double) o2.hits / (double)(o2.consumers +1)*10000));
                System.out.println(l1 + " " + l2);
                 if(10000 > l1) l1 = 10000;
                 if(10000 > l2) l2 = 10000;
                if(l1 == l2) return o2.val - o1.val;
                return  (l2 - l1) >= 0 ? 1 : -1;
            }
        });

        for (int i = 0; i < lotteries.length; i++) {
            int num = i+1;
            int hits = lotteries[i][0];
            int consumers = lotteries[i][1];
            int val = lotteries[i][2];
            queue.offer(new Lottery(num, hits, consumers, val));
        }

        answer = queue.poll().num;
        return answer;
    }
    static class Lottery {
        int num;
        int hits;
        int consumers;
        int val;

        public Lottery(int num, int hits, int consumers, int val) {
            this.num = num;
            this.hits = hits;
            this.consumers = consumers;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Lottery{" +
                    "num=" + num +
                    ", hits=" + hits +
                    ", consumers=" + consumers +
                    ", val=" + val +
                    '}';
        }
    }
}
