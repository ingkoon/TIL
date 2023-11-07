package com.boj.boj14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, tx, ty;
    static int[][] distances;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0 , -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distances = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    tx = j;
                    ty = i;
                }
                if (num == 0){
                    distances[i][j] = num;
                    continue;
                }
                distances[i][j] = -1;
            }
        }
        bfs(tx, ty);

        for (int[] ints : distances) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    static void bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0));
        visited[y][x] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            distances[node.y][node.x] = node.cnt;
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dr[i];
                int nx = node.x + dc[i];
                if(!isCheck(nx, ny) || distances[ny][nx] != -1 || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                queue.offer(new Node(nx, ny, node.cnt+1));
            }
        }
    }

    static boolean isCheck(int nx, int ny){
        return 0 <= nx && nx < m && 0 <= ny && ny < n;
    }

    static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
