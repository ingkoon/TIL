package com.boj.boj1743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k, answer;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            board[r][c] = 1; // 쓰레기가 있는 위치
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(visited[i][j] || board[i][j] == 0)
                    continue;
                answer = Math.max(answer, getSize(i, j));
            }
        }

        System.out.println(answer);
    }

    static int getSize(int r, int c){
        Queue<Loc> queue = new LinkedList<>();
        int result = 0;

        queue.offer(new Loc(r, c, 1));
        visited[r][c] = true;

        while (!queue.isEmpty()){
            result++;
            Loc cur = queue.poll();
            int pr = cur.r;
            int pc = cur.c;
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc] || board[nr][nc] == 0)
                    continue;
                visited[nr][nc] = true;
                queue.offer(new Loc(nr, nc, cur.size+1));
            }
        }
        return result;
    }


    static boolean isCheck(int r, int c){
        return 1 <= r && r <= n && 1 <= c && c <= m;
    }
    static class Loc{
        int r;
        int c;
        int size;

        public Loc(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }
    }
}
