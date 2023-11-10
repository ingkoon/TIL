package com.boj.boj7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, h;
    static int[] dh = {1, -1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 0 , 1, 0, -1};
    static int[] dc = {0, 0, 1, 0, -1, 0};
    static int[][][] tomatoes;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatoes = new int[h][n][m];
        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    tomatoes[i][j][k] = num;
                    if(num == 1){
                        queue.offer(new Tomato(i, j, k));
                    }
                }
            }
        }

        boolean flag = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(tomatoes[i][j][k] == 0){
                        flag = false;
                    }
                }
            }
        }
        if(flag){
            System.out.println(0);
            return;
        }
        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nh = tomato.h + dh[i];
                int nr = tomato.r + dr[i];
                int nc = tomato.c + dc[i];

                if(!isCheck(nh, nr, nc) || tomatoes[nh][nr][nc] != 0)
                    continue;
                tomatoes[nh][nr][nc] = tomatoes[tomato.h][tomato.r][tomato.c] + 1;
                queue.offer(new Tomato(nh, nr, nc));
            }
        }
        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(tomatoes[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(tomatoes[i][j][k], result);
                }
            }
        }
        for (int[][] tomato : tomatoes) {
            for (int[] ints : tomato) {
                System.out.println(Arrays.toString(ints));
            }
        }
        System.out.println(result-1);
    }

    static boolean isCheck(int ph, int pn, int pm){
        return 0 <= ph && ph < h && 0 <= pn && pn < n && 0 <= pm && pm < m;
    }

    static class Tomato{
        int h;
        int r;
        int c;

        public Tomato(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
}
