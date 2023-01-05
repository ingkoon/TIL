package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753_최단경로 {
    static int v, e, start;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        v = Integer.parseInt(st.nextToken()); // 정점의 개수
        e = Integer.parseInt(st.nextToken()); // 간선의 개수
        start = Integer.parseInt(bf.readLine()); // 시작 지점 노드

        graph = new ArrayList[v+1];
        dist = new int[v+1];

        for (int i = 0; i < v+1; i++) { // 그래프, 비용 초기화
            graph[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[idx].add(new Node(des, cost));
        }
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()){
            Node pNode = pq.poll();
            int pDes = pNode.des;
            for (int i = 0; i < graph[pDes].size(); i++) {
                Node next = graph[pDes].get(i);
                int nDes = next.des;
                int nCost = next.cost;
                if(dist[nDes] <= dist[pDes] + nCost) continue;
                dist[nDes] = dist[pDes] + nCost;
                pq.offer(new Node(nDes, dist[nDes]));
            }
        }
        for (int i = 1; i < v+1; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(dist[i]);
        }
    }

    static class Node{ // 방향이 있는 간선 객체 생성
        int des;
        int cost;

        public Node(int des, int cost) {
            this.des = des;
            this.cost = cost;
        }
    }
}
