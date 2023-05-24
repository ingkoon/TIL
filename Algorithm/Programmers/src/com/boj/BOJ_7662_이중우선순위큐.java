package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BOJ_7662_이중우선순위큐 {
    static int T,n;
    static PriorityQueue<Integer> maxQueue;
    static PriorityQueue<Integer> minQueue;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t< T; t++) {

            n = Integer.parseInt(bf.readLine());
            maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            minQueue = new PriorityQueue<>();
            map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] tmp = bf.readLine().split(" ");
                String operator = tmp[0];
                int num = Integer.parseInt(tmp[1]);

                if(operator.equals("I")) {
                    input(num);
                    continue;
                }
                if(map.isEmpty()) continue;
                delete(num);
            }
            print();
        }
    }
    static void input(int num){
        map.put(num, map.getOrDefault(num, 0)+1);
        minQueue.offer(num);
        maxQueue.offer(num);
    }

    static int delete(int flag){
        PriorityQueue<Integer> tmp = flag == 1 ? maxQueue : minQueue;
        int num = 0;
        while (true){
            num = tmp.poll();
            int cnt = map.getOrDefault(num, 0);
            if(cnt == 0)
                continue;
            if(cnt == 1)
                map.remove(num);
            else
                map.put(num, cnt-1);
            break;
        }
        return num;
    }
    static void print(){
        if(map.size() == 0) {
            System.out.println("EMPTY");
            return;
        }
        int min = delete(1);
        System.out.println(min + " " + (map.size() > 0 ? delete(-1) : min));
    }
}
