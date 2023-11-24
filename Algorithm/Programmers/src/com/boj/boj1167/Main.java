package com.boj.boj1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int v;
    static ArrayList<Node>[] nodeList;
    static boolean[] visited;
    static int max = 0;
    static int tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(bf.readLine());
        nodeList = new ArrayList[v + 1];

        for (int i = 0; i <= v; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int dep = Integer.parseInt(st.nextToken());
            while (true){
                int des = Integer.parseInt(st.nextToken());
                if(des == -1)
                    break;
                int cost = Integer.parseInt(st.nextToken());
                nodeList[dep].add(new Node(des, cost));
            }
        }

        visited = new boolean[v + 1];
        dfs(1, 0);
        visited = new boolean[v + 1];
        dfs(tmp, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            tmp = x;
        }
        visited[x] = true;

        for(int i = 0; i < nodeList[x].size(); i++) {
            Node node = nodeList[x].get(i);
            if(!visited[node.to]) {
                dfs(node.to, node.cost + len);
                visited[node.to] = true;
            }
        }

    }
    private static class Node implements Comparable<Node>{
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
