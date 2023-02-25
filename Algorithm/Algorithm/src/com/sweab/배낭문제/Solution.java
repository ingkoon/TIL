package com.sweab.배낭문제;

import java.util.Scanner;

public class Solution {
    static int N;
    static int K;
    static int dp[][], w[], v[];
    static int ans;

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int T = scann.nextInt();
        for (int testcase = 1; testcase <= T; testcase++) {
            N = scann.nextInt();
            K = scann.nextInt();
            dp = new int[N + 1][K + 1];
            w = new int[101];
            v = new int[101];
            ans = 0;

            for (int i = 1; i <= N; i++) {
                int size = scann.nextInt();
                int value = scann.nextInt();
                w[i] = size;
                v[i] = value;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= K; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (w[i] <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i]] + v[i]);
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }

            System.out.println("#" + testcase + " " + dp[N][K]);
        }
    }
}