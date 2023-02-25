package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1238_파티 {
    static int  n, x, m;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new List[n+1];

        for (int i = 0; i <n+1; i++) graph[i] = new ArrayList<Node>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[tmp].add(new Node(idx, cost));
        }

        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            if(x == i) {
                result = Math.max(tmp, result);
                continue;
            };
            tmp = dijkstra(i, x) + dijkstra(x, i);
            result = Math.max(tmp, result);
        }
        System.out.println(result);
    }

    static int dijkstra(int start, int end){
        int[] dist = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(
                (o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node pNode = pq.poll(); // 노드를 하나 꺼낸다
            int pIdx = pNode.idx;; // 현재 노드의 인덱스 번호를 가져온다.

            if(pIdx == end) break; // 현재 노드가 목표로 하는곳과 일치하는 경우 종료

            for (int i = 0; i < graph[pIdx].size(); i++) {
                Node nNode =  graph[pIdx].get(i); // 다음 노드 탐색
                int nIdx = nNode.idx; // 다음 노드의 인덱스
                int nCost = nNode.cost; // 다음 노드의 비용
                if(dist[nIdx] <= dist[pIdx] + nCost) continue; // 다음 위치의 최소값이 가 현재노드 + 다음노드의 값보다 클 경우 패스
                dist[nIdx] = dist[pIdx] + nCost; // 다음 노드의 값은 현재 노드 + 다음 노드
                pq.offer(new Node(nIdx, dist[nIdx]));
            }
        }
        return dist[end];
    }

    static class Node{ // 리스트에 들어갈 객체
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

    }
}
