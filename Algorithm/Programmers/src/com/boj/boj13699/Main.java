package com.boj.boj13699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, MAX = 35;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        dp = new long[MAX+1];

        dp[0] = 1L;
        dp[1] = 1L;
        dp[2] = 2L;
        for (int i = 3; i <= MAX; i++) {
            init(i);
        }
        System.out.println(dp[n]);
    }

    static void init(int idx){
        for (int i = 0; i < idx; i++) {
            Long tmp = dp[i] * dp[idx-1-i];
            dp[idx] += (dp[i] * dp[idx-1-i]);
        }
    }
}
