package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2098_외판원순회 {
    static int n;
    static int b;
    static int SIZE = Integer.MAX_VALUE;
    static int[][] w; // 가중치를 담는 2차원 배열
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        b = 1 << n -1;
        w = new int[n][n];
        dp = new int[n][b];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int tsp(int x, int check){
        if(check == b) {
            if(w[x][0] == 0) return SIZE;
            return w[x][0];
        }
        if(dp[x][check] == -1) return dp[x][check]; // 이미 방문한 도시

        dp[x][check] = SIZE;


        return 0;
    }
}
