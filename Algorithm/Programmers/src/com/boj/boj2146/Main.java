package com.boj.boj2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 2146 G3 다리 만들기
 */
public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;

    static int result = Integer.MAX_VALUE;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num == 1 ? -1 : 0;
            }
        }
        int tmp = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == -1){
                    setBoard(i, j, tmp);
                    tmp++;
                }
            }
        }

        result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] != 0){
                    getLength(i, j, board[i][j]);
                }

            }
        }

        System.out.println(result-1);
    }

    static void setBoard(int r, int c, int cnt){
        visited = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(r, c, 0));
        visited[r][c] = true;
        board[r][c] = cnt;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int pr = node.r;
            int pc = node.c;
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];

                if(!isCheck(nr,nc) || visited[nr][nc] || board[nr][nc] == cnt || board[nr][nc]==0)
                    continue;
                visited[nr][nc] = true;
                board[nr][nc] = cnt;
                queue.offer(new Node(nr, nc, 0));
            }
        }
    }

    static void getLength(int r, int c, int land){
        visited = new boolean[n][n];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r, c, 0));
        visited[r][c] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int pr = node.r;
            int pc = node.c;
            int pCnt = node.cnt;

            if(board[pr][pc] != 0 && board[pr][pc] != land){
                result = Math.min(result, pCnt);
                return;
            }

            if(pCnt > result)
                continue;

            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];

                if(!isCheck(nr,nc) || visited[nr][nc] || board[nr][nc] == land)
                    continue;
                visited[nr][nc] = true;
                queue.offer(new Node(nr, nc, pCnt+1));
            }
        }
    }

    static boolean isCheck(int r, int c){
        return  0 <= r && r < n && 0 <= c && c < n;
    }

    static class Node{
        int r;
        int c;
        int cnt;


        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}

/**
 * 육지 지점에서 나아갔을 때 마지막 지점이
 */
