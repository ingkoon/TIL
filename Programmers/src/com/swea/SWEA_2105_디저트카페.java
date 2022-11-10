package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
    static int T, n, result;
    static int[][] board;
    static boolean[][] visited;
    static boolean[] num;
    static int SIZE = 101;


    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {-1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(bf.readLine());
            result = 0;
            board = new int[n][n];
            visited = new boolean[n][n];
            num = new boolean[SIZE];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bfs(i, j, i, j,0);
                    visited = new boolean[n][n];
                    num = new boolean[SIZE];
                }
            }
            result = result == 0 ? -1 : result;
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb);
        }
    }

    static void bfs(int r, int c, int pr, int pc, int size){
        visited[pr][pc] = true;
        num[board[pr][pc]] = true;
        for (int i = 0; i < 4; i++) {
            int nr = pr + dr[i];
            int nc = pc + dc[i];
            if(isRec(r, c, nr, nc) && size >= 3) { //다음 위치가 초기 위치와 같고 size가 4 이상일 경우
                result = Math.max(result, size+1);
                continue;
            }
            if(!isCheck(nr, nc) || visited[nr][nc] || num[board[nr][nc]]) continue;

            bfs(r, c, nr, nc, size+1); 
        }
    }

    static boolean isCheck(int nr, int nc){
        return 0<=nr && nr < n && 0 <= nc && nc < n;
    }
    static boolean isRec(int pr, int pc, int nr, int nc){
        return pr == nr && pc == nc;
    }
}
/*


7
7 4 1 5 1 7 9
9 4 6 1 4 6 8
9 6 4 8 4 7 4
3 2 6 2 4 2 8
4 9 4 6 2 4 7
1 7 6 8 9 5 8
1 9 4 7 2 9 7

* */