package com.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PG_42628_이중우선순위큐 {
    static PriorityQueue<Integer> minQueue;
    static PriorityQueue<Integer> maxQueue;

    public static void main(String[] args) {
        String[] input1 =  {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution(input1)));
    }
    static int[] solution(String[] operations) {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });

        for(String o : operations){
            String[] tmp = o.split(" ");
            if(tmp[0].equals("I")){
                input(Integer.parseInt(tmp[1]));
                continue;
            }
            delete(Integer.parseInt(tmp[1]));
        }

        int max = maxQueue.isEmpty() ? 0 : maxQueue.poll();
        int min = minQueue.isEmpty() ? 0 : minQueue.poll();

        return new int[] {max, min};
    }
    static void input(int n){
        minQueue.offer(n);
        maxQueue.offer(n);
    }
    static void delete(int c){
        if(minQueue.isEmpty()) return;
        if(c == 1){
            int num = maxQueue.poll();
            minQueue.remove(num);
            return;
        }
        int num = minQueue.poll();
        maxQueue.remove(num);
    }
}
