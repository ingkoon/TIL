package com.boj.BOJ_9461_파도반수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T, n;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        dp = new long[101];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        for (int i = 5; i <= 100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(bf.readLine());
            long result = dp[n-1];
            System.out.println(result);
        }
    }
}
