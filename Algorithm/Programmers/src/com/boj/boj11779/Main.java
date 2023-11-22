package com.boj.boj11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int city, bus;
    static List<Node>[] buses;
    static int[] dist, previous;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(bf.readLine());
        bus = Integer.parseInt(bf.readLine());

        previous = new int[city + 1];
        buses = new ArrayList[city+1];

        for (int i = 0; i <= city; i++) {
            buses[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < bus; i++) {
            st  = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            buses[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(bf.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        int next = previous[end];
        List<Integer> result = new ArrayList<>();
        result.add(end);

        while (next != 0) {
            result.add(next);
            next = previous[next];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(result.size()).append("\n");

        for (int i = result.size()-1; i >= 0; i--) {
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static void dijkstra(int start){
        dist = new int[city + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int des = node.des;
            if(dist[des] < node.cost)
                continue;
            for (Node next : buses[des]) {
                if(dist[next.des] > dist[des] + next.cost){
                    dist[next.des] = dist[des] + next.cost;
                    previous[next.des] = des;
                    queue.offer(new Node(next.des, dist[next.des]));
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int des;
        int cost;

        public Node(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.des, o.des);
        }
    }
}
