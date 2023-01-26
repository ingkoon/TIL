package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1504_특정한최단경로 {
    static int n, e;
    static int v1, v2;
    static int SIZE = 100000;
    static List<Node>[] graph;

        public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[e+1];
        for (int i = 0; i < e+1; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[tmp].add(new Node(des, cost));
        }

        st = new StringTokenizer(bf.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int tmp1 = 0;
        tmp1 += dijkstra(1, v1);
        tmp1 += dijkstra(v1, v2);
        tmp1 += dijkstra(v2, n);

        int tmp2 = 0;
        tmp2 += dijkstra(1, v2);
        tmp2 += dijkstra(v2, v1);
        tmp2 += dijkstra(v1, n);

        int result = Math.min(tmp1, tmp2);

        System.out.println(result > 10000 ? -1 : result);
    }
    static int dijkstra(int start, int end){
//        boolean[] check = new boolean[n+1];
        int[] dist= new int[n+1];
        for (int i = 0; i < n+1; i++) dist[i] = SIZE;
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2)->
                Integer.compare(o1.cost, o2.cost));

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()){
            Node pNode = pq.poll();

//            if(check[pNode.idx]) continue;
            if(dist[pNode.idx] < pNode.cost) continue; // 현재 노드값이 최소값보다 클 경우 생략할 수 있도록 한다.

//            check[pNode.idx] = true;
            for (int i = 0; i < graph[pNode.idx].size(); i++) {
                Node nNode = graph[pNode.idx].get(i);
                if( dist[nNode.idx] > dist[pNode.idx] + nNode.cost){
                    dist[nNode.idx] = dist[pNode.idx] + nNode.cost;
                    pq.offer(new Node(nNode.idx, dist[nNode.idx]));
                }
            }
        }
        System.out.println(dist[end]);
        return dist[end];
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}

/*
4 5
1 2 3
1 3 1
1 4 1
2 3 3
3 4 4
2 3
 */
