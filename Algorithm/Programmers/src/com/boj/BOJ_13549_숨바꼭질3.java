package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
    static int n, k;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    static int SIZE = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[SIZE];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {n, 0});

        while (!queue.isEmpty()){
            int[] p = queue.poll();
            int loc = p[0];
            int time = p[1];
            visited[loc] = true;

            if(loc == k) result = Math.min(result, time);

            int pLoc = prev(loc);
            int nLoc = next(loc);
            int tLoc = teleport(loc);

            if(tLoc < SIZE && !visited[tLoc]) queue.offer(new int[]{tLoc, time});
            if(pLoc >= 0 &&!visited[pLoc]) queue.offer(new int[]{pLoc, time+1});
            if(nLoc < SIZE && !visited[nLoc]) queue.offer(new int[]{nLoc, time+1});
        }
        System.out.println(result);
    }

    static int prev(int loc){
        return loc -1;
    }

    static int next(int loc){
        return loc +1;
    }

    static int teleport(int loc){
        return loc * 2;
    }
}
