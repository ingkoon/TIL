package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12681_숨바꼭질2 {
    static int n, k, fast, count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = bf.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        k = Integer.parseInt(tmp[1]);
        visited = new boolean[100001];

        int minValue = Integer.MAX_VALUE;

        Queue<Loc> queue = new LinkedList<>();

        queue.offer(new Loc(n, 0));
        while (!queue.isEmpty()){
            Loc loc = queue.poll();
            visited[loc.loc] = true;
//            System.out.println(loc);
            if(loc.loc == k){
                if(minValue == Integer.MAX_VALUE){
                    minValue = loc.cnt;
                    fast = loc.cnt;
                    count ++;
                    continue;
                }
                if(loc.cnt == minValue)
                    count ++;
                continue;
            }
            if(loc.cnt > minValue){
                continue;
            }
            if(isSize(loc.loc+1)){
                queue.offer(new Loc(loc.loc + 1, loc.cnt + 1));
            }

            if(isSize(loc.loc - 1)){
                queue.offer(new Loc(loc.loc - 1, loc.cnt + 1));
            }

            if(isSize(loc.loc * 2)){
                queue.offer(new Loc(loc.loc * 2, loc.cnt + 1));
            }



        }
        System.out.println(fast);
        System.out.println(count);
    }

    static boolean isSize(int size){
        return size >= 0  && size < 100001 && !visited[size];
    }

    static class Loc{
        int loc;
        int cnt;

        public Loc(int loc, int cnt) {
            this.loc = loc;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Loc{" +
                    "loc=" + loc +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
