package com.boj.boj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][][]  visited;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0 ,-1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[2][n][m]; // 뚫었는지 안 뚫었는지에 대한 여부를 파악하기 위한 3차원 배열

        for (int i = 0; i < n; i++) {
            char[] tmp = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = tmp[j] - '0';
            }
        }


        int result = bfs(0, 0);

        System.out.println(result);
    }

    static int bfs(int r, int c){
        Queue<Loc> queue = new LinkedList<>();
        queue.offer( new Loc(1, r, c, 1));
        visited[1][r][c] = true;

        int result = - 1;
        while(!queue.isEmpty()){
            Loc loc = queue.poll();

            int pd = loc.d;
            int pr = loc.r;
            int pc = loc.c;
            int pCnt = loc.cnt;

            if(pr == n-1 && pc == m-1){
                result = pCnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(!isCheck(nr, nc) || (visited[pd][nr][nc]))
                    continue;
                visited[pd][nr][nc] = true;
                if(board[nr][nc] == 1){
                    if(pd == 1) queue.offer(new Loc(0, nr, nc, pCnt + 1));
                }
                else{
                    queue.offer(new Loc(pd, nr, nc, pCnt + 1));
                }
            }
        }

        return result;
    }
    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < n && 0 <= nc && nc < m;
    }

    static class Loc{
        int d;
        int r;
        int c;
        int cnt;
        public Loc(int d, int r, int c, int cnt) {
            this.d = d;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
