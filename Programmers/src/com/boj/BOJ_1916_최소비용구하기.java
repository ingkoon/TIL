package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
    static int n, m;
    static int start, end;
    static List<Node>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());


        graph = new ArrayList[n+1];

        for (int i = 0; i < n+1; i++)
            graph[i] = new ArrayList<Node>();

        int[] dist = new int[n+1];

        for (int i = 0; i < n+1; i++)
            dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int tmp = Integer.parseInt(st.nextToken()); // 출발지점
            int des = Integer.parseInt(st.nextToken()); // 도착지점
            int cost = Integer.parseInt(st.nextToken()); // 가는 비용
            graph[tmp].add(new Node(des, cost));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 비용이 큰 순서대로 정렬한다.
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        pq.offer(new Node(start, 0)); // 시작 지점 삽입
        dist[start] = 0; // 시작지점의 값을 초기화한다.
        while (!pq.isEmpty()){
            Node pNode = pq.poll();
            if(pNode.idx == end){ // 도착지점의 idx와 일치한다는 것은 최단거리가 보장되었다는 뜻
                System.out.println(dist[pNode.idx]);
                break;
            }
            if(dist[pNode.idx] < pNode.cost){ // 현재 해당 노드까지의 비용이 현재노드의 비용보다 작을 경우는 패스
                continue;
            }
            for(int i = 0; i< graph[pNode.idx].size(); i++){ // 해당 위치의 인덱스 개수만큼 반복
                Node nNode = graph[pNode.idx].get(i); // 현재 노드를 가져온다.
                if(dist[nNode.idx] > pNode.cost + nNode.cost){ //현재 노드까지의 값이 이전노드와 현재노드의 합보다 크다면
                    dist[nNode.idx] = pNode.cost + nNode.cost; // 값을 교체 후
                    pq.offer(new Node(nNode.idx, dist[nNode.idx])); // queue에 추가하여준다.
                }
            }
        }
    }

    static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
