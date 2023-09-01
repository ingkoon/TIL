package com.boj.boj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result = Integer.MAX_VALUE;
    static int SIZE = 8;
    static char[][] board;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for(int i = 0; i < n; i++){
            char[] tmp = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[j];
            }
        }
        for(int i = 0; i <= n - SIZE; i++){
            for (int j = 0; j <= m - SIZE; j++) {
               result = Math.min(result, Math.min(bfs(i, j, 'W'), bfs(i, j ,'B')));

            }
        }
        System.out.println(result);
    }
    static int bfs(int r, int c, char color){
        int tmp = 0;
        char[][] tmpBoard = new char[SIZE][SIZE];
        boolean[][] visited = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tmpBoard[i][j] = board[r + i][c + j];
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, color));
        if(color != tmpBoard[0][0])
            tmp++;
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc])
                    continue;
                if(tmpBoard[nr][nc] == node.value){
                    tmp++;
                }
                visited[nr][nc] = true;
                queue.offer(new Node(nr, nc, node.value== 'W' ? 'B' : 'W'));
            }
        }

        return tmp;
    }

    static boolean isCheck(int nr, int nc){
        return 0<= nr && nr < SIZE && 0 <= nc && nc < SIZE;
    }

    static class Node{
        int r;
        int c;
        char value;
        public Node(int r, int c, char value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }
}
