package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1766_문제집 {
    static int n, m;
    static PriorityQueue<Integer> queue;
    static ArrayList<Integer>[] list;
    static int[] con;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        con = new int[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            con[b]++;
        }

        queue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if(con[i]==0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int sol = queue.poll();
            System.out.printf(sol + " ");

            if(list[sol].isEmpty()) continue;
            for (int next: list[sol]) {
                con[next]--;
                if(con[next]==0){
                    queue.add(next);
                }
            }
        }
    }
}
