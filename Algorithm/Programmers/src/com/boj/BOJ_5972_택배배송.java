package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5972_택배배송 {
    static int n, m;
    static int SIZE = Integer.MAX_VALUE;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken()); // 지름길의 개수
        m = Integer.parseInt(st.nextToken()); // 도로의 길이

        graph = new ArrayList[n+1];
        int[] dist = new int[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Node>();
            dist[i] = SIZE;
        }

        dist[1] = 0;

        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()){
            Node pNode = pq.poll();

            int pDes = pNode.des;

//            if(n == pDes) break;

//            if(dist[pDes] < pNode.cost) continue;

            for (int i = 0; i < graph[pDes].size(); i++) {
                Node nNode = graph[pDes].get(i);
                int nDes = nNode.des;
                int nCost = nNode.cost;
                if(dist[nDes] <= dist[pDes] + nCost) continue;
                dist[nDes] = dist[pDes] + nCost;
                pq.offer(new Node(nDes, dist[nDes]));
            }
        }

        System.out.println(dist[n]);
    }

    static class Node{
        int des;
        int cost;

        public Node(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }
    }
}
