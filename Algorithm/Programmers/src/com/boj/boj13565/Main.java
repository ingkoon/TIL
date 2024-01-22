package com.boj.boj13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 13565 S2 침투
 */
public class Main {
    static int m, n;

    static int[][] graph;
    static boolean[][] visited;

    static int[] dr = {0 , 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            char[] numbers = bf.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                int inputNumber = Integer.parseInt(numbers[j]+"");
                graph[i][j] = inputNumber;
            }
        }

        for (int i = 0; i < n; i++) {
            if(graph[0][i] == 0)
                bfs(0, i);
        }

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if(visited[m-1][i]){
                flag = true;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
    static void bfs(int r, int c){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int pr = node.r;
            int pc = node.c;
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc] || graph[nr][nc] == 1)
                    continue;
                visited[nr][nc] = true;
                queue.offer(new Node(nr, nc));
            }
        }
    }

    static boolean isCheck(int r, int c){
        return 0 <= r && r < m && 0 <= c && c < n;
    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
