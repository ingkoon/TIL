package com.boj;

import java.util.*;

public class BOJ_1916_최소비용구하기v2 {
    static int n, m;
    static boolean[] visited;

    static class Edge implements Comparable<Edge>{
        int node;
        int dis;

        public Edge(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dis, o.dis);
        }

        @Override
        public String toString() {
            return dis + "";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

       List<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            graph[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited = new boolean[n];
        Edge[] d = new Edge[n];

        int start = sc.nextInt()-1;
        int end = sc.nextInt()-1;

        for (int i = 0; i < n; i++) {
            if(i==start){
                d[i] = new Edge(i, 0);
            }else{
                d[i] = new Edge(i, Integer.MAX_VALUE);
            }
            pq.add(d[i]);
        }
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            if(edge.dis == Integer.MAX_VALUE) break;

            // 방문했으면 x
            if(visited[edge.node]) continue;
            for (Edge next : graph[edge.node]) {
                // D[next.node]가 D[edge.node] + next.dis보다 더 크다면 갱신
                if(d[next.node].dis > d[edge.node].dis + next.dis) {
                    d[next.node].dis = d[edge.node].dis + next.dis;

                    //pq에 갱신된 next를 넣기위해 기존 요소를 제거하고 다시 삽입
                    pq.remove(d[next.node]);
                    pq.add(d[next.node]);
                }
            }
            //노드 방문체크
            visited[edge.node] = true;
        }
        System.out.println(Arrays.toString(d));

    }
}
