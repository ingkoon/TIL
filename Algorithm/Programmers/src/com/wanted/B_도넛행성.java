package com.wanted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_도넛행성 {
    static int r, c;
    static int[][] planet;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        planet = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < c; j++) {
                planet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(visited[i][j] || planet[i][j] != 0) continue;
                dfs(i, j);
                result++;
            }
        }
        System.out.println(result);
    }
    static void dfs(int pr, int pc){
        visited[pr][pc] = true;
        for (int i = 0; i < 4; i++) {
            int nr = checkR(pr, dr[i]);
            int nc = checkC(pc, dc[i]);
            if(visited[nr][nc] || planet[nr][nc] == 1) continue;
            dfs(nr, nc);
        }
    }

    static int checkR(int pr, int val){
        int tmp = pr + val;
        if(tmp == -1) return r-1;
        if(tmp == r) return 0;
        return tmp;
    }

    static int checkC(int pc, int val){
        int tmp = pc + val;
        if(tmp == -1) return c-1;
        if(tmp == c) return 0;
        return tmp;
    }

}

/*
5 6
1 1 1 1 1 1
1 0 0 0 1 1
1 1 1 1 0 0
1 1 1 1 0 0
1 1 1 1 1 1

2


7 8
0 0 1 1 0 0 0 0
0 1 1 1 1 0 1 0
1 1 1 1 1 1 1 1
0 1 1 1 1 1 0 0
1 1 0 0 0 1 0 0
0 1 0 0 0 1 0 1
0 0 1 1 1 1 0 0

2
 */