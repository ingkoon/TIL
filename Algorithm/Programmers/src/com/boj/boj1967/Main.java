package com.boj.boj1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static List<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        tree = new ArrayList[n+1];

        for (int i = 1; i <= n; i++)    // 트리 초기화
            tree[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            tree[dep].add(new Node(des, value));
            tree[des].add(new Node(dep, value));
        }

        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, 0, visited);
            visited[i] = false;
        }

        System.out.println(result);
    }

    static void dfs(int start, int value, boolean[] visited){
        List<Node> nodes = tree[start];
        result = Math.max(result, value);
        for (Node node : nodes) {
            if(visited[node.node])
                continue;
            visited[node.node] = true;
            dfs(node.node, value + node.value, visited);
            visited[node.node] = false;
        }
    }

    static class Node{
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
