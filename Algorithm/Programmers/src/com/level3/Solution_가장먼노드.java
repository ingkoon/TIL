package com.level3;
import java.util.*;
public class Solution_가장먼노드 {
        static int[] visited;
        static List<List<Integer>> graph;
        static Queue<Node> queue;

        public int solution(int n, int[][] edge) {
            visited = new int[n+1];
            graph = new ArrayList<>();
            queue = new LinkedList<>();
            int maxValue = Integer.MIN_VALUE;

            for(int i = 0; i < n+1; i++){
                graph.add(new ArrayList<Integer>());
            }

            for(int[] e : edge){
                int from = e[0];
                int to = e[1];
                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            Node start = new Node(1, 0);
            queue.offer(start);

            while(!queue.isEmpty()){
                Node cur = queue.poll();

                int node = cur.node;
                int distance = cur.cnt+1;

                for(int num: graph.get(node)){
                    if(visited[num] > 0 ) continue;
                    queue.offer(new Node(num, distance));
                    visited[num] = distance;
                    maxValue = distance;
                }
            }

            int answer = 0;
            for(int i = 2; i <= n; i++){
                if(visited[i] == maxValue) answer++;
            }
            return answer;
        }

        static class Node{
            int node;
            int cnt;
            public Node(int node, int cnt){
                this.node = node;
                this.cnt = cnt;
            }
        }

}
