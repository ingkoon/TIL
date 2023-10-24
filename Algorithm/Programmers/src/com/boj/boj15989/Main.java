package com.boj.boj15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* BOJ 15989 1, 2, 3 더하기 4
*
* */
public class Main {
    static int T, n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        int[][] dp = new int[10001][4];

        dp[1][1] = 1; // 1로 끝나는 것은 1밖에 없다
        dp[2][1] = 1; // 1 + 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 1 + 1 + 1
        dp[3][2] = 1; // 1 + 2
        dp[3][3] = 1; // 3

        for (int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int t = 0; t < T; t++) {
           n = Integer.parseInt(bf.readLine());
           System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }

    }
}
