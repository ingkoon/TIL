package com.boj.boj1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static List<Node>[] board;
    static int[] dist;
    static int INF = 10000001;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            board = new ArrayList[n+1];
            dist = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                board[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());

                int dep = Integer.parseInt(st.nextToken());
                int des = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                board[des].add(new Node(dep, cost));
                board[dep].add(new Node(des, cost));
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(bf.readLine());

                int dep = Integer.parseInt(st.nextToken());
                int des = Integer.parseInt(st.nextToken());
                int cost = -Integer.parseInt(st.nextToken());

                board[dep].add(new Node(des, cost));
            }

            System.out.println(bellmanFord(1, n)? "YES" : "NO");
        }
    }

    static boolean bellmanFord(int start, int n){

        Arrays.fill(dist, INF);

        dist[start] = 0;
        boolean isUpdate = false;

        for (int i = 1; i < n; i++) {
            isUpdate = false;
            for (int j = 1; j <= n; j++) {
                for (Node node : board[j]) {
                    if(dist[node.to] > dist[j] + node.cost){
                        dist[node.to] = dist[j] + node.cost;
                        isUpdate = true;
                    }
                }
            }
            if(!isUpdate)
                break;
        }

        return isUpdate;
    }

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
