package com.boj.boj14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[] items;
    static int[] dist;
    static boolean[] visited;
    static List<Node>[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];
        board = new ArrayList[n+1];

        st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            board[i] = new ArrayList<>();
        }

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(bf.readLine());

            int dep = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            board[dep].add(new Node(des, weight));
            board[des].add(new Node(dep, weight));
        }

        dist = new int[n+1];
        visited = new boolean[n+1];

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dijkstra(i));
        }

        System.out.println(result);
    }

    static int dijkstra(int start){
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int des = node.des;

            if(!visited[des]){
                visited[des] = true;

                for (Node currentNode : board[des]) {
                    if(!visited[currentNode.des] && dist[currentNode.des] > dist[des] + currentNode.weight){
                        dist[currentNode.des] = dist[des] + currentNode.weight;
                        queue.add(new Node(currentNode.des, dist[currentNode.des]));
                    }
                }
            }
        }
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if(dist[i] <= m){
                result += items[i];
            }
        }

        return result;
    }

    static class Node implements Comparable<Node> {
        int des;
        int weight;

        public Node(int des, int weight) {
            this.des = des;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
