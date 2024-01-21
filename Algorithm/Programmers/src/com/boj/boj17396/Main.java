package com.boj.boj17396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 17396 G5 백도어
 */
public class Main {
    static int n, m;
    static long INF = Long.MAX_VALUE;
    static int[] board;
    static List<Loc>[] locations;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n];
        locations = new ArrayList[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
            locations[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            locations[dep].add(new Loc(des, cost));
            locations[des].add(new Loc(dep, cost));
        }

        System.out.println(dijkstra(0));
    }

    static long dijkstra(int start){
        long[] dist = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Loc> queue = new PriorityQueue<>();
        queue.offer(new Loc(start, 0));

        while (!queue.isEmpty()){
            Loc loc = queue.poll();

            if(visited[loc.des])
                continue;
            visited[loc.des] = true;

            for (int i = 0; i < locations[loc.des].size(); i++) {
                Loc next = locations[loc.des].get(i);
                if((next.des != n-1 && board[next.des] == 1) || loc.cost + next.cost > dist[next.des])
                    continue;
                dist[next.des] = dist[loc.des] + next.cost;
                queue.offer(new Loc(next.des, dist[next.des]));
            }
        }

        if (dist[n-1] == INF) {
            return -1;
        }
        return dist[n-1];
    }

    static class Loc implements Comparable<Loc> {
        int des;
        long cost;

        public Loc(int des, long cost) {
            this.des = des;
            this.cost = cost;
        }

        @Override
        public int compareTo(Loc o) {
            return (int) (this.cost - o.cost);
        }
    }
}