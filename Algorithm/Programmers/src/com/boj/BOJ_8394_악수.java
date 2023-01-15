package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8394_악수 {
    static int n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        dp = new int[n][2];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] %= 10;
            dp[i][0] %= 10;

        }
        System.out.println((dp[n-1][0] + dp[n-1][0]) %10);
    }
}
